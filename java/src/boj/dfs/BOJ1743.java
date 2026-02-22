package src.boj.dfs;

// 백준 1743 - 음식물 피하기 (실버 1)
// 시간제한: 2초 | 메모리제한: 128MB
//
// 문제
// 코레스코 콘도미니엄 8, , , , 호에 사는 , , , , 는 각각 자기방에서 콘도의 lobby까지
// 음식물을 흘리면서 가고 있다. 이 음식물들은 근처에 있는 음식물끼리 뭉치게 되고,
// 거대한 음식물 덩어리가 된다. (상하좌우로 인접한 음식물이 뭉침)
// 코레스코 사장은 이 거대한 음식물 덩어리 중 가장 큰 음식물의 크기를 알고 싶어 한다.
//
// 입력
// 첫째 줄에 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100) 그리고 음식물 쓰레기의 개수 K(1 ≤ K ≤ N×M)가 주어진다.
// 그 다음 K개의 줄에 음식물이 떨어진 좌표 (r, c)가 주어진다. (1 ≤ r ≤ N, 1 ≤ c ≤ M)
// 좌표 (r, c)는 r행 c열을 의미한다.
//
// 출력
// 첫째 줄에 가장 큰 음식물의 크기를 출력하라.
//
/* 예제 입력:
3 4 5
3 2
2 2
3 1
2 3
1 1
*/
// 예제 출력: 4

import java.util.*;
public class BOJ1743 {
    // TODO 0. 문제분석
    // 변수 입력 세로 N (100) / 가로 M (100) / K 음식물 N*M
    // K개의 줄에 좌표 (r,c) r=행 / c=열 -> 행 -> y 열 -> x로 치환해서 작업
    // 그리드 문제
    // TODO 0. 시간복잡도 (100 + 10000)
    // 출력


    // TODO 1. 변수 선언
    static int N, M, K;
    static boolean[][] visited;
    static int[][] grid;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int max = 0;
    static int count = 0;


    public static void main(String[] args) {
        // TODO 1. 변수 입력 및 초기화
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();

        visited = new boolean[N+1][M+1];
        grid = new int[N+1][M+1];

        // TODO 2. 그리드 입력
        for(int i=0; i<K; i++){
            int y = scan.nextInt();
            int x = scan.nextInt();
            grid[y][x] = 1;
        }

        // TODO 3-1. DFS 호출
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(!visited[i][j] && grid[i][j] == 1){  // 아직 방문 안 한 음식물 칸만
                    count = 0;
                    dfs(i, j);
                    max = Math.max(max, count);
                }
            }
        }
        // TODO 4. 출력
        System.out.println(max);
    }
    public static void dfs(int x, int y){
        // TODO 3-2. DFS 구현
        visited[x][y] = true;
        count++;
        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx > 0 && nx <= N && ny > 0 && ny <= M && !visited[nx][ny] && grid[nx][ny] == 1){
                dfs(nx, ny);
            }
        }

    }
}
