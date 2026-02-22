package src.boj.dfs;

import java.util.*;

// 백준 2667 - 단지번호붙이기 (실버 1)
// 분류: DFS/BFS, 그래프 탐색
// 2D 그리드에서 연결된 영역 개수 + 각 영역 크기 오름차순 출력
public class DFS_S1_BOJ2667_1_COM {
    // 문제분석 : 시간제한 1초
    // 입력 N (5 ~ 25) 정사각형 01101000 형태로 N개의 자료가 입력됨
    // 시간복잡도 : 25*25 = 625 그래프 (M*N)  O(n)

    static int[][] grid;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // TODO: N 입력받기 (정사각형 이므로 1개)
        N = scan.nextInt();
        grid = new int[N][N];
        visited = new boolean[N][N];

        // TODO: grid에 N개의 자료 입력받기
        for (int i=0; i<N; i++){
            String data = scan.next();
            for (int j=0; j<N; j++){
                grid[i][j] = data.charAt(j) - '0';
            }
        }

        // TODO: 전체 순회하면서 DFS로 단지 개수 / 단지 크기 리스트에 저장
        int apartDan = 0;
        ArrayList<Integer> apartSize = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    apartSize.add(dfs(i, j));
                    apartDan++;
                }
            }
        }

        // TODO: 결과 출력 단지수 -> 집수 N
        System.out.println(apartDan);
        Collections.sort(apartSize);
        for(int i=0; i<apartSize.size(); i++){
            System.out.println(apartSize.get(i));
        }

    }
    // TODO: DFS 구현
    static int dfs(int x, int y){
        visited[x][y] = true;
        int area = 1;
        for(int i=0; i<4; i++){
            int nx = x + dx[i]; // 다음 x
            int ny = y + dy[i]; // 다음 y

            if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && grid[nx][ny] > 0){
                area += dfs(nx, ny);
            }
        }
        return area;
    }


}
