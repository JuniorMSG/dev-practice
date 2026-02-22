package src.boj.dfs;

import java.util.*;

// 백준 2644 - 촌수계산 (실버 2)
// 시간제한: 1초 | 메모리제한: 128MB
//
// 문제: 우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다.
// 이러한 촌수는 다음과 같은 방식으로 , 부모와 자식 사이를 1촌으로 정의하고 이로부터 digit에 digit에서의 촌수를 계산한다.
// 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
// 입력: 사람의 수 n. 촌수를 계산해야 하는 두 사람의 번호. 부모 자식들 간의 관계의 개수 m. 이후 m줄에 부모 자식 관계 (x y: x는 y의 부모)
// 출력: 두 사람의 촌수. 친척 관계가 없으면 -1
//
// 예제 입력:
// 9
// 7 3
// 7
// 1 2
// 1 3
// 2 7
// 2 8
// 2 9
// 4 5
// 4 6
//
// 예제 출력:
// 3
public class DFS_S2_BOJ2644_1_COM {
    // 분석 촌수 -> 서로 연결된 연결리스트 DFS -> 그래프로 구현한다.
    // 입력
    // 1-1. 사람의 수 n.
    // 1-2. 촌수를 계산해야 하는 두 사람의 번호.
    // 1-3. 부모 자식들 간의 관계의 개수 m.
    // 1-4. m줄에 부모 자식 관계 (x y: x는 y의 부모)


    static int N, M;
    static int start, end;
    static int[] parent;
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 1. 입력 및 초기화
        N = scan.nextInt();
        start = scan.nextInt();
        end = scan.nextInt();
        M = scan.nextInt();
        graph = new ArrayList<>();
        parent = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int d_start = scan.nextInt();
            int d_end = scan.nextInt();
            graph.get(d_start).add(d_end);
            graph.get(d_end).add(d_start);
        }

        // 2. DFS 구현 및 호출
        // 2-2. DFS 호출
        dfs(start, 0);

        // 3. 출력
        if(parent[end] == 0){
            System.out.println(-1);
        }else{
            System.out.println(parent[end]);
        }


    }

    public static void dfs(int node, int depth){
        // 2-1. DSF 구현
        visited[node] = true;
        parent[node] = depth++;
        for(int next: graph.get(node)){
            if(!visited[next] && !(node == end)){

                dfs(next, depth);
            }
        }
    }
}
