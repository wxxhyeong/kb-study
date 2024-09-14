package 조우형.week13;

import java.util.*;
public class pgs12941_wh {

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B); // Arrays.sort(array, Collections.reverseOrder());
        // 역정렬은 wrapper 클래스만 가능

        for (int i = 0; i < A.length; i++ ) {

            answer += A[i] * B[B.length-i-1];
        }

        return answer;
    }
}
