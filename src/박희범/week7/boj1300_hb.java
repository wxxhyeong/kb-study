package 박희범.week7;

import java.io.*;

public class boj1300_hb {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        long low = 1;
        long high = (long) N * N;
        long mid;
        long cnt;
        while (low < high) {
            cnt = 0;
            mid = low + (high - low) / 2;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, mid / i);
            }
            if (k <= cnt) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }
}
