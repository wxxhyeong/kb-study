package 조우형.week9;

import java.util.*;
import java.io.*;

public class boj1717_wh {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            if (a == 0) {
                union(s, e);
            }
            else {
                if (find(s) == find(e) ){
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int s, int e) {
        s = find(s);
        e = find(e);

        if (s != e) {
            arr[e] = s;
        }
    }

    public static int find(int a) {
        if (arr[a] == a) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }
}