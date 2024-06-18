package 김민지.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class boj2217_mj {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] ropes = new Integer[n];
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            result = Math.max(result, ropes[i] * (i + 1));
        }

        System.out.print(result);
    }
}