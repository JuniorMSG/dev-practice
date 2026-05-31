package src.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LeetCode 460. LFU Cache
 * https://leetcode.com/problems/lfu-cache/
 * <p>
 * 문제:
 * LFU (Least Frequently Used) 캐시 구현
 * - LFUCache(int capacity): 용량 초기화
 * - int get(int key):      key 존재 → value 반환 + freq+1 / 없으면 -1
 * - void put(int key, int value):
 * 있으면 → value 갱신 + freq+1
 * 없으면 → 새 노드 (freq=1)
 * 용량 초과 시 → 최소 freq 중 가장 오래된 노드 제거 (freq 동률 시 LRU)
 * <p>
 * 제약:
 * - get / put 둘 다 평균 O(1)
 * <p>
 * 핵심 아이디어:
 * - HashMap<key, Node>                  : O(1) 노드 조회
 * - HashMap<freq, LinkedHashSet<Node>>  : 같은 freq 노드 묶음 (순서 유지 = LRU)
 * - int minFreq                         : 현재 최소 freq 추적 (제거 대상 즉시 접근)
 * <p>
 * Node: key, value, freq
 * <p>
 * 시간복잡도: get O(1), put O(1)
 * 공간복잡도: O(capacity)
 * <p>
 * LRU 와 차이:
 * LRU: HashMap + DLL 1개, 시간 기준
 * LFU: HashMap × 2 + DLL N개, 빈도 기준 + minFreq
 */
public class LFUCache_1 {

  // TODO 1: Node 클래스
  //   - 필드: key, value, freq, (prev, next 옵션 — LinkedHashSet 쓰면 불필요)
  //   - 생성자: 새 노드는 freq=1 로 시작
  private static class Node {
    int key;
    int value;
    int freq;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.freq = 1;   // 새 노드는 항상 freq=1
    }
  }

  // TODO 2: 필드 선언
  //   - capacity: 최대 용량
  //   - size: 현재 크기
  //   - minFreq: 최소 빈도 추적
  //   - keyToNode: Map<Integer, Node>
  //   - freqToList: Map<Integer, LinkedHashSet<Node>>
  private final int capacity;
  private int size;
  private int minFreq;
  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, LinkedHashSet<Node>> freqToList = new HashMap<>();

  // TODO 3: 생성자
  //   - capacity 저장
  //   - size = 0, minFreq = 0 초기화
  public LFUCache_1(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.minFreq = 0;
  }

  // TODO 4: 헬퍼 touch(Node node)
  //   "노드 호출 시 freq 증가 처리"
  //   ① 옛 freq 묶음에서 제거
  //   ② 옛 묶음 비었고 == minFreq 면 minFreq++
  //   ③ freq+1, 새 freq 묶음에 추가 (LinkedHashSet)
  //
  //   힌트: computeIfAbsent 로 새 묶음 생성
  public void touch(Node node){
    int oldFreq = node.freq;
    LinkedHashSet<Node> oldList = freqToList.get(oldFreq);
    oldList.remove(node);
    if (oldList.isEmpty()) {
      freqToList.remove(oldFreq);
      if (minFreq == oldFreq) {
        minFreq++;
      }
    }
    node.freq++;
    freqToList.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node);
  }

  // TODO 5: get(int key)
  //   ① keyToNode 에서 노드 찾기
  //   ② 없으면 -1
  //   ③ 있으면 touch + value 반환
  public int get(int key){
    Node node = keyToNode.get(key);
    if(node == null) return -1;
    touch(node);
    return node.value;
  }

  public void put(int key, int value){

    // 1. 케파가 0 이하면 아무것도 하지 않음.
    if (capacity <= 0) return;

    // 2. 이미 있는 key 면 value 갱신 + touch (freq 증가)
    Node existing = keyToNode.get(key);
    if (existing != null) {
      existing.value = value;
      touch(existing);
      return;
    }

    // 3. 신규 추가 — 현재 사이즈가 케파시티와 같거나 크면 최소 호출된 항목을 삭제함 .
    if (size >= capacity) {
      LinkedHashSet<Node> minList = freqToList.get(minFreq);
      Node victim = minList.iterator().next();  // LRU
      minList.remove(victim);
      keyToNode.remove(victim.key);
      if (minList.isEmpty()) {
        freqToList.remove(minFreq);
      }
      size--;
    }

    // 새 노드 추가
    Node newNode = new Node(key, value);
    keyToNode.put(key, newNode);
    freqToList.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
    minFreq = 1;
    size++;
  }


  // TODO 6: put(int key, int value)
  //   엣지: capacity <= 0 → return
  //
  //   case 1 (이미 있음):
  //     value 갱신 + touch
  //
  //   case 2 (신규):
  //     - size >= capacity 면:
  //       freqToList[minFreq] 의 가장 오래된 노드 제거 (iterator.next())
  //       keyToNode 에서도 제거
  //       묶음 비면 freqToList 에서도 제거
  //       size--
  //     - 새 Node 생성 (freq=1)
  //     - keyToNode 추가
  //     - freqToList[1] 에 추가
  //     - minFreq = 1 reset
  //     - size++

  public static void main(String[] args) {
    // ===== TC 1: LeetCode 460 공식 예제 =====
    LFUCache_1 cache = new LFUCache_1(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println("get(1) = " + cache.get(1));     // 1   (1 freq=2, 2 freq=1)
    cache.put(3, 3);                                     // 2 제거 (freq 1)
    System.out.println("get(2) = " + cache.get(2));     // -1
    System.out.println("get(3) = " + cache.get(3));     // 3   (3 freq=2)
    cache.put(4, 4);                                     // 1 제거 (freq=2 동률, 1이 더 옛것)
    System.out.println("get(1) = " + cache.get(1));     // -1
    System.out.println("get(3) = " + cache.get(3));     // 3
    System.out.println("get(4) = " + cache.get(4));     // 4

    System.out.println();

    // ===== TC 2: 동일 key 갱신 =====
    LFUCache_1 c2 = new LFUCache_1(2);
    c2.put(1, 1);
    c2.put(1, 99);    // 갱신
    System.out.println("get(1) = " + c2.get(1));        // 99

    // ===== TC 3: capacity 0 (엣지) =====
    LFUCache_1 c3 = new LFUCache_1(0);
    c3.put(1, 1);
    System.out.println("get(1) = " + c3.get(1));        // -1

    // ===== TC 4: 빈도 동률 + LRU 정책 =====
    LFUCache_1 c4 = new LFUCache_1(3);
    c4.put(1, 1);
    c4.put(2, 2);
    c4.put(3, 3);
    c4.get(1);                  // 1 freq=2
    c4.get(2);                  // 2 freq=2
    c4.put(4, 4);               // freq=1 인 3 제거
    System.out.println("get(3) = " + c4.get(3));        // -1
    System.out.println("get(1) = " + c4.get(1));        // 1
  }
}
