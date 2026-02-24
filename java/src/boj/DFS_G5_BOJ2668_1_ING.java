package src.boj;

// 백준 2668 - 숫자고르기 (골드 5)
// 시간제한: 1초 | 메모리제한: 128MB
//
// 문제
// 세로 두 줄, 가로로 N개의 칸으로 이루어진 표가 있다.
// 첫째 줄의 각 칸에는 정수 1, 2, …, N이 차례대로 들어 있고
// 둘째 줄의 각 칸에는 1이상 N이하인 정수가 들어 있다.
// 첫째 줄에서 숫자를 적절히 뽑으면, 그 뽑힌 정수들이 이루는 집합과,
// 뽑힌 정수들의 바로 밑의 둘째 줄에 들어있는 정수들이 이루는 집합이 일치한다.
// 이러한 조건을 만족시키도록 정수들을 뽑되, 최대로 많이 뽑는 방법을 찾는 프로그램을 작성하시오.
//
// 예를 들어, N=7인 경우:
// 첫째 줄: 1 2 3 4 5 6 7
// 둘째 줄: 3 1 1 5 5 4 6
// → 1, 3, 5를 뽑으면 밑에 3, 1, 5가 있어 집합이 일치 → 답: 3개
//
// 입력
// 첫째 줄에는 N(1≤N≤100)을 나타내는 정수 하나가 주어진다.
// 그 다음 줄부터는 표의 둘째 줄에 들어가는 정수들이 순서대로 한 줄에 하나씩 입력된다.
//
// 출력
// 첫째 줄에 뽑힌 정수들의 개수를 출력하고,
// 그 다음 줄부터는 뽑힌 정수들을 작은 수부터 큰 수의 순서로 한 줄에 하나씩 출력한다.
//
/* 예제 입력:
7
3
1
1
5
5
4
6
*/
/* 예제 출력:
3
1
3
5
*/

import java.util.*;

public class DFS_G5_BOJ2668_1_ING {
    // 문제분석
    // DFS - 함수형 그래프 - 사이클 탐지
    // 각 노드(1~N)에서 출발 → arr를 따라감 → 시작점으로 돌아오면 사이클
    // 사이클에 포함된 노드를 전부 모아서 출력

    // TODO 0. 변수선언
    static int N;
    static int[] arr;               // arr[i] = i번 노드가 가리키는 값
    static boolean[] visited;        // DFS마다 새로 쓰는 방문 체크
    static List<Integer> result = new ArrayList<>();  // 사이클에 포함된 노드들
    static boolean found;            // 사이클 발견 여부

    public static void main(String[] args) {
        // TODO 1. 입력
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        arr = new int[N + 1];  // 1-indexed
        for (int i = 1; i <= N; i++) {
            arr[i] = scan.nextInt();
        }

        // TODO 2. 1~N 각 노드에서 DFS 돌리기
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];  // 매번 새로 생성
            found = false;
            dfs(i, i);
        }

        // TODO 3. 출력 (오름차순 정렬)
        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    // TODO 4. DFS - start에서 출발, 따라가다 start로 돌아오면 사이클
    public static void dfs(int start, int node) {
        // 이미 방문한 노드인데 그게 시작점이면 → 사이클 발견!
        if (visited[node]) {
            if (node == start) {
                found = true;
                result.add(start);
            }
            return;
        }

        visited[node] = true;
        dfs(start, arr[node]);  // 다음 노드로 따라감
    }
}
