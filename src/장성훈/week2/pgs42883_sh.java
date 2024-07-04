package 장성훈.week2;

import java.util.*;

public class pgs42883_sh {
    public String solution(String number, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : number.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }

        int cnt = k;
        List<Integer> answer = new ArrayList<>();
        for (int num : numbers) {
            if (answer.isEmpty()) {
                answer.add(num);
                continue;
            }

            while (cnt > 0 && !answer.isEmpty()) {
                if (answer.get(answer.size() - 1) >= num) { break; }
                answer.remove(answer.size() - 1);
                cnt--;
            }

            answer.add(num);
            if (answer.size() == numbers.size() - cnt) { break; }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num);
        }
        return sb.toString();
    }
}
