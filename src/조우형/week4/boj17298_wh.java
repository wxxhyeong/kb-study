package 조우형.week4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj17298_wh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
/*

        for (int an : ans) {
            System.out.print(an + " ");
        }
*/
        //System.out.println();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}