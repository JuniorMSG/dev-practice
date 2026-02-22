package src.boj.dfs;


// 백준 11725 - 트리의 부모 찾기 (실버 2)
// 시간제한: 1초 | 메모리제한: 256MB
//
// 문제: 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
// 입력: 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
// 출력: 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
//
// 예제 입력:
// 7
// 1 6
// 6 3
// 3 5
// 4 1
// 2 4
// 4 7
//
// 예제 출력:
// 4
// 6
// 1
// 3
// 1
// 4


import java.util.*;
public class DFS_S2_BOJ11725_1_COM {
    // 분석
    // 루트 없는 트리 -> DFS - Graph 연결리스트 문제
    // 입력 node = 100,000 / D = 99,999 = 200,000 / 트리상에 연결된 두 정점 -> 그래프 시작, 종료지점 양쪽에 추가 필요.
    // 출력 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.

    static int N, M;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 1. 입력 및 초기화
        N = scan.nextInt();
        M = N - 1;
        visited = new boolean[N+1];
        parent = new int[N+1];

        // 인접 리스트 만들기
        graph = new ArrayList<>();

        // N+1개 빈 리스트 생성 (0번은 안 쓰고 1번부터)
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // 2-2. DFS 호출
        for(int i=0; i<N; i++){
            dfs(i);
        }

        // 3. 출력
        System.out.println();
    }
    public static void dfs(int node){
        // 2-1. DFS 구현
        visited[node] = true;
        for(int next: graph.get(node)){
            if(!visited[next]){
                parent[next] = node;
                dfs(next);
            }
        }
    }
}
