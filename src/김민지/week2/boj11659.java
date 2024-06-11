package 김민지.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 기본 데이터 초기화
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N + 1];

        // 0 ~ i 구간합 구하기
        st = new StringTokenizer(br.readLine());
        nums[0] = 0;
        for (int i = 1; i <= N; i++) {
            nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
        }

        // 결과 출력하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(nums[b] - nums[a-1]);
        }
    }
}