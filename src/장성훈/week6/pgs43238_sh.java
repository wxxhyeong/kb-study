package 장성훈.week6;

//import java.util.Arrays;

public class pgs43238_sh {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7,10}));
        System.out.println(solution(3, new int[]{1,99,99}));
    }

    public static long solution(int n, int[] times) {
        long left = 1;
        long right = (long)times[times.length-1] * n;

        while (left < right) {
            long mid = (left + right)/2;
            if (canProcessTargetInTime(mid, times, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 주어진 시간동안 n명을 심사할 수 있는지 확인
    static boolean canProcessTargetInTime(long minute, int[] times, int n) {
        long count = 0;

        for (int time : times) {
            count += (minute / time);
        }
        return count >= (long) n;
    }
}
