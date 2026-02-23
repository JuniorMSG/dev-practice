package src.boj.dfs;


// 백준 11403 - 경로 찾기 (실버 1)
// 시간제한: 1초 | 메모리제한: 256MB
//
//문제
//가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 길이가 양수인 경로가 있는지 없는지 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다. i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는 없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.
//
//출력
//총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다. 정점 i에서 j로 가는 길이가 양수인 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.
import java.util.*;
public class DFS_S1_BOJ11403_1_COM {
    // TODO: 0. 문제분석
    // 1-1. 문제유형 -> DFS , graph 인접행렬
    // 1-2. 시간복잡도 = 100+99

    // TODO: 0. 변수선언
    static int N;
    static boolean[] visited;
    static List<List<Integer>> graph;
    static int[][] result;

    public static void main(String[] args) {
        // TODO: 1. 입력 및 초기화
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        graph = new ArrayList<>();
        result = new int[N][N];

        // TODO: 2. 행렬 입력
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int a = scan.nextInt();
                if(a == 1) graph.get(i).add(j);
            }
        }

        // TODO: 3. DFS 구현 및 호출
        for(int i=0; i<N; i++){
            visited = new boolean[N];
            for(int next : graph.get(i)){
                if(!visited[next]){
                    dfs(next);
                }
            }

            for(int j=0; j<N; j++){
                if(visited[j]){
                    result[i][j] = 1;
                }
            }
        }


        // TODO: 4. 결과 출력
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static void dfs(int node){
        visited[node] = true;
        for(int next: graph.get(node)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
