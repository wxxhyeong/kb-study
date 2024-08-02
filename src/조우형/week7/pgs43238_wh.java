package 조우형.week7;

import java.util.Arrays;

public class pgs43238_wh {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7,10}));
    }


    static public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long start = 0;
        long end = times[times.length-1] * (long)n;

        while (start <= end) {

            long k = 0;
            long mid = (start + end)/2;

            for (int i = 0; i < times.length; i++) {
                long temp = mid/times[i];

                k += temp;
            }

            //System.out.println("k = " + k);
            //System.out.println("spare = " + spare);
            if (k < n) { // mid가 작기때문에 인원이 남았으므로, mid를 키우기 위해 start = mid + 1
                start = mid + 1;
            }
            else {
                end = mid -1;
                answer = mid;
            }
        }
        return answer;
    }

}
