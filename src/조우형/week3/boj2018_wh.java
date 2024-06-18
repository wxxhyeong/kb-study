package 조우형.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2018_wh {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        int start = 1;
        int end = 1;
        int sum = 0;
        int cnt = 0;
        while (start <= n) {

            if (sum < n) {
                sum += end;
                end++;
            }
            else if (sum > n) {
                sum -= start;
                start++;
            }
            else {
                sum -= start;
                cnt++;
                start++;
            }
        }

        System.out.println(cnt);
    }

}
