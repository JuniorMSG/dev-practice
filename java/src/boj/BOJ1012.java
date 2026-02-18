package src.boj;

import java.util.*;

// 백준 1012 - 유기농 배추 (실버 2)
// 분류: DFS/BFS, 그래프 탐색
// 2D 그리드에서 연결된 영역(배추 묶음) 개수 구하기
public class BOJ1012 {
    static int[][] grid;
    static boolean[][] visited;
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // TODO: 테스트 케이스 수 T 입력받기
        int T = scan.nextInt();
        for (int i=0; i<T; i++){
            M = scan.nextInt();
            N = scan.nextInt();
            int K = scan.nextInt();

            grid = new int[M][N];
            visited = new boolean[M][N];

            for (int j=0; j<K; j++){
                int x = scan.nextInt();
                int y = scan.nextInt();
                grid[x][y] = 1;
            }

            int zirung = 0;
            for (int x=0; x<M; x++){
                for (int y=0; y<N; y++){
                    if (grid[x][y] == 1 && !visited[x][y]){
                        dfs(x, y);
                        zirung++;
                    }
                }
            }

            System.out.println(zirung);
        }


    }

    // TODO: DFS 구현
    static void dfs(int x, int y) {
        // 여기에 DFS 로직
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < M && ny >= 0 && ny < N && grid[nx][ny] == 1 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }
}
