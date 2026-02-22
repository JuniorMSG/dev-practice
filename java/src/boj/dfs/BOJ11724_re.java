package src.boj.dfs;


// 백준 11724 - 연결 요소의 개수 (실버 2) [재풀이]
// 시간제한: 3초 | 메모리제한: 512MB
//
// 문제
// 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
// 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v)
// 같은 간선은 한 번만 주어진다.
//
// 출력
// 첫째 줄에 연결 요소의 개수를 출력한다.
//
/* 예제 입력:
6 5
1 2
2 5
5 1
3 4
4 6
*/
// 예제 출력: 2

import java.util.*;
public class BOJ11724_re {
    // TODO: 분석
    // 입력 정점 N (1000) / 간선 M (1000*999/2 -> 약 50만)
    // 방향없는 그래프 -> 그래프 - 연결리스트 양쪽

    // TODO: 변수선언
    static int N, M;
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) {
        // TODO 1. 기본 변수 입력 및 초기화
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        visited = new boolean[N+1];

        // TODO 2. 그래프 입력 및 초기화
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // TODO  3-2: DFS 호출
        int count = 0;
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        // TODO 4: 출력
        System.out.println(count);

    }

    public static void dfs(int node){
        // TODO 3-1: DFS 구현
        visited[node] = true;
        for(int next: graph.get(node)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
