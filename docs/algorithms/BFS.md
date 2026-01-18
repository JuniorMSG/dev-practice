# BFS (너비 우선 탐색)

> 한 줄 요약: 그래프의 가까운 노드부터 탐색하며, 최단 거리 문제에 최적화된 알고리즘

## 📌 목차
- [개요](#개요)
- [동작 원리](#동작-원리)
- [시간/공간 복잡도](#시간공간-복잡도)
- [구현 (Java)](#구현-java)
- [구현 (Kotlin)](#구현-kotlin)
- [적용 문제 유형](#적용-문제-유형)
- [최적화 기법](#최적화-기법)
- [관련 알고리즘](#관련-알고리즘)

---

## 개요

### 문제 상황
- **어떤 문제를 해결하는가?**
  - 그래프의 모든 노드를 탐색
  - 시작점에서 특정 노드까지의 최단 거리 찾기
  - 레벨별 탐색이 필요한 경우

- **입력과 출력**
  - 입력: 그래프(인접 리스트/행렬), 시작 노드
  - 출력: 방문 순서, 최단 거리, 경로 등

### 핵심 아이디어
- **큐(Queue)를 사용하여 레벨별로 탐색**
- 시작 노드에서 가까운 노드부터 차례대로 방문
- 한 번 방문한 노드는 다시 방문하지 않음 (visited 배열)

### 언제 사용하는가?

#### ✅ 적합한 상황
- 최단 거리/최소 이동 횟수 구하기
- 레벨별 탐색 (트리의 레벨 순회)
- 연결된 컴포넌트 찾기
- 미로 탈출 (가중치 없는 그래프)

#### ❌ 부적합한 상황
- 모든 경로를 탐색해야 하는 경우 (DFS가 더 적합)
- 가중치가 있는 그래프의 최단 경로 (다익스트라 사용)
- 메모리가 제한적인 경우 (DFS가 더 효율적)

---

## 동작 원리

### 단계별 설명

#### Step 1: 초기화
```
1. 시작 노드를 큐에 삽입
2. 시작 노드를 방문 처리 (visited = true)
3. 거리 배열 초기화 (필요시)
```

#### Step 2: 큐에서 노드 꺼내기
```
1. 큐에서 노드를 하나 꺼냄 (poll)
2. 해당 노드의 모든 인접 노드 확인
```

#### Step 3: 인접 노드 처리
```
1. 방문하지 않은 인접 노드를 큐에 삽입
2. 해당 노드를 방문 처리
3. 거리 업데이트 (필요시)
```

#### Step 4: 반복
```
큐가 빌 때까지 Step 2-3 반복
```

### 시각화 예제

```
그래프:
    1
   / \
  2   3
 / \   \
4   5   6

BFS 탐색 과정:

초기: Queue = [1], Visited = {1}

Level 0:
  - 1 방문
  - Queue = [2, 3], Visited = {1, 2, 3}

Level 1:
  - 2 방문 → 4, 5 추가
  - Queue = [3, 4, 5], Visited = {1, 2, 3, 4, 5}
  - 3 방문 → 6 추가
  - Queue = [4, 5, 6], Visited = {1, 2, 3, 4, 5, 6}

Level 2:
  - 4, 5, 6 순서대로 방문
  - Queue = []

방문 순서: 1 → 2 → 3 → 4 → 5 → 6
```

---

## 시간/공간 복잡도

| 케이스 | 시간 복잡도 | 공간 복잡도 |
|--------|-----------|-----------|
| 인접 리스트 | O(V + E) | O(V) |
| 인접 행렬 | O(V²) | O(V) |

- **V**: 노드(정점)의 개수
- **E**: 간선의 개수

### 복잡도 분석
- **시간 복잡도**:
  - 모든 노드를 한 번씩 방문: O(V)
  - 모든 간선을 확인: O(E)
  - 총 시간: O(V + E)

- **공간 복잡도**:
  - 큐에 저장되는 최대 노드 수: O(V)
  - visited 배열: O(V)
  - 총 공간: O(V)

---

## 구현 (Java)

### 기본 구현 (인접 리스트)
```java
import java.util.*;

public class BFS {
    /**
     * BFS를 사용하여 그래프 탐색
     * @param graph 인접 리스트로 표현된 그래프
     * @param start 시작 노드
     * @return 방문 순서 리스트
     */
    public List<Integer> bfs(List<List<Integer>> graph, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();

        // 시작 노드 처리
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            // 인접 노드 탐색
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return result;
    }
}
```

### 최단 거리 구하기
```java
public class ShortestPath {
    /**
     * 시작 노드에서 각 노드까지의 최단 거리 계산
     * @param graph 인접 리스트
     * @param start 시작 노드
     * @return 각 노드까지의 최단 거리 배열
     */
    public int[] getShortestDistance(List<List<Integer>> graph, int start) {
        int n = graph.size();
        int[] distance = new int[n];
        Arrays.fill(distance, -1);  // -1: 방문 불가

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph.get(node)) {
                if (distance[next] == -1) {  // 아직 방문하지 않음
                    distance[next] = distance[node] + 1;
                    queue.offer(next);
                }
            }
        }

        return distance;
    }
}
```

### 2D 그리드 BFS (미로 탐색)
```java
public class GridBFS {
    // 상하좌우 이동
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    /**
     * 2D 그리드에서 BFS
     * @param grid 2차원 배열 (0: 이동 가능, 1: 벽)
     * @param startX 시작 x 좌표
     * @param startY 시작 y 좌표
     * @return 각 칸까지의 최단 거리
     */
    public int[][] bfsGrid(int[][] grid, int startX, int startY) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];

        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        distance[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크 및 방문 가능 여부 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && grid[nx][ny] == 0 && distance[nx][ny] == -1) {
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return distance;
    }
}
```

---

## 구현 (Kotlin)

### 기본 구현
```kotlin
import java.util.*

class BFS {
    /**
     * BFS를 사용하여 그래프 탐색
     * @param graph 인접 리스트로 표현된 그래프
     * @param start 시작 노드
     * @return 방문 순서 리스트
     */
    fun bfs(graph: List<List<Int>>, start: Int): List<Int> {
        val result = mutableListOf<Int>()
        val visited = BooleanArray(graph.size)
        val queue: Queue<Int> = LinkedList()

        queue.offer(start)
        visited[start] = true

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            result.add(node)

            for (next in graph[node]) {
                if (!visited[next]) {
                    visited[next] = true
                    queue.offer(next)
                }
            }
        }

        return result
    }
}
```

### 최단 거리 (Kotlin 스타일)
```kotlin
fun getShortestDistance(graph: List<List<Int>>, start: Int): IntArray {
    val distance = IntArray(graph.size) { -1 }
    val queue: Queue<Int> = LinkedList()

    queue.offer(start)
    distance[start] = 0

    while (queue.isNotEmpty()) {
        val node = queue.poll()

        graph[node].forEach { next ->
            if (distance[next] == -1) {
                distance[next] = distance[node] + 1
                queue.offer(next)
            }
        }
    }

    return distance
}
```

### 2D 그리드 BFS (data class 활용)
```kotlin
data class Position(val x: Int, val y: Int)

class GridBFS {
    private val directions = listOf(
        Position(-1, 0), Position(1, 0),
        Position(0, -1), Position(0, 1)
    )

    fun bfsGrid(grid: Array<IntArray>, start: Position): Array<IntArray> {
        val n = grid.size
        val m = grid[0].size
        val distance = Array(n) { IntArray(m) { -1 } }
        val queue: Queue<Position> = LinkedList()

        queue.offer(start)
        distance[start.x][start.y] = 0

        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()

            directions.forEach { (dx, dy) ->
                val nx = x + dx
                val ny = y + dy

                if (nx in 0 until n && ny in 0 until m
                    && grid[nx][ny] == 0 && distance[nx][ny] == -1) {
                    distance[nx][ny] = distance[x][y] + 1
                    queue.offer(Position(nx, ny))
                }
            }
        }

        return distance
    }
}
```

---

## 적용 문제 유형

### 패턴 1: 최단 거리/최소 이동

**문제 특징:**
- "최소 몇 번 만에", "최단 거리" 같은 키워드
- 가중치가 없는 그래프

**예시 문제:**
```
문제: 미로 탈출 (백준 2178)
입력: N×M 미로, (1,1)에서 (N,M)으로 이동
출력: 최소 이동 칸 수
```

**솔루션:**
```java
public int mazeBFS(int[][] maze) {
    int n = maze.length;
    int m = maze[0].length;
    int[][] distance = new int[n][m];

    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{0, 0});
    distance[0][0] = 1;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    while (!queue.isEmpty()) {
        int[] pos = queue.poll();
        int x = pos[0], y = pos[1];

        if (x == n - 1 && y == m - 1) {
            return distance[x][y];
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                && maze[nx][ny] == 1 && distance[nx][ny] == 0) {
                distance[nx][ny] = distance[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    return -1;
}
```

### 패턴 2: 레벨별 처리

**문제 특징:**
- 단계별로 처리해야 하는 문제
- "몇 번째 단계", "레벨" 같은 개념

**예시 문제:**
```
문제: 이진 트리의 레벨 순회
각 레벨별로 노드를 묶어서 출력
```

**솔루션:**
```kotlin
data class TreeNode(
    val value: Int,
    val left: TreeNode? = null,
    val right: TreeNode? = null
)

fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val result = mutableListOf<List<Int>>()
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val currentLevel = mutableListOf<Int>()

        repeat(levelSize) {
            val node = queue.poll()
            currentLevel.add(node.value)

            node.left?.let { queue.offer(it) }
            node.right?.let { queue.offer(it) }
        }

        result.add(currentLevel)
    }

    return result
}
```

### 패턴 3: 연결 요소 찾기

**문제 특징:**
- 연결된 그룹 찾기
- 섬의 개수, 영역 구하기

**예시 문제:**
```
문제: 섬의 개수 (백준 4963)
1은 땅, 0은 바다. 연결된 땅의 개수 구하기
```

**솔루션:**
```java
public int countIslands(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    boolean[][] visited = new boolean[n][m];
    int count = 0;

    int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};  // 8방향
    int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                // 새로운 섬 발견
                count++;

                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    int x = pos[0], y = pos[1];

                    for (int k = 0; k < 8; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m
                            && grid[nx][ny] == 1 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }

    return count;
}
```

---

## 최적화 기법

### 1. 조기 종료 (Early Exit)
```java
// 목표 노드를 찾으면 바로 종료
public int findShortestPath(List<List<Integer>> graph, int start, int target) {
    Queue<Integer> queue = new LinkedList<>();
    int[] distance = new int[graph.size()];
    Arrays.fill(distance, -1);

    queue.offer(start);
    distance[start] = 0;

    while (!queue.isEmpty()) {
        int node = queue.poll();

        if (node == target) {
            return distance[node];  // 조기 종료
        }

        for (int next : graph.get(node)) {
            if (distance[next] == -1) {
                distance[next] = distance[node] + 1;
                queue.offer(next);
            }
        }
    }

    return -1;
}
```

### 2. 양방향 BFS
```kotlin
// 시작점과 끝점에서 동시에 BFS
fun bidirectionalBFS(graph: List<List<Int>>, start: Int, end: Int): Int {
    if (start == end) return 0

    val visitedFromStart = mutableMapOf(start to 0)
    val visitedFromEnd = mutableMapOf(end to 0)

    val queueStart: Queue<Int> = LinkedList(listOf(start))
    val queueEnd: Queue<Int> = LinkedList(listOf(end))

    var level = 0

    while (queueStart.isNotEmpty() || queueEnd.isNotEmpty()) {
        level++

        // 시작점에서 탐색
        repeat(queueStart.size) {
            val node = queueStart.poll()

            for (next in graph[node]) {
                if (next in visitedFromEnd) {
                    return level + visitedFromEnd[next]!!
                }
                if (next !in visitedFromStart) {
                    visitedFromStart[next] = level
                    queueStart.offer(next)
                }
            }
        }

        // 끝점에서 탐색
        repeat(queueEnd.size) {
            val node = queueEnd.poll()

            for (next in graph[node]) {
                if (next in visitedFromStart) {
                    return level + visitedFromStart[next]!!
                }
                if (next !in visitedFromEnd) {
                    visitedFromEnd[next] = level
                    queueEnd.offer(next)
                }
            }
        }
    }

    return -1
}
```

### 3. 메모리 최적화 (visited 대신 거리 배열 활용)
```java
// visited 배열 없이 distance == -1로 확인
public int[] bfsOptimized(List<List<Integer>> graph, int start) {
    int n = graph.size();
    int[] distance = new int[n];
    Arrays.fill(distance, -1);  // -1 = 미방문

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    distance[start] = 0;

    while (!queue.isEmpty()) {
        int node = queue.poll();

        for (int next : graph.get(node)) {
            if (distance[next] == -1) {  // visited 체크 불필요
                distance[next] = distance[node] + 1;
                queue.offer(next);
            }
        }
    }

    return distance;
}
```

---

## 주의사항

### ⚠️ 흔한 실수

1. **실수 1: 큐에 넣을 때 방문 체크를 안 함**
   ```java
   // ❌ 잘못된 코드
   while (!queue.isEmpty()) {
       int node = queue.poll();
       visited[node] = true;  // 여기서 체크하면 중복 추가됨!

       for (int next : graph.get(node)) {
           if (!visited[next]) {
               queue.offer(next);
           }
       }
   }
   ```
   문제점: 같은 노드가 큐에 여러 번 들어갈 수 있음

   ```java
   // ✅ 올바른 코드
   while (!queue.isEmpty()) {
       int node = queue.poll();

       for (int next : graph.get(node)) {
           if (!visited[next]) {
               visited[next] = true;  // 큐에 넣을 때 방문 체크!
               queue.offer(next);
           }
       }
   }
   ```
   해결: 큐에 삽입하기 전에 방문 처리

2. **실수 2: 배열 범위 체크 누락**
   ```java
   // ❌ 인덱스 범위 체크 안 함
   int nx = x + dx[i];
   int ny = y + dy[i];
   if (grid[nx][ny] == 0) {  // ArrayIndexOutOfBoundsException!
   ```

   ```java
   // ✅ 범위 체크 먼저
   int nx = x + dx[i];
   int ny = y + dy[i];
   if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0) {
   ```

3. **실수 3: 시작 노드 방문 처리 누락**
   ```java
   // ❌ 시작 노드 방문 체크 안 함
   queue.offer(start);
   // visited[start] = true 누락!
   ```

### 💡 팁

- **큐에 넣을 때 바로 방문 체크**: 중복 방지
- **레벨별 처리**: `int size = queue.size()` 활용
- **좌표 이동**: dx, dy 배열 미리 정의
- **디버깅**: 각 단계마다 큐 상태 출력
- **2D 배열**: `int[]` 대신 `Position` 클래스 사용 (가독성)

### Edge Cases
- [ ] 시작 노드 == 목표 노드
- [ ] 그래프가 비어있는 경우
- [ ] 연결되지 않은 그래프
- [ ] 모든 노드가 벽인 경우 (그리드)
- [ ] 사이클이 있는 그래프

---

## 관련 알고리즘

### 비슷한 알고리즘
- **DFS (깊이 우선 탐색)** - 스택/재귀 사용, 모든 경로 탐색에 유리
- **다익스트라** - 가중치 있는 그래프의 최단 경로
- **A* 알고리즘** - 휴리스틱을 사용한 최적화된 경로 탐색

### BFS vs DFS 비교

| 특징 | BFS | DFS |
|-----|-----|-----|
| 자료구조 | 큐 (Queue) | 스택 (Stack) / 재귀 |
| 탐색 순서 | 레벨별 (너비) | 깊이 우선 |
| 최단 경로 | ✅ 보장 | ❌ 보장 안 됨 |
| 메모리 | 많이 사용 | 적게 사용 |
| 적합한 경우 | 최단 거리 | 모든 경로 탐색 |

### 함께 사용되는 기법
- **위상 정렬** - BFS 기반
- **플러드 필** - 영역 채우기
- **최소 신장 트리** - 프림 알고리즘

---

## 연습 문제

### 난이도별 추천 문제

#### 🟢 Easy
1. [백준 1926 - 그림](https://www.acmicpc.net/problem/1926) - 연결 요소 개수와 크기
2. [백준 2178 - 미로 탐색](https://www.acmicpc.net/problem/2178) - 기본 최단 경로
3. [프로그래머스 - 게임 맵 최단거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844) - 2D BFS 기본

#### 🟡 Medium
1. [백준 7576 - 토마토](https://www.acmicpc.net/problem/7576) - 다중 시작점 BFS
2. [백준 1697 - 숨바꼭질](https://www.acmicpc.net/problem/1697) - 1차원 BFS
3. [백준 7569 - 토마토 3D](https://www.acmicpc.net/problem/7569) - 3차원 BFS
4. [백준 2206 - 벽 부수고 이동하기](https://www.acmicpc.net/problem/2206) - 상태를 포함한 BFS

#### 🔴 Hard
1. [백준 16933 - 벽 부수고 이동하기 3](https://www.acmicpc.net/problem/16933) - 복잡한 상태 관리
2. [백준 9019 - DSLR](https://www.acmicpc.net/problem/9019) - 경로 역추적
3. [백준 1525 - 퍼즐](https://www.acmicpc.net/problem/1525) - BFS + 해싱

### 문제 풀이 체크리스트
- [ ] 기본 BFS 구현 (그래프)
- [ ] 2D 그리드 BFS (4방향)
- [ ] 다중 시작점 BFS
- [ ] 레벨별 처리 BFS
- [ ] 상태를 포함한 BFS (3차원 visited)
- [ ] 경로 역추적

---

## 참고 자료

### 추천 학습 자료
- [바킹독 BFS 강의](https://blog.encrypted.gg/941) - 한국어 설명
- [알고리즘 문제해결전략](http://www.yes24.com/Product/Goods/8006522) - 종만북

---

**작성일:** 2026-01-18
**최종 수정일:** 2026-01-18
**작성자:** 민순기
