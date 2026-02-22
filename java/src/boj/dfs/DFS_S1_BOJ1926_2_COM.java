package src.boj.dfs;

// 백준 1926 - 그림 (실버 1) [재풀이]
// 시간제한: 2초 | 메모리제한: 128MB
//
// 문제
// 어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라.
// 단, 그림이라 함은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결된 것은 연결이 아니다.
// 그림의 넓이란 그림에 포함된 1의 개수이다.
//
// 입력
// 첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다.
// 두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다.)
//
// 출력
// 첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라.
// 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.
//
/* 예제 입력:
6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1
*/
// 예제 출력:
// 4
// 9

import java.util.*;

public class DFS_S1_BOJ1926_2_COM {
    // TODO 0. 문제분석
    // TODO 0-1. 입력
    // 세로 N 500 / 가로 M 500
    // n+1줄 까지 그림의 정보
    // 1부터 시작 -> 1-indexed로 구현 -> 0부터 시작으로 변경 -> 0-indexed로 구현
    // 가로, 세로는 연결 , 대각은 제외
    // TODO 0-2. 출력
    // 첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라. -> 그림의 개수,  넓이 필요, 0개일때 넓이 0 처리
    // TODO 0-3. 시간복잡도. 500*500 = 250,000 이내

    // TODO 1-1. 변수 선언
    static int N, M, count, max;
    static boolean[][] visited;
    static int[][] grid;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {
        // TODO 1-1. 변수 초기화
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        max = 0;
        visited = new boolean[N][M];

        // TODO 2. 그리드 초기화 및 입력
        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = scan.nextInt();
            }
        }

        // TODO 3-1. DFS 호출
        int size = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    // 아직 방문 안 한칸만 세기
                    count = 0;
                    size++;
                    dfs(i, j);
                    if (max < count) max = count;
                }
            }
        }

        // TODO 4. 출력
        System.out.println(size);
        System.out.println(max);
    }

    public static void dfs(int x, int y) {
        // TODO 3-2. DFS 구현
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && grid[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
