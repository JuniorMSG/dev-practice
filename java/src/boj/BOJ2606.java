package src.boj;

import java.util.*;

// 백준 2606 - 바이러스 (실버 3)
// 분류: DFS/BFS, 그래프 탐색
// 그래프에서 1번 노드와 연결된 노드 수 구하기
public class BOJ2606 {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // 컴퓨터 수
        int M = scan.nextInt(); // 간선 수
        visited = new boolean[N+1];

        // 인접 리스트 만들기
        graph = new ArrayList<>();

        // N+1개 빈 리스트 생성 (0번은 안 쓰고 1번부터)
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        // TODO: 간선 입력받기 (M번 반복)
        for (int i = 0; i < M; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // TODO: DFS로 1번에서 시작해서 연결된 컴퓨터 수 세기
        dfs(1);

        // 답 출력 (1번 빼고 세기)
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (visited[i]) count++;
        }
        System.out.println(count);
    }

    static void dfs(int node) {
        // 여기에 DFS 로직
        visited[node] = true;

        for (int next : graph.get(node)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
