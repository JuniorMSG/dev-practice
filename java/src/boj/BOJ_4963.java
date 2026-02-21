package src.boj;

/**
 * BOJ 4963 - 섬의 개수 (실버 2)
 * 분류: DFS, 그리드, 8방향 탐색
 * <p>
 * [문제 분석]
 * - w×h 격자에서 땅(1)과 바다(0)
 * - 8방향(상하좌우 + 대각선) 연결된 땅은 같은 섬
 * - 0 0 입력 시 종료
 * <p>
 * (-1,-1) (-1,0) (-1,1)
 * ( 0,-1) [나]  ( 0,1)
 * ( 1,-1) ( 1,0) ( 1,1)
 * <p>
 * [TODO]
 * 1. 변수 선언 (grid, visited, dx/dy 8방향, w, h)
 * 2. while(true)로 테스트케이스 반복 (0 0이면 break)
 * 3. grid, visited 초기화 + grid 입력
 * 4. 이중 for로 !visited && grid==1이면 DFS + count++
 * 5. DFS: 범위체크 + 방문체크 + 바다체크 → 8방향 재귀
 * 6. count 출력
 */

import java.util.Scanner;

public class BOJ_4963 {
  static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
  static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
  static int[][] grid;
  static boolean[][] visited;
  static int W, H, count;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // MSG가 여기부터 채우기

    while (true) {
      W = sc.nextInt();
      H = sc.nextInt();
      if (W == 0 && H == 0) break;

      grid = new int[H][W];
      visited = new boolean[H][W];

      for (int x = 0; x < H; x++) {
        for (int y = 0; y < W; y++) {
          grid[x][y] = sc.nextInt();
        }
      }

      count = 0;
      for (int x = 0; x < H; x++) {
        for (int y = 0; y < W; y++) {
          if (!visited[x][y] && grid[x][y] == 1) {
            DFS(x, y);
            count++;
          }
        }
      }


      System.out.println(count);
    }
  }

  public static void DFS(int x, int y) {
    visited[x][y] = true;
    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny] && grid[nx][ny] == 1) {
        DFS(nx, ny);
      }
    }
  }

}
