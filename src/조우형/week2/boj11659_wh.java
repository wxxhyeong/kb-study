package 조우형.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11659_wh {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N+1];
        int[] sumArr = new int[N+1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(stk.nextToken());
            sumArr[i] = sumArr[i-1] + input;
        }

        int[][] arr2 = new int[M][2];
        for (int t = 0; t < M; t++) {
            stk = new StringTokenizer(br.readLine());
            int fir = Integer.parseInt(stk.nextToken());
            int sec = Integer.parseInt(stk.nextToken());

            sb.append(sumArr[sec] - sumArr[fir-1]+"\n");
        }

        System.out.println(sb.toString());
    }
}