package src.boj.dfs;


// 백준 13023 - ABCDE (실버 1)
// https://www.acmicpc.net/problem/13023
// 시간제한: 2초 | 메모리제한: 512MB
//
// 문제: BOJ 알고리즘 캠프에는 N명의 사람이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고,
// 일부 사람들은 친구이다.
// 다음과 같은 친구 관계가 존재하는지 구해보자.
// A는 B와 친구다. B는 C와 친구다. C는 D와 친구다. D는 E와 친구다.
// 위와 같은 관계(5명이 일렬로 친구)가 존재하면 1, 없으면 0을 출력한다.
// 입력: 첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
// 둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다.
// 출력: 문제의 조건에 맞는 A, B, C, D, E가 존재하면 1, 없으면 0을 출력한다.
//
// 예제 입력:
// 5 4
// 0 1
// 1 2
// 2 3
// 3 4
//
// 예제 출력:
// 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class DFS_S1_BOJ13023_1_COM {
    // TODO: 문제분석
    // DFS / 그래프 - 백트래킹 / 0-indexed
    // 입력 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)
    // 출력 문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다

    // TODO 변수 선언
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        // TODO 1. 변수 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        graph = new ArrayList<>();

        // TODO 2. 그래프 초기화 및 입력
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());  // 매번 새 줄
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // TODO 3. DFS 구현 및 호출
        for (int i = 0; i < N; i++) {
            if (dfs(i, 1)) {
                System.out.println(1);
                return;
            }
        }

        // TODO 4. 출력
        System.out.println(0);

    }

    public static boolean dfs(int node, int depth) {
        visited[node] = true;
        if (depth == 5) {
            return true;
        }
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                if(dfs(next, depth + 1)) {
                    return true;
                }
            }
        }
        visited[node] = false;

        return false;
    }
}
