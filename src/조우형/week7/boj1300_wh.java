package 조우형.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1300_wh {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 1;
        int end = k;
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }

            if (cnt < k) {
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        System.out.println(start);

    }
}
