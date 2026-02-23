package src.boj.dfs;


// 백준 1388 - 바닥 장식 (실버 4)
// 시간제한: 2초 | 메모리제한: 128MB
//
// 문제: 형택이는 바닥 장식을 첫 번째 직사각형부터 했다.
// 첫 번째 직사각형의 가로 크기를 N, 세로 크기를 M이라 하자.
// 바닥 장식은 '-'와 '|' 두 가지가 있다.
// '-'이 가로로 연속되면 하나의 판자이고, '|'이 세로로 연속되면 하나의 판자이다.
// 바닥을 장식하는데 필요한 나무 판자의 개수를 출력하는 프로그램을 작성하시오.
// 입력: 첫째 줄에 N과 M이 주어진다. (N<=50 M ≤ 50)
// 둘째 줄부터 N개의 줄에 바닥의 상태가 주어진다.
// 출력: 첫째 줄에 필요한 나무 판자의 개수를 출력한다.

import java.util.*;
public class DFS_S4_BOJ1388_1_COM {
    // TODO: 문제 분석
    // 문제유형 : DFS / 그리드
    // 입력 N, M -- || 단방향 dx, dy / 0-indexed
    // 출력 count
    // 시간복잡도 N*M이지만 입력 자체를 그렇게 많이 하긴 힘들 것 같다.
    //

    // TODO 0. 변수선언
    static boolean[][] visited;
    static char[][] grid;
    static int N, M;
    static int[] dx = {-1, 1};
    static int[] dy = {-1, 1};

    public static void main(String[] args) {
        // TODO 1. 변수 입력 및 초기화
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        grid = new char[N][M];
        visited = new boolean[N][M];

        // TODO 2. 그리드 초기화 및 입력
        for (int i = 0; i < N; i++) {
            String line = scan.next();
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        // TODO 3. DFS 구현
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(i, j, grid[i][j]);
                }
            }
        }

        // TODO 4. 결과 호출
        System.out.println(count);
    }

    public static void dfs(int x, int y, char gridWood) {
        visited[x][y] = true;
        if(gridWood == '-'){
            for (int i = 0; i < 2; i++) {
                // -1, 1
                int ny = dy[i] + y;
                if(ny >= 0 && ny < M && !visited[x][ny] && grid[x][ny] == '-'){
                    dfs(x, ny, gridWood);
                }
            }
        } else {
            for (int i = 0; i < 2; i++) {
                int nx = dx[i] + x;
                if(nx >= 0 && nx < N && !visited[nx][y] && grid[nx][y] == '|'){
                    dfs(nx, y, gridWood);
                }
            }
        }
    }
}
