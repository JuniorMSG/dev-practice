package src.boj;

// 백준 10451 - 순열 사이클 (실버 3)
// 시간제한: 1초 | 메모리제한: 256MB
//
// 문제
// 1부터 N까지 정수 N개로 이루어진 순열을 나타내는 방법은 여러 가지가 있다.
// 순열을 이용해 순열 그래프를 만들 수 있다. i에서 pi로 간선을 이은 그래프가 순열 그래프이다.
// N개의 정수로 이루어진 순열이 주어졌을 때, 순열 사이클의 개수를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 순열의 크기 N (2 <= N <= 1,000)이 주어진다.
// 둘째 줄에는 순열이 주어지며, 각 정수는 공백으로 구분되어 있다.
//
// 출력
// 각 테스트 케이스마다, 입력으로 주어진 순열에 존재하는 순열 사이클의 개수를 출력한다.
//
/* 예제 입력:
2
8
3 2 7 8 1 4 5 6
10
2 1 3 4 5 6 7 9 10 8
*/
// 예제 출력:
// 3
// 7

import java.util.*;
public class DFS_S3_BOJ10451_1_COM {
    // TODO: 문제분석
    // 단방향 그래프
    // i에서 pi로 간선을 이은 그래프가 순열 그래프이다. i->pi..
    // TODO: 시간복잡도 T * 1000
    // TODO: 입력
    // T, N, 순열 주르륵
    // 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
    // 1부터 N까지 정수 N개로 이루어진 순열 -> 1-indexed
    // 각 테스트 케이스의 첫째 줄에는 순열의 크기 N (2 <= N <= 1,000)이 주어진다.
    // 둘째 줄에는 순열이 주어지며, 각 정수는 공백으로 구분되어 있다.
    // TODO: 출력
    // 순열 사이클 개수

    // TODO: 0. 변수선언
    static int T, N;
    static int[] perm;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        // TODO 1. 초기화 및 입력
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            N = scan.nextInt();
            perm = new int[N + 1];
            visited = new boolean[N + 1];
            // TODO 2. 순열 입력
            for (int j = 1; j <= N; j++) {
                perm[j] = scan.nextInt();
            }

            // TODO 3. DFS 구현 및 호출
            count = 0;
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    dfs(j);
                    count++;
                }
            }

            // TODO 4. 출력
            System.out.println(count);
        }


    }

    public static void dfs(int node) {
        visited[node] = true;
        int next = perm[node];
        if (!visited[next]) {
            dfs(next);
        }
    }
}
