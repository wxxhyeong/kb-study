package 장성훈.week5;

import java.util.Stack;

public class pgs42584_sh {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty()) {
                int prev = stack.peek();
                if (prices[i] >= prices[prev]) {
                    break;
                }
                answer[prev] = i - prev;
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int last = stack.peek();
            answer[last] = prices.length - last - 1;
            stack.pop();
        }

        return answer;
    }
}
