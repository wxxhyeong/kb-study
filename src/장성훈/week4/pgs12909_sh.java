package 장성훈.week4;

import java.util.List;
import java.util.ArrayList;

public class pgs12909_sh {
    boolean solution(String s) {
        boolean answer = true;

        List<Character> arr = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                arr.add(c);
            } else {
                if (arr.isEmpty() || arr.get(arr.size() - 1) != '(') {
                    return false;
                } else {
                    arr.remove(arr.size() - 1);
                }
            }
        }
        return arr.isEmpty();
    }
}