package 장성훈.week6;

import java.util.Scanner;

public class boj1300_sh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int left = 1;
        int right = k;

        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 1; i <= n; i++) {
                count += Math.min(mid/i, n);
            }

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(right);
    }
}
