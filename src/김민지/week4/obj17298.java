package 김민지.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class obj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] seq = new int[N];
        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // 조건을 만족할 때까지
        // stack pop --> 현재의 원소로 바꿔줌
        for(int i = 0; i < N; i++) {

            while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
                seq[stack.pop()] = seq[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            seq[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(seq[i]).append(' ');
        }

        System.out.println(sb);
    }
}
