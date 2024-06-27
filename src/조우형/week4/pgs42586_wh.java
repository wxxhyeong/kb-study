package 조우형.week4;

import java.util.ArrayList;
import java.util.Stack;

public class pgs42586_wh {

    public int[] solution(int[] progresses, int[] speeds) {

        int[] day = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int temp = 100-progresses[i];
            day[i] = temp/speeds[i];

            if (temp%speeds[i] != 0 )
                day[i]++;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < day.length; i++) {

            if (stack.isEmpty()) {
                stack.push(day[i]);
                count++;
                continue;
            }

            if (stack.peek() >= day[i]) {
                count++;
            }
            else { //stack.peek() < day[i]
                arrayList.add(count);
                stack.pop();
                stack.push(day[i]);
                count = 1;
            }
        }
        arrayList.add(count);
        int[] answer = new int[arrayList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
}
