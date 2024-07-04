package 조우형.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj2023_wh {

    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int size = 100000000;
        isPrime = new boolean[size];
        isPrime[0] = true;
        isPrime[1] = true;

        for (int i = 2; i < size; i++) {

            if (!isPrime[i]){
                for (int j = i + i; j < size; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        for (double i = Math.pow(10, n - 1); i < Math.pow(10, n); i++) {
            int t = (int) i;
            char[] arr = String.valueOf(t).toCharArray();

            boolean state = dfs(1, arr);
            if (state) {
                sb.append(t+ "\n");
            }
        }

        System.out.println(sb.toString());
    }

    static public boolean dfs(int idx, char[] arr) {

        if (idx > arr.length) {
            //System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
           // System.out.println("arr.length = " + arr.length);
            //System.out.println("idx = " + idx);
            return true;
        }

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            temp.append(arr[i]);
        }

        if (!isPrime[Integer.parseInt(temp.toString())]) {
            return dfs(idx + 1, arr);
        }
        else {
            return false;
        }
    }
}
