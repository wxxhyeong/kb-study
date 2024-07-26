package 박희범.week6;

import java.util.*;

class pgs43165 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = recur(0, 0, numbers, target);
        return answer;
    }

    int recur(int depth, int sum, int[] numbers, int target){
        if(depth == numbers.length){
            if(sum == target)
                return 1;
            return 0;
        }
        int total = 0;
        total += recur(depth + 1, sum + numbers[depth], numbers, target);
        total += recur(depth + 1, sum - numbers[depth], numbers, target);
        return total;
    }
}