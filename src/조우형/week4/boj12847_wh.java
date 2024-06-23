package 조우형.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12847_wh {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int arr[] = new int[n];
        stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int start = 0;

        long sum = 0;

        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        long temp = sum;
        for (int i = m; i < n; i++) {
//            System.out.println("---------");
//            System.out.println("sum = " + sum);

            temp = temp - arr[start];
           //System.out.println("start = " + start);
            start++;

            temp = temp + arr[i];

            if (temp > sum) {
                sum = temp;
            }
            //System.out.println("temp = " + temp);
            
        }

        System.out.println(sum);
    }
}
