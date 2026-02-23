package src.boj.dfs;

// 백준 24479 - 알고리즘 수업 - 깊이 우선 탐색 1 (실버 2)
// 시간제한: 1초 | 메모리제한: 512MB
//
// 문제
// N개의 정점과 M개의 간선으로 구성된 무방향 그래프가 주어진다. 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다.
// 정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.
// 인접 정점은 오름차순으로 방문한다.
//
// 입력
// 첫째 줄에 정점의 수 N (5 <= N <= 100,000), 간선의 수 M (1 <= M <= 200,000), 시작 정점 R (1 <= R <= N)이 주어진다.
// 다음 M개의 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다.
//
// 출력
// 첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다. i번째 줄에는 정점 i의 방문 순서를 출력한다.
// 시작 정점의 방문 순서는 1이다. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.
//
/* 예제 입력:
5 5 1
1 4
1 2
2 3
2 4
3 4
*/
// 예제 출력:
// 1
// 2
// 3
// 4
// 0

import java.util.*;
public class DFS_S2_BOJ24479_1_COM {

    // TODO: 문제분석 : N개의 정점과 M개의 간선으로 구성된 무방향 그래프 (DFS-> 입력 양방향)
    // TODO: 문제유형 : DFS, Graph, 입력 양방향 , 정점 번호는 1번부터 시작 - 1-indexed로 구현
    // TODO: 입력 : N (100,000) / M (200,000) / R ( 1 <= R <= N) M개의 줄에 간선 정보 u, v 주어짐
    // TODO: 특이사항 시작정점 R로 고정됨

    // TODO: 출력 : 시작정점 기준으로 방문하는데 오름차순 기준으로.. (정렬필요)
    // TODO: 시간복잡도 100,000 + 200,000 = 여유 O(n+m)

    // TODO: 0. 변수선언
    static int N, M, R;
    static int[] order;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        // TODO 1. 변수 입력 및 초기화
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        R = scan.nextInt();
        order = new int[N+1];
        visited = new boolean[N+1];

        // TODO 2. 그래프 초기화 및 입력
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // TODO 3. 오름차순 정렬  및 DFS 호출 및 구현
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        dfs(R);

        // TODO 4. 정렬 및 출력
        for(int i=1; i<=N; i++){
            System.out.println(order[i]);
        }

    }

    public static void dfs(int node) {
        visited[node] = true;
        order[node] = ++count;
        for(int next: graph.get(node)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
