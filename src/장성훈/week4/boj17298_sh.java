package 장성훈.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj17298_sh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 배열에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정답 배열
        int[] ans = new int[N];
        // 오큰수 확인용 스택
        Stack<Integer> stack = new Stack<>();
        for (int i = N-1; i >= 0; i--) {
            int num = arr[i];

            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int item : ans) {
            sb.append(item).append(" ");
        }

        System.out.println(sb.toString());
    }
}
