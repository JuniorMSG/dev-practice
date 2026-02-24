package src.boj.dfs;
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	24379	9914	7937	39.655%
//문제
// 전쟁은 어느덧 전면전이 시작되었다. 결국 전투는 난전이 되었고, 우리 병사와 적국 병사가 섞여 싸우게 되었다.
// 그러나 당신의 병사들은 흰색 옷을 입고, 적국의 병사들은 파란색 옷을 입었기 때문에 서로가 적인지 아군인지는 구분할 수 있다.
// 문제는 같은 팀의 병사들은 모이면 모일수록 강해진다는 사실이다.
//
// N명이 뭉쳐있을 때는 N2의 위력을 낼 수 있다. 과연 지금 난전의 상황에서는 누가 승리할 것인가?
// 단, 같은 팀의 병사들이 대각선으로만 인접한 경우는 뭉쳐 있다고 보지 않는다.
//
// 입력
// 첫째 줄에는 전쟁터의 가로 크기 N, 세로 크기 M(1 ≤ N, M ≤ 100)이 주어진다. 그 다음 두 번째 줄에서 M+1번째 줄에는 각각 (X, Y)에 있는 병사들의 옷색이 띄어쓰기 없이 주어진다. 모든 자리에는 병사가 한 명 있다. B는 파란색, W는 흰색이다. 당신의 병사와 적국의 병사는 한 명 이상 존재한다.
//
// 출력
// 첫 번째 줄에 당신의 병사의 위력의 합과 적국의 병사의 위력의 합을 출력한다.

import java.util.*;
public class DFS_S1_BOJ1303_1_COM {
    // TODO 문제 분석
    // 문제유형 DFS, grid , 0-indexed
    // 입력 1 <= N, M <= 100 | 시간복잡도 100*100 = 10000
    // 출력 Wcount / Bcount

    // TODO 0. 변수선언
    static int row, col;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int count = 0;

    public static void main(String[] args) {
        // TODO 1. 변수 초기화 및 입력
        Scanner scan = new Scanner(System.in);
        col = scan.nextInt();
        row = scan.nextInt();
        grid = new char[row][col];
        visited = new boolean[row][col];

        // TODO 2. 그리드 입력
        for (int i = 0; i < row; i++) {
            String line = scan.next();
            for (int j = 0; j < col; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        // TODO 3. DFS 구현 및 호출
        int wCount = 0;
        int bCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                count = 0;
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j]);
                    if(grid[i][j] == 'W'){
                        wCount += count * count;
                    } else {
                        bCount += count * count;
                    }
                }
            }
        }
        // TODO 4. 출력
        System.out.println(wCount + " " + bCount);

    }

    public static void dfs(int x, int y, char color) {
        visited[x][y] = true; // 방문처리
        count++; // 접근시 바로 카운트 뎁스 증가
        for (int i = 0; i < 4; i++) {
            // 4방향 탐색
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny] && grid[nx][ny] == color) {
                dfs(nx, ny, grid[nx][ny]);
            }
        }
    }
}
