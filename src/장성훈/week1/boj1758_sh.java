package 장성훈.week1;

import java.util.Arrays;
import java.util.Scanner;

public class boj1758_sh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr,(o1, o2) -> o2 - o1);

        long answer = 0;
        for (int i = 0; i < n; i++) {
            int temp = arr[i] - i;
            if (temp < 0) { break; }

            answer += temp;
        }

        System.out.println(answer);
    }
}
//Arrays.sort(int[]) 에는 Comparator 를 입력받는 오버로드가 없기 때문에 Comparator 를 사용할 수 없습니다.
//Integer[] 를 사용할 때에는 Arrays.sort(T[], Comparator<? super T>) 를 호출할 수 있습니다.
