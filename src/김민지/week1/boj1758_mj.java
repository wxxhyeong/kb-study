package 김민지.week1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Arrays;

public class boj1758_mj {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Integer[] tips = new Integer[n];
        Long result = 0l;

        for (int i = 0; i < n; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tips, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int tmp = tips[i] - i;
            if (tmp < 0)
                break;
            else
                result += tmp;
        }
        
        System.out.print(result);
    }
}