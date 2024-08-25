package 장성훈.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2343_sh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] lectures = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
        }

        int left = lectures[lectures.length - 1];
        int right = Arrays.stream(lectures).sum();

        while (left < right) {
            int mid = (left + right) / 2;   // diskCapacity
            int count = 1;
            int sum = 0;    // diskAvailable

            for (int i = 0; i < n; i++) {
                // 목표 크기를 초과하는 경우에는 새 디스크에 저장
                if (lectures[i] > mid) {
                    count = m+1;
                    break;
                }

                if (sum + lectures[i] > mid) {
                    sum = lectures[i];
                    count++;
                } else {
                    sum += lectures[i];
                }
            }

            if (count > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }
}
