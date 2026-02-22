package src.boj;

// 백준 11123 - 양 한마리... 양 두마리... (실버 2)
// 시간제한: 1초 | 메모리제한: 256MB
//
// 문제
// 나의 목장은 H x W의 크기의 격자로 이루어져있다. 양을 '#'으로 나타내고 '.'으로 풀을 표현한다.
// 서로 다른 '#' 두 개 이상이 상하좌우로 붙어있다면, 한 무리의 양들이 있는 것이다.
// 나의 양은 몇 개의 무리로 이루어져 있는지 알아내시오.
//
// 입력
// 첫 번째 줄에는 테스트 케이스의 수 T가 주어진다. 각 테스트 케이스의 첫 번째 줄에는 H와 W가 주어진다 (0 < H, W <= 100).
// 이후 H줄에 걸쳐 W개의 문자로 이루어진 문자열이 주어진다.
//
// 출력
// 각 테스트 케이스마다, 양의 무리가 몇 개인지를 한 줄에 출력한다.
//
/* 예제 입력:
2
4 4
#.#.
.#.#
#.#.
.#.#
3 5
#.###
..#..
#.#.#
*/
// 예제 출력:
// 8
// 6

import java.util.*;
public class DFS_S2_BOJ11123_1_COM {
    // TODO: 문제분석
    // TODO: 유형분석 - 나의 양은 몇개의 무리로 이루어져 있는지? -> DFS 갯수 측정 / 그리드
    // TODO: 0/1 indexed => 격자형 0-indexed로 구현
    // TODO: T의 외부 for문 존재
    // 입력:
    // T / H, W (Height H > 0 / Width <= 100)
    // TODO: 시간복잡도 H * 100 = 여유
    // 출력: 각 테스트 케이스마다, 양의 무리가 몇 개인지를 한 줄에 출력한다.


    // T
    static int T, H, W;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // TODO 1. 변수 입력 및 초기화
        T = scan.nextInt();
        for(int i=0; i<T; i++){
            H = scan.nextInt();
            W = scan.nextInt();
            grid = new char[H][W];
            visited = new boolean[H][W];

            // TODO 2. 그리드 입력
            for(int x=0; x<H; x++){
                String line = scan.next();
                for(int y=0; y<W; y++){
                    grid[x][y] = line.charAt(y);
                }
            }
            // TODO 3. DFS 호출 및 구현
            int count = 0;
            for(int x=0; x<H; x++){
                for(int y=0; y<W; y++){
                    if(!visited[x][y] && grid[x][y] == '#'){
                        dfs(x,y);
                        count++;
                    }
                }
            }

            // TODO 4. 출력
            System.out.println(count);
        }
    }
    public static void dfs(int x, int y){
        visited[x][y] = true; // 방문 처리

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny] && grid[nx][ny] == '#'){
                dfs(nx, ny);
            }
        }
    }
}
