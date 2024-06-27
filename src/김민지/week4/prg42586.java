package 김민지.week4;

import java.util.*;

public class prg42586 {
    public static void main(String[] args) {
        int[] a = solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        System.out.println(a.toString());
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int workday = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                workday++;
            }
            queue.add(workday);
        }

        int top = queue.poll();
        int cnt = 1;
        while (!queue.isEmpty()) {
            int nextwork = queue.peek();

            if (nextwork > top) {
                result.add(cnt);
                cnt = 1;
                top = queue.poll();
            } else {
                queue.poll();
                cnt++;
            }
        }
        result.add(cnt);
        int[] res = result.stream().mapToInt(i->i).toArray();

        return res;
    }
}
