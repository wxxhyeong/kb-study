package 김민지.week4;

import java.util.Arrays;

public class prg178870 {
    public static void main(String[] args) {
        
    }

    public static int[] solution(int[] sequence, int k) {
        int[] result = new int[2];
        result[0] = 0;
        result[1] = sequence.length;
        int[] sums = new int[sequence.length + 1];

        Arrays.sort(sequence);
        sums[0] = 0;
        sums[1] = sequence[0];
        
        // 누적합
        for(int i=0; i < sequence.length; i++) {
            sums[i+1] = sequence[i] + sums[i];
        }
        
        // 투포인터
        int start_index = 0, end_index = 0;
        while(start_index <= end_index) {
            if (end_index > sequence.length - 1)
                break;

            int sum = sums[end_index + 1] - sums[start_index];
            if (sum == k) {
                if ((result[1] - result[0]) == (end_index - start_index)) {
                    // 부분 수열 길이가 같을 때
                    if (result[0] > start_index) {
                        result[0] = start_index;
                        result[1] = end_index;
                        end_index++;
                    } else {
                        end_index++;
                    }
                } else if ((result[1] - result[0]) > (end_index - start_index)) {
                    // 부분 수열 길이가 짧을 때
                    result[0] = start_index;
                    result[1] = end_index;
                    end_index++;
                } else {
                    end_index++;
                }
            } else if (sum > k) {
                // 두 구간의 합이 k 보다 크면,
                start_index++;
            } else {
                end_index++;
            }
        }
 
        return result;
    }
}
