package src.boj.dfs;

// 백준 10026 - 적록색약 (골드 5)
// 시간제한: 1초 | 메모리제한: 128MB
//
// 문제
// 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
//
// 크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
//
// 예를 들어, 그림이 아래와 같은 경우에
// RRRBB
// GGBBB
// BBBRR
// BBRRR
// RRRRR
// 적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
//
// 그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
// 둘째 줄부터 N개 줄에는 그림이 주어진다.
//
// 출력
// 적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
//
/* 예제 입력:
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
*/
// 예제 출력: 4 3

import java.util.*;
public class DFS_G5_BOJ10026_1_COM {
    // TODO 문제분석
    // 문제 유형 : DFS / 그리드 / 0-indexed
    // 입력 : 크기 N*N (1 <= N <= 100) => 시간복잡도 100*100 = 10,000
    // 출력 : 일반인 count / 적록색약인 count

    // TODO 0. 변수선언
    static int N;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};


    public static void main(String[] args) {
        // TODO 1. 변수 초기화 및 입력
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();


        char[][] grid = new char[N][N];
        char[][] grid2 = new char[N][N];


        // TODO 2. 그리드 초기화 및 입력
        for(int i=0; i<N; i++){
            String line = scan.next();
            for(int j=0; j<N; j++){
                grid[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(grid[i][j] == 'G') {
                    grid2[i][j] = 'R';
                }else {
                    grid2[i][j] = grid[i][j];
                }
            }
        }

        // TODO 3. DFS 구현 및 호출
        visited = new boolean[N][N];
        int count = 0;

        for(int x=0; x<N; x++){
            for(int y=0; y<N; y++){
                if(!visited[x][y]){
                    dfs(x, y, grid[x][y], grid);
                    count++;
                }
            }
        }

        visited = new boolean[N][N];
        int abCount = 0;
        for(int x=0; x<N; x++){
            for(int y=0; y<N; y++){
                if(!visited[x][y]){
                    dfs(x, y, grid2[x][y], grid2);
                    abCount++;
                }
            }
        }

        // TODO 4. 출력
        System.out.println(count + " " + abCount);

    }

    public static void dfs(int x, int y, char color, char[][] grid){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && grid[nx][ny] == color){
                dfs(nx, ny, color, grid);
            }
        }
    }

}
