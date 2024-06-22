package 장성훈.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj11660_sh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + arr[i][j];
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int k = 0; k < m; k++) {
            String[] temp = br.readLine().split(" ");
            int x1 = Integer.parseInt(temp[0]);
            int y1 = Integer.parseInt(temp[1]);
            int x2 = Integer.parseInt(temp[2]);
            int y2 = Integer.parseInt(temp[3]);

            int result = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
            answer.append(result).append("\n");
        }

        System.out.print(answer.toString());
    }
}
