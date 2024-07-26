package 장성훈.week5;

import java.util.Scanner;

public class boj2023_sh {
    static StringBuilder sb = new StringBuilder();

    public static boolean isPrime(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void checkSpecialPrime(int num, int digit, int N) {
        if (digit == N) {
            if (isPrime(num)) {
                sb.append(num).append("\n");
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (isPrime(num*10 + i)) {
                checkSpecialPrime(num*10 + i, digit+1, N);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        checkSpecialPrime(2, 1, N);
        checkSpecialPrime(3, 1, N);
        checkSpecialPrime(5, 1, N);
        checkSpecialPrime(7, 1, N);

        System.out.println(sb.toString());
        sc.close();
    }
}
