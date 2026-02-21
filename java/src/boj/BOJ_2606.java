package src.boj;

/**
 * BOJ 2606 - 바이러스 (실버 3)
 * 분류: DFS, 그래프
 * <p>
 * [문제 분석]
 * - 1번 컴퓨터가 바이러스에 걸림
 * - 연결된 컴퓨터는 전부 감염
 * - 1번을 통해 감염되는 컴퓨터 수 출력 (1번 제외)
 * - 무방향 그래프
 * <p>
 * [TODO]
 * 1. N, M 입력
 * 2. 인접리스트 + visited 초기화
 * 3. M번 반복으로 간선 입력 (양방향)
 * 4. 1번부터 DFS 실행
 * 5. visited에서 true 개수 - 1 (자기 자신 제외) 출력
 */

import java.util.*;

public class BOJ_2606 {
  static int N, M;
  static ArrayList<ArrayList<Integer>> graph;
  static boolean[] visited;
  static int count = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // MSG가 여기부터 채우기
    N = sc.nextInt();
    M = sc.nextInt();

    visited = new boolean[N + 1];
    graph = new ArrayList<>();

    for (int i = 0; i <= N; i++) {       // ← 간선 입력 전에, N+1개
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    dfs(1);
    System.out.println(count - 1);
  }

  public static void dfs(int start) {
    visited[start] = true;
    for (int next : graph.get(start)) {
      if (!visited[next]) dfs(next);
    }
    count++;
  }
}
