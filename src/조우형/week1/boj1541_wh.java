package 조우형.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj1541_wh {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        /* input을 어떻게 처리할 것인가. 정규표현식을 parsing 하려했으나
        정규표현식 Pattern.matches(REGEXP_CHAR_NUM, input)의 결과값이 boolean 타입
         solution -> - 를 만날 때까지 쭉 더한다
         기호와 숫자 배열을 따로?
         - 로 split을 진행하여 다 더 하고, 더한 것들을 순차적으로 뺀다.
         1. - 로 스플릿
         2. + 로 스플릿 하여 모두 더하기
         3. 2에서 나온 값들을 빼기
         */

        String[] first = input.split("-");
        Deque<Integer> values = new ArrayDeque<>();
        for (String s : first) {
            String[] second = s.split("[+]");
            int temp = 0;
            for (String s1 : second) {
                temp += Integer.parseInt(s1);
            }
            values.add(temp);
        }

        int result = values.removeFirst();

        while (!values.isEmpty()) {
            result -= values.removeFirst();
        }

        System.out.println(result);
    }
}
