package 조우형.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class boj2217_wh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i]*(i+1) > result) {
                result = arr[i] * (i + 1);
            }
        }

        System.out.println(result);
    }

}
