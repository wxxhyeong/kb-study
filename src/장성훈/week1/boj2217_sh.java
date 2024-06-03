import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = max(answer, arr[i] * (n-i));
        }

        System.out.println(answer);
    }
}
