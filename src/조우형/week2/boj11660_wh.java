package 조우형.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11660_wh {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] arr = new int[n+1][n+1];
        int[][] sumArr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
                sumArr[i][j] = sumArr[i][j-1] + sumArr[i-1][j] - sumArr[i-1][j-1] + arr[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            int result = sumArr[x2][y2] - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[x1-1][y1-1];
            sb.append(result + "\n");
        }

        System.out.println(sb.toString());
    }
}
