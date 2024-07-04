package 장성훈.week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1253_sh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isGoodNumber(i, arr)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean isGoodNumber(int now, int arr[]) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int target = arr[left] + arr[right];
            if (arr[now] < target || right == now) {
                right--;
            } else if (arr[now] > target || left == now) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
}