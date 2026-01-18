package src;

import java.io.*;
import java.util.Scanner;

public class Fun1546 {
    /**
     * 1546
     */
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();

        }
        long sum = 0;
        long max = 0;

        for(int i=0; i<N; i++){
            sum += A[i];
            max = Math.max(max, A[i]);
        }

        System.out.println(sum/max*100.0/N);
    }
}
