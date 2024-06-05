package 장성훈.week1;

import java.util.Arrays;
import java.util.Scanner;

public class boj1931_sh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int prev = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        for (int i = 0; i < n; i++) {
            if (arr[i][0] < prev)  {
                continue;
            }

            prev = arr[i][1];
            count += 1;
        }

        System.out.println(count);
    }
}
