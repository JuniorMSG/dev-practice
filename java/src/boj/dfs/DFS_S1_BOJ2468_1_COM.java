package src.boj.dfs;

import java.util.*;

// 백준 2468 - 안전 영역 (실버 1)
// https://www.acmicpc.net/problem/2468
// 시간제한: 1초 | 메모리제한: 128MB
//
// 문제
// 재난방재청에서는 많은 비가 내리는 경우 일정 높이 이하의 모든 지점이 물에 잠긴다고 가정한다.
// 비가 내려 일정 높이 이하의 모든 지점이 물에 잠겼을 때, 물에 잠기지 않는 안전한 영역이
// 몇 개가 되는 지를 조사하고자 한다. 최대 안전 영역의 개수를 구하라.
//
// 입력
// 첫째 줄에 지역의 크기 N(2 ≤ N ≤ 100)이 주어진다.
// 둘째 줄부터 N개의 줄에 각 지점의 높이(1 ≤ 높이 ≤ 100)가 주어진다.
//
// 출력
// 첫째 줄에 안전 영역의 최대 개수를 출력한다.
//
/* 예제 입력:
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
*/
// 예제 출력:
// 5

public class DFS_S1_BOJ2468_1_COM {
    // 문제 유형: grid / 0-indexed
    // 높이마다 visited 초기화 후 DFS → 안전 영역 최대 개수

    static int[][] grid;
    static boolean[][] visited;
    static int N;
    static ArrayList<Integer> size;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        grid = new int[N][N];
        int max = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                grid[x][y] = scan.nextInt();
                if (max < grid[x][y]) max = grid[x][y];
            }
        }

        size = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            int count = 0;
            visited = new boolean[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (grid[x][y] <= i) visited[x][y] = true;
                }
            }
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!visited[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
            size.add(count);
        }

        System.out.println(Collections.max(size));
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
