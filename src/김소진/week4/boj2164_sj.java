package 김소진.week4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 제출 시, boj2164_sj > main으로 name 변경
public class boj2164_sj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        // Queue 인터페이스를 구현한 LinkedList를 사용하여 큐를 생성합니다.
        Queue<Integer> queue = new LinkedList<>();

        // 1부터 N까지의 숫자를 큐에 넣습니다.
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 큐에 카드가 한 장 남을 때까지 다음 작업을 반복합니다.
        while (queue.size() > 1) {
            // 큐의 제일 위에 있는 카드를 제거합니다.
            //pull이 아닌 poll
            queue.poll();
            // 다음 제일 위에 있는 카드를 큐의 끝으로 이동시킵니다.
            queue.add(queue.poll());
        }
        // 마지막에 남은 카드 번호를 출력합니다.
        System.out.println(queue.peek());
    }
}
