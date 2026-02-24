package src.boj.dfs;

import java.util.*;

// 백준 2331 - 반복수열 (실버 4)
// 시간제한: 2초 | 메모리제한: 128MB
//
// 문제
// 다음과 같이 정의된 수열이 있다.
// D[1] = A
// D[n] = D[n-1]의 각 자리의 숫자를 P번 곱한 수의 합
// 예를 들어 A=57, P=2일 때, D[1]=57, D[2]=74(=5^2+7^2), D[3]=65, D[4]=61, D[5]=37, D[6]=58, D[7]=89, D[8]=145, ...
// 이 수열에서 반복되는 부분을 제외했을 때, 남는 수들의 개수를 구하라.
//
// 입력
// 첫째 줄에 A(1 ≤ A ≤ 9999), P(1 ≤ P ≤ 5)가 주어진다.
//
// 출력
// 첫째 줄에 반복되는 부분을 제외했을 때 남는 수들의 개수를 출력한다.
//
/* 예제 입력:
57 2
*/
// 예제 출력: 4
public class DFS_S4_BOJ2331_1_COM {
    // TODO: 문제분석
    // 수열을 따라가다가 이미 나온 숫자가 다시 나오면 → 그 숫자의 첫 등장 위치가 답
    // DFS 재귀로 다음 노드를 탐색하면서 사이클 탐지

    static List<Integer> seq = new ArrayList<>();
    static int P;

    public static void main(String[] args) {
        // TODO 1. 입력
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        P = scan.nextInt();

        // TODO 2. DFS로 사이클 탐지
        seq.add(A);
        dfs(A);
    }

    // TODO 3. DFS - 다음 숫자를 노드로 재귀 탐색
    public static void dfs(int node) {
        int next = getNext(node, P);
        int idx = seq.indexOf(next);
        if (idx != -1) {
            // 이미 방문한 노드 → 사이클 발견
            System.out.println(idx);
            return;
        }
        seq.add(next);
        dfs(next);
    }

    // TODO 3. 각 자릿수의 P제곱 합 구하기
    public static int getNext(int num, int p) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += (int) Math.pow(digit, p);
            num /= 10;
        }
        return sum;
    }
}
