package 조우형.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20438_wh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int Q = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] kArr = new int[K];
        int[] qArr = new int[Q];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            kArr[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0; i < Q; i++) {
            qArr[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        int fir = Integer.parseInt(stk.nextToken());
        int sec = Integer.parseInt(stk.nextToken());


        boolean[] arr = new boolean[N];
        for (int i = 0; i < Q; i++) {
            int cur = qArr[i];

            for (int j = 0; j < K; j++) {
                //if ()
            }
        }

    }
}
