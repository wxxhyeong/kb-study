package 장성훈.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj10986_sh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int[] count = new int[m];   // 누적합의 나머지별 경우의 수
        long tempSum = 0;
        List<Long> prefixSum = new ArrayList<>();
        for (long num : arr) {
            tempSum = (tempSum + num) % m;
            prefixSum.add(tempSum);
            count[(int) tempSum]++;
        }

        long answer = 0;         // 누적합의 나머지가 0이 되는 경우의 수
        answer += count[0];      // 구간 1개(prefixSum[i] % m == 0)
        for (long num : count) { // 구간 2개(prefixSum[i] - prefixSum[j] % m == 0)
            answer += calcCases(num);
        }

        System.out.println(answer);
    }

    public static long calcCases(long target) {
        if (target < 2) {
            return 0;
        }

        return target * (target-1) / 2; // nC2 = n*(n-1)/2
    }
}
