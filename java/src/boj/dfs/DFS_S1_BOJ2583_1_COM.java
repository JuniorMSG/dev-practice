package src.boj.dfs;

// 백준 2583 - 영역 구하기 (실버 1)
// https://www.acmicpc.net/problem/2583
// 시간제한: 1초 | 메모리제한: 128MB
//
// 문제
// 눈금의 간격이 1인 M x N 크기의 모눈종이가 있다. 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때,
// 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.
// M, N과 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이
// 몇 개의 분리된 영역으로 나누어지는지, 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 출력하시오.
//
// 입력
// 첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다.
// 둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 주어진다.
// 모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0, 0)이고, 오른쪽 위 꼭짓점의 좌표는 (N, M)이다.
//
// 출력
// 첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.
//
/* 예제 입력:
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2
*/
// 예제 출력:
// 3
// 1 7 13

// TODO: 분석
// DFS / 그리드 / 0-indexed
// 입력 : 첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다.
// M, N, K
// 출력
import java.util.*;
public class DFS_S1_BOJ2583_1_COM {

    // TODO 0: 기본 변수 선언
    static boolean[][] grid;
    static boolean[][] visited;
    static int M, N, K;
    static int count;
    static ArrayList<Integer> size;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {
        // TODO 1: 일반 입력 및 초기화
        Scanner scan = new Scanner(System.in);
        // 입력 순서는 M, N, K 꼭지점은 (N, M) -> 배열 [M][N]
        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();

        grid = new boolean[M][N];
        visited = new boolean[M][N];


        // TODO 2: 그리드 입력
        for(int i=0; i<K; i++){
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();

            for(int x=x1; x<x2; x++){
                for(int y=y1; y<y2; y++){
                    grid[y][x] = true;
                    visited[y][x] = true;
                }
            }
        }
        // TODO 3: dfs 구현 및 호출
        count = 0;
        size = new ArrayList<>();
        for(int y=0; y<M; y++){
            for(int x=0; x<N; x++){
                if(!visited[y][x]){
                    size.add(dfs(y, x));
                    count++;
                }
            }
        }

        // TODO 4: 출력
        Collections.sort(size);
        System.out.println(count);
        for (Integer size : size) {
            System.out.print(size + " ");
        }

    }

    public static int dfs(int y, int x){
        visited[y][x] = true;
        int size = 1;

        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            // X축 -> N / Y축 -> M
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[ny][nx]){
                size += dfs(ny, nx);
            }
        }
        return size;
    }
}
