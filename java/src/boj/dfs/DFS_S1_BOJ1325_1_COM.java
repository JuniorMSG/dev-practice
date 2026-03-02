package src.boj.dfs;

// 백준 1325 - 효율적인 해킹 (실버 1)
// https://www.acmicpc.net/problem/1325
// 시간제한: 5초 | 메모리제한: 256MB
//
// 문제
// 해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다. 이 회사는 N개의 컴퓨터로 이루어져 있다.
// 김지민은 한 번의 해킹으로 여러 개의 컴퓨터를 해킹할 수 있는 컴퓨터를 해킹하려고 한다.
// A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다.
// 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다.
// 둘째 줄부터 M개의 줄에, 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다.
//
// 출력
// 첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.
//
/* 예제 입력:
5 4
3 1
3 2
4 3
5 3
*/
// 예제 출력: 1 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_S1_BOJ1325_1_COM {

    // TODO: 문제분석
    // 문제유형: DFS - graph - 1-indexed
    // 입력 첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다.
    // 둘째 줄부터 M개의 줄에, 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다.
    // 시간복잡도 10,000 + 100,000

    // TODO: 변수선언
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int N, M;
    static int[] size;


    public static void main(String[] args) throws IOException {
        // TODO 1. 변수 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        size = new int[N + 1];
        graph = new ArrayList<>();

        // TODO 2. graph 초기화 및 입력
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());  // 매번 새 줄
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(y).add(x);
        }

        // TODO 3. DFS 구현 및 호출
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }

        // TODO 4. 출력
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (size[i] > max) max = size[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (size[i] == max) sb.append(i).append(" ");
        }

        System.out.println(sb.toString().trim());

    }

    public static void dfs(int node, int start) {
        visited[node] = true;
        size[start]++;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next, start);
            }
        }
    }
}
