package 조우형.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1253_wh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < n; i++) {

            long find = arr[i];

            int start = 0;
            int end = n-1;

            while(start < end) {
                if (arr[start] + arr[end] == find) {
                    if (start != i && end != i) {
                        cnt++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                }
                else if (arr[start]+ arr[end] < find) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }

        System.out.println(cnt);
    }
}
