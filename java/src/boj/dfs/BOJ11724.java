package src.boj.dfs;

import java.util.*;

// 백준 11724 - 연결 요소의 개수 (실버 2)
// 분류: DFS/BFS, 그래프 탐색
// 방향 없는 그래프에서 연결 요소(묶음) 개수 구하기
public class BOJ11724 {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        // 문제 분석
        // 시간제한 3초 (3억 회 연산이내)
        // 시간복잡도 -> N = 1000, M 1000*999/2 대략 50만 =  1000 + 50만 = 501000
        // 방향 없는 그래프 -> DFS로
        Scanner scan = new Scanner(System.in);

        // TODO: N(정점 수), M(간선 수) 입력받기
        int N = scan.nextInt();
        int M = scan.nextInt();

        // TODO: 인접 리스트 만들기 (N+1개, 0번 안 씀)
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        // TODO: M번 반복해서 간선 입력받기 (양방향)
        for (int i=0; i< M; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // TODO: 전체 노드 순회하면서 DFS로 연결 요소 개수 세기
        int count = 0;
        for(int i=1; i<= N; i++){
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }

        // TODO: 결과 출력
        System.out.println(count);
    }

    // TODO: DFS 구현
    static void dfs(int node) {
        visited[node] = true;

        // 여기에 DFS 로직
        for (int next : graph.get(node)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
