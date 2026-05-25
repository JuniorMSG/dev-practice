package src.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 * <p>
 * 문제:
 * LRU (Least Recently Used) 캐시 구현
 * - LRUCache(int capacity): 용량 capacity 캐시 초기화
 * - int get(int key):      key 존재 → value 반환 + "최근 사용" 표시 / 없으면 -1
 * - void put(int key, int value): 있으면 갱신 + "최근 사용" 표시
 * 없으면 추가, 용량 초과 시 LRU(가장 오래 안 쓴) 제거
 * <p>
 * 제약:
 * - get / put 둘 다 평균 O(1)
 * - 1 <= capacity <= 3000
 * <p>
 * 핵심 아이디어:
 * - O(1) 접근       → HashMap (key → 노드)
 * - O(1) 순서 갱신  → Doubly Linked List (head=최근, tail=오래됨)
 * - 두 자료구조를 같은 노드로 연결해서 둘 다 O(1) 보장
 * <p>
 * 시간복잡도: get O(1), put O(1)
 * 공간복잡도: O(capacity)
 */
public class LRUCache {

  // TODO: Node 클래스 (key, value, prev, next)
  private static class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  // TODO: 필드
  //   - capacity
  //   - HashMap<Integer, Node>
  //   - head, tail (더미 노드 권장)
  private final int capacity;
  private final Map<Integer, Node> map = new HashMap<>();   // import java.util.*
  private final Node head = new Node(0, 0);                  // 더미
  private final Node tail = new Node(0, 0);                  // 더미

  public LRUCache(int capacity) {
    // TODO: 초기화
    //   - 더미 head/tail 연결 (head <-> tail)
    this.capacity = capacity;
    this.head.next = tail;
    this.tail.prev = head;
  }

  public int get(int key) {
    // TODO:
    //   1. map에 key 없으면 -1
    //   2. 노드 찾아서 → 리스트에서 떼고 → head 바로 뒤로 이동
    //   3. value 반환
    Node node = map.get(key);
    if (node == null) return -1;

    moveToFront(node);
    return node.value;
  }

  public void put(int key, int value) {
    // TODO:
    //   1. 이미 있으면 → value 갱신 + head 앞으로 이동
    //   2. 없으면 → 새 노드 생성, map+리스트에 추가
    //   3. size > capacity → tail 바로 앞 노드 제거 (map에서도 제거)
    Node node = map.get(key);

    if (node == null) {
      Node newNode = new Node(key, value);
      map.put(key, newNode);
      addToFront(newNode);
    } else {
      node.value = value;
      moveToFront(node);
      return;
    }

    if (map.size() > capacity) {
      Node lru = tail.prev;
      remove(lru);
      map.remove(lru.key);
    }

  }

  // ===== 헬퍼 메서드 (직접 구현해보기) =====
  private void addToFront(Node node) {
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
  }

  private void remove(Node node) {
    node.next.prev = node.prev;
    node.prev.next = node.next;
  }

  private void moveToFront(Node node) {
    remove(node);
    addToFront(node);
  }

  public static void main(String[] args) {
    // TC 1: 기본 시나리오 (LeetCode 예제)
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println("get(1) = " + cache.get(1));   // 1
    cache.put(3, 3);                                  // key=2 제거 (LRU)
    System.out.println("get(2) = " + cache.get(2));   // -1
    cache.put(4, 4);                                  // key=1 제거
    System.out.println("get(1) = " + cache.get(1));   // -1
    System.out.println("get(3) = " + cache.get(3));   // 3
    System.out.println("get(4) = " + cache.get(4));   // 4

    // TC 2: 동일 key put → 갱신 + 최근 사용 표시
    // TC 3: capacity 1 (엣지)
  }
}
