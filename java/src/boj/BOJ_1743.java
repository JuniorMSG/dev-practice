package src.boj;

/**
 * BOJ 1743 - 음식물 피하기 (실버 1)
 * 분류: DFS, 그리드
 * <p>
 * [문제]
 * - N×M 격자에 음식물 쓰레기가 놓여 있음
 * - 상하좌우(4방향) 인접한 음식물은 하나로 뭉침
 * - 가장 큰 음식물 덩어리의 크기를 구해라
 * <p>
 * [입력]
 * - 첫 줄: N(행) M(열) K(음식물 개수)
 * - 이후 K줄: 음식물 좌표 (r, c)
 * <p>
 * [출력]
 * - 가장 큰 음식물 덩어리의 크기
 * <p>
 * 분석
 * 행열이 몇갠지 모르겠는데 4방향 그리드 문제로 보임
 * 시간복잡도는 그리드니까 O(N*M)
 * 변수 N, M ,K
 * int[] dx , dy 선언 필요 4
 * int grid[][]
 * boolean visited[][] 도 선언 필요
 * <p>
 * [TODO]
 * MSG가 직접 분석하고 TODO 쪼개기
 * 1. 변수선언
 * 2. 입력 및 초기화단계
 * 3. 2중포문 돌면서 그리드에 입력받기
 * 4. Dfs 구현
 * 5. Dfs 실행 로직 및 count연산
 * 6. 출력
 */

import java.util.*;

public class BOJ_1743 {

  // 1 변수 선언
  static int N, M, K;
  static int[][] grid;
  static boolean[][] visited;
  static int dx[] = {-1, 0, 0, 1};
  static int dy[] = {0, 1, -1, 0};
  static int max = 0;
  static int count = 0;

  public static void main(String[] args) {
    // MSG가 전부 채우기

    // 2. 입력받기
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    K = sc.nextInt();
    grid = new int[N][M];
    visited = new boolean[N][M];


    // 3. 그리드 입력받기
    for (int i = 0; i < K; i++) {
      int r = sc.nextInt();
      int c = sc.nextInt();
      grid[r-1][c-1] = 1;
    }

    // 5. DFS 호출
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          DFS(i, j);
          max = Math.max(max, count);
          count = 0;
        }
      }

    }
    System.out.println(max);
  }


  public static void DFS(int r, int c) {
    // 4 DFS 구현
    visited[r][c] = true;
    count++;
    for (int i = 0; i < 4; i++) {
      int nx = r + dx[i];
      int ny = c + dy[i];
      if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && grid[nx][ny] == 1) {
        DFS(nx, ny);
      }
    }

  }
}
