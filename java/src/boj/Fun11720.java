package src.boj;


import java.io.*;
import java.util.Scanner;

public class Fun11720 {
    /**
     * 숫자의 합을 계산하는 메서드
     * N개의 숫자가 공백 없이 주어졌을 때, 각 자릿수의 합을 구한다.
     * 11720 숫자의 합
     * 문제의 조건과 내용을 먼저 보고 진행하기
     */
    public void solve() {
        // N 값 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 길이 N의 숫자를 입력받아 String 변수 선언
        String sNum = sc.next();

        // sNum -> cNum으로 변환하여 저장
        char[] cNum = sNum.toCharArray();

        // int형 변수 sum 선언
        int sum = 0;

        // 배열의 각 자릿값을 정수형으로 변환하여 sum에 더하여 누적
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0';
        }

        // 결과 출력
        System.out.println(sum);

        sc.close();
    }

    public void solve2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(str);

        String str1 = br.readLine();
        int sum =0;
        for (int i = 0; i < n; i++) {
            char ch = str1.charAt(i);
            int a  = Character.getNumericValue(ch);
            sum+=a;

        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
