package 조우형.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

public class boj1463_wh {
    
    // 내 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 2; i <= N; i++) {
            if (dp[i] == 0) continue;

            if (i*3 <= N) {
                if (dp[i*3] == 0)
                    dp[i*3] = dp[i] + 1;
                else
                    dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
            if (i*2 <= N) {
                if (dp[i*2] == 0)
                    dp[i*2] = dp[i] + 1;
                else
                    dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if (i+1 <= N) {
                if (dp[i+1] == 0)
                    dp[i+1] = dp[i] + 1;
                else
                    dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
            }

        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);

    }
    
    // 좀 더 간단화한 정답 풀이
    public void solution() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int dp[] = new int[number+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= number; i++){
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        System.out.println(dp[number]);
    }
}
