package 김민지.week4;

import java.util.Stack;

public class prg12909 {

    public static void main(String[] args) {
        System.out.println(solution("(()("));
    }

    private static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.empty() ? true : false;
    }
}
