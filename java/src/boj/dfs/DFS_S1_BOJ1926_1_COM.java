package src.boj.dfs;

import java.util.*;

// 백준 1926 - 그림 (실버 1)
// 분류: DFS/BFS, 그래프 탐색
// 2D 그리드에서 연결된 영역 개수 + 최대 넓이 구하기
public class DFS_S1_BOJ1926_1_COM {
    // 문제분석 : 시간제한 2초
    // 입력 n, m (1 ~ 500) 도화지 크기, 0/1 공백 구분 입력
    // 시간복잡도 : O(n * m) = 500 * 500 = 250,000 여유
    // 그리드 (2D 표 입력) → 연결 영역 개수 + 최대 넓이

    static int[][] grid;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // TODO: n, m 입력받기
        n = scan.nextInt();
        m = scan.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];

        // TODO: grid 배열에 도화지 입력받기
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                grid[i][j] = scan.nextInt();
            }
        }

        // TODO: 전체 순회하면서 DFS로 그림 개수 + 최대 넓이 구하기

        int count = 0;      // 그림 개수
        int maxArea = 0;    // 최대 넓이

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    int area = dfs(i, j);
                    count++;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        // TODO: 결과 출력 (그림 개수, 최대 넓이)
        System.out.println(count);
        System.out.println(maxArea);
    }

    // TODO: DFS 구현 (상하좌우 탐색, 넓이 반환)
    static int dfs(int x, int y) {
        visited[x][y] = true;

        int area = 1; // 현재 칸 = 1
        for (int i=0; i < 4; i++){  // 상하좌우 4방향
            int nx = x + dx[i]; // 다음 x
            int ny = y + dy[i]; // 다음 y


            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1 && !visited[nx][ny]){
                area += dfs(nx, ny);
            }
        }

        return area;
    }
}
