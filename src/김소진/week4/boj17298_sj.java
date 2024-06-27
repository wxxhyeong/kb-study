package 김소진.week4;

import java.util.Scanner;
import java.util.Stack;

public class boj17298_sj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        scanner.close();

        // 결과 배열을 -1로 초기화
        for (int i = 0; i < N; i++) {
            result[i] = -1;
        }

        // 스택 할당, 오큰수 찾기
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            // 스택이 비어있지 않고 현재 요소가 스택의 맨 위 요소가 가리키는 값보다 클 때
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                // 현재 요소가 스택의 맨 위 요소의 오큰수입니다.
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}

