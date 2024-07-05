package 김민지.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2023 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    public static void dfs(int num, int len) {
        if (len == N) {
            if (isPrime(num))
                System.out.println(num);
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(num*10 + i)) {
                dfs(num*10 + i, len + 1);
            }
        }
    }

     public static boolean isPrime(int n) {
        for (int i=2; i <= n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}