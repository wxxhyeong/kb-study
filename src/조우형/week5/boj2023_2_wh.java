package 조우형.week5;

import java.io.*;

public class boj2023_2_wh {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int[] primeOne = new int[]{2, 3, 5, 7}; //소수인 첫번째 자리수

        if (n == 1) {
            for (int i : primeOne) {
                System.out.println(i);
            }
        }
        else
            for (int i : primeOne) {
                dfs(i, 0);
            }
    }

    static void dfs(int num, int k) {
        //System.out.println("dfs");
        if (isPrime(num)) {
            if (k == n-1) {
                //System.out.println("k = " + k);
                System.out.println(num);
            }
            else
                for (int i = 1; i < 10; i = i + 2) {
                    //System.out.println(num);
                    //System.out.println("k = " + k);
                    dfs(num * 10 + i, k + 1);

                }
        }
    }

    static boolean isPrime(int num) {
        //System.out.println("isPrime");
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
