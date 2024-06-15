package 김민지.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int startP = 0, endP = 0, sum = 0, cnt = 0;

        // 투포인터
        while ( startP <= N ) {
            if (sum == N) {
                cnt++;
                sum += endP;
                endP++;
            }

            if (sum < N) {
                sum += endP;
                endP++;
            }

            if (sum > N) {
                sum -= startP;
                startP++;
            }
        }
        System.out.print(cnt);
    }
}
