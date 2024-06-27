package 장성훈.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj20437_sh {
    static char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

            for (char c : alpha) {
                map.put(c, new ArrayList<>());
            }

            String str = br.readLine();
            int target = Integer.parseInt(br.readLine()) - 1;

            for (int i = 0; i < str.length(); i++) {
                map.get(str.charAt(i)).add(i);
            }

            // 두 번째 풀이: 436ms
            // 해시맵 초기화: O(m)              // m = 해시맵에 알파벳 26개 초기화
            // 문자열 처리 및 해시맵에 저장: O(n)  // 문자열 길이 n
            // 최소/최대 길이 계산: O(m*k)       // 연속문자열 길이 k, 최대 k번 최소/최대 길이를 비교 (k = n)
            // O(m) + O(n) + O(m*k) = O(n(26+1) + 26) => O(n)
            int min = 10001;
            int max = 0;
            for (char c : alpha) {
                ArrayList<Integer> list = map.get(c);
                if (list.size() >= target) {
                    for (int j = target; j < list.size(); j++) {
                        int now = list.get(j) - list.get(j - target) + 1;
                        min = Math.min(min, now);
                        max = Math.max(max, now);
                    }
                }
            }
            answer.append(max > 0 ? min + " " + max : "-1");
            answer.append("\n");
        }
        System.out.print(answer.toString());
    }
}

/*
// 첫 번째 풀이: 2816ms
// 시간복잡도 = n(n+1)/2 => O(n^2)
for (int t = 0; t < T; t++) {
    String str = br.readLine();
    int target = Integer.parseInt(br.readLine());
    int length = str.length();

    int min = 10001;
    int max = 0;
    for (int i = 0; i < length; i++) {
        char start = str.charAt(i);
        int count = 0;
        for (int j = i; j < length; j++) {
            if (str.charAt(j) == start) {
                count++;
                if (count == target) {
                    int now = j-i+1;
                    min = Math.min(min, now);
                    max = Math.max(max, now);
                    break;
                }
            }
        }
    }
 */