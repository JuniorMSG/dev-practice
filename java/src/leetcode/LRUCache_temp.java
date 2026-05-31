package src.leetcode;

import java.util.HashMap;

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
public class LRUCache_2 {

  // Doubly Linked List 노드.
  // key 까지 보관하는 이유: tail.prev 제거 시 map 에서도 같은 key 로 지워야 하므로.
  private static class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final HashMap<Integer, Node> map = new HashMap<>();
  private final Node head;
  private final Node tail;
  private final int capacity;

  // 필드
  // capacity  : 캐시 최대 용량 (불변)
  // map       : key → 노드 포인터 (O(1) 조회용)
  // head/tail : 더미 노드 (양 끝 좌표계 — null 분기 제거용)
  //             head 바로 뒤  = 가장 최근 사용
  //             tail 바로 앞  = 가장 오래됨 (LRU 제거 대상)
  LRUCache_2(int capacity) {
    this.capacity = capacity;
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    this.head.next = tail;
    this.tail.prev = head;
  }

  // 헬퍼
  // addToFront  : 신규 노드를 head 바로 뒤(최근 자리)에 삽입
  // remove      : 임의 노드를 리스트에서 떼기 (재사용 도구)
  // moveToFront : 기존 노드를 최근 자리로 이동 (remove + addToFront)
  //
  // addToFront 순서 황금률:
  //   "기존 연결을 끊기 전에 새 노드의 양쪽 화살표를 먼저 세팅"
  //   → head.next = node 는 무조건 마지막 (먼저 하면 옛 첫 노드 참조 잃음)
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

  // get : key 조회 → 있으면 moveToFront + value 반환 / 없으면 -1
  // put : 3가지 분기
  //   ① 있으면         → value 갱신 + moveToFront
  //   ② 없으면         → 신규 추가 (map.put + addToFront)
  //   ③ size > capacity → tail.prev 제거 (map + DLL 둘 다)
  public int get(int key) {
    Node node = map.get(key);
    if(node == null) return -1;

    moveToFront(node);
    return node.value;
  }

  public void put(int key, int value) {
    Node lru = map.get(key);
    if(lru != null) {
      lru.value = value;
      moveToFront(lru);
    } else {
      Node newNode = new Node(key, value);
      map.put(key, newNode);
      addToFront(newNode);
    }

    if(map.size() > capacity){
      Node lastNode = tail.prev;
      map.remove(lastNode.key);
      remove(lastNode);
    }

  }

  public static void main(String[] args) {
    // TC 1: 기본 시나리오 (LeetCode 예제)
    LRUCache_2 cache = new LRUCache_2(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println("get(1) = " + cache.get(1));   // 1
    cache.put(3, 3);                                  // key=2 제거 (LRU)
    System.out.println("get(2) = " + cache.get(2));   // -1
    cache.put(4, 4);                                  // key=1 제거
    System.out.println("get(1) = " + cache.get(1));   // -1
    System.out.println("get(3) = " + cache.get(3));   // 3
    System.out.println("get(4) = " + cache.get(4));   // 4

    // TC 2: 동일 key 갱신
    LRUCache_2 cache2 = new LRUCache_2(2);
    cache2.put(1, 1);
    cache2.put(1, 99);                  // 갱신
    System.out.println("get(1) = " + cache2.get(1));  // 99

    // TC 3: capacity 1
    LRUCache_2 cache3 = new LRUCache_2(1);
    cache3.put(1, 1);
    cache3.put(2, 2);
    System.out.println("get(1) = " + cache3.get(1));  // -1
    System.out.println("get(2) = " + cache3.get(2));  // 2
  }

}
