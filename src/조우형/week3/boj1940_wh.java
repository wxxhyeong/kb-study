package 조우형.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1940_wh {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = n-1;
        int cnt = 0;

        while (start < end) {
            if (arr[start]+arr[end] < m) {
                start++;
            }
            else if (arr[start] + arr[end] > m) {
                end--;
            }
            else {
                cnt++;
                start++;
            }
        }

        System.out.println(cnt);
    }
}
