package src.boj;

import java.util.*;

// 백준 5567 - 결혼식 (실버 2)
// 시간제한: 1초 | 메모리제한: 128MB
//
// 문제:
// 상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다. -> 2-depths까지
// 상근이의 동기는 모두 N명이고, 이 학생들의 학번은 모두 1부터 N까지이다. 상근이의 학번은 1이다.

// 첫째 줄에 상근이의 동기의 수 n (2 ≤ n ≤ 500)이 주어진다. 둘째 줄에는 리스트의 길이 m (1 ≤ m ≤ 10000)이 주어진다. 다음 줄부터 m개 줄에는 친구 관계 ai bi가 주어진다. (1 ≤ ai < bi ≤ n) ai와 bi가 친구라는 뜻이며, bi와 ai도 친구관계이다.
// 출력: 상근이의 결혼식에 초대하는 동기의 수
// 시간복잡도 : N 500 + M 10000 = 10500

public class BOJ5567 {

    // 분석 - 상근이의 동기는 1부터 n까지 번호가 매겨져 있고, 상근이는 1번이다.
    //       상근이의 동기 중 친구 관계인 쌍이 주어졌을 때, 결혼식에 초대하는 동기의 수를 구하라.
    // 첫째 줄에 상근이의 동기의 수 n (2 ≤ n ≤ 500). 둘째 줄에 리스트의 길이 m (1 ≤ m ≤ 10000). 다음 m줄에 친구 관계 a b.
    // 0. 시간복잡도 500 + 10000 = 10500 여유


    // TODO. 필요 변수 선언
    static int N, M;

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] parent;
    static int count = 0;


    public static void main(String[] args) {
        // TODO: 1. 입력 및 초기화
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        // TODO: 1-1. 초기화
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // TODO: 1-2. 연결관계 입력받기
        for (int i = 0; i < M; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        dfs(1, 0);

        // 4. 출력
        for(int i=0; i<= N; i++){
            if(parent[i] <= 2 && parent[i] > 0){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int node, int depth) {
        // TODO 2. DFS 구현
        visited[node] = true;
        parent[node] = depth;
        for (int next : graph.get(node)) {
            if (!visited[next] && depth <= 2) {
                dfs(next, depth+1);
            }
        }
    }
}
