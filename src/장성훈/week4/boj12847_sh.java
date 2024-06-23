package 장성훈.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12847_sh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long money = 0;
        int i = 0;
        for (; i < m; i++) {
            money += arr[i];
        }

        long max = money;
        for (; i < n; i++) {
            money -= arr[i - m];
            money += arr[i];
            max = Math.max(money, max);
        }
        System.out.println(max);
    }
}
