package src.boj.dfs;

import java.util.*;

// 백준 1260 - DFS와 BFS (실버 2)
// https://www.acmicpc.net/problem/1260
// 시간제한: 2초 | 메모리제한: 128MB
//
// 문제: 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
// 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
// 입력: 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
// 출력: 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
//
// 예제 입력:
// 4 5 1
// 1 2
// 1 3
// 1 4
// 2 4
// 3 4
//
// 예제 출력:
// 1 2 4 3
// 1 2 3 4
public class DFS_S2_BOJ1260_1_COM {
    // 분석
    // TODO : 문제 분석
    // 장르 : DFS - 그래프
    // DFS + BFS
    // 입력 : 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
    //       다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
    // DFS : 1-indexed
    // 출력: 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.

    // TODO 0. 변수선언
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int N, M, V;

    public static void main(String[] args) {
        // TODO 1. 변수 초기화 및 입력
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        graph = new ArrayList<>();
        visited = new boolean[N+1];

        // TODO 2. 간선 입력 및 그래프 입력
        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<M+1; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 작은정점 기준으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // TODO 3. DFS 로직 구현 및 실행
        // dfs를 시작정점 V로 호출
        dfs(V);

        // TODO 4. BFS 로직 구현 및 실행
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }

    public static void dfs(int x) {
        visited[x] = true;
        // 내부 출력
        System.out.print(x + " ");
        for(int next : graph.get(x)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int next : graph.get(x)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
