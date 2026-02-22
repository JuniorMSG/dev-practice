package src.boj.dfs;


// 백준 2606 - 바이러스 (실버 3) [재풀이]
// 시간제한: 1초 | 메모리제한: 128MB
// 1번 컴퓨터가 바이러스에 걸리면, 네트워크로 연결된 컴퓨터도 감염된다.
// 1번을 통해 감염되는 컴퓨터 수를 구하라. (1번 제외)
//
// 입력: 첫째 줄 N(컴퓨터 수, 1~100), 둘째 줄 M(간선 수), 이후 M줄에 간선 쌍
// 출력: 1번으로 인해 감염되는 컴퓨터 수
//
// 예제 입력:
// 7
// 6
// 1 2
// 2 3
// 1 5
// 5 2
// 5 6
// 4 7
//
// 예제 출력:
// 4


import java.util.*;
public class DFS_S3_BOJ2606_2_COM {
    // 문제분석 : 시간제한 1초
    // 입력 N (1 ~ 100) 컴퓨터 수, M 간선 수
    // 시간복잡도 : O(N + E) = 100 + 간선 수 (100 * 99 / 2 = 4950), 여유
    // 그래프 (간선 쌍 입력) → 인접 리스트 + DFS

    // 1. 변수선언
    static int N, M;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        // 2. 변수 초기화 및 입력 받기
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        visited = new boolean[N+1];

        // 3. 인접 리스트 만들기
        graph = new ArrayList<>();

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 4. DFS 호출
        DFS(1);

        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (visited[i]) count++;
        }
        System.out.println(count);
    }

    public static void DFS(int node){
        visited[node] = true;
        for(int next : graph.get(node)){
            if(!visited[next]){
                DFS(next);
            }
        }
    }
}
