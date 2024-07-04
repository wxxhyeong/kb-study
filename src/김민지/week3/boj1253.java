package 김민지.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1253 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int cnt = 0;
        
        // 데이터 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        // 각 숫자마다 돌아가면서 확인
        for (int i = 0; i < N; i++) {
            // 음수가 있을 수 있기 때문에
            // 양끝에서 시작해야함
            int startP = 0, endP = N - 1;

            while(true) {
                if(startP == i) startP++;
                else if(endP == i) endP--;

                // 가능한 경우가 없음
                if(startP >= endP) break;

                // 양 끝에서 시작
                // sum == M : 경우의 수 있음. break;
                // sum < M : start 이동
                // sum > M : end 이동
                long sum = nums[startP] + nums[endP];
                if (sum == nums[i]) {
                    cnt++;
                    break;
                } else if (sum < nums[i]) {
                    startP++;
                } else {
                    endP--;
                }
            }
        }
        System.out.println(cnt);
    }
}