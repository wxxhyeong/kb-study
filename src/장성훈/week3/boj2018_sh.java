package 장성훈.week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2018_sh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        int left = 1, right = 0, now = 0, count = 0;
        while (right <= n) {
            if (now == n) {
                count++;
                now -= arr[left];
                left++;
            } else if (now < n) {
                right++;
                if (right <= n) {
                    now += arr[right];
                }
            } else {
                now -= arr[left];
                left++;
            }
        }
        System.out.println(count);
    }
}