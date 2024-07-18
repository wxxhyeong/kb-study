package 조우형.week7;

import java.util.*;
import java.io.*;

class boj2343_wh{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] video = new int[9];
        stk = new StringTokenizer(br.readLine());

        int avg = 0;
        for (int i = 0; i < n; i++) {
            video[i] = Integer.parseInt(stk.nextToken());
            avg += video[i];
        }

        avg = avg/m;

        int start = 1;
        int end = avg;

        while (start <= end) {
            int mid = (start+end)/2;

            int sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                sum += video[i];
                if (sum > mid){
                    sum = video[i];
                    cnt++;
                }
            }
            // cnt가 m보다 더 크면....
        }


    }
}
