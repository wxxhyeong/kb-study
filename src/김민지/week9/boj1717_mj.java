package 김민지.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1717_mj { // 집합의 표현
    static int[] sets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 원소 개수
        int m = Integer.parseInt(st.nextToken()); // 연산 개수

        sets = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            sets[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int func = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (func == 1) {    // 같은 집합인지 확인 연산
                isSameParent(a, b);
            } else {    // 두 집합을 합치는 연산
                union(a, b);
            }
        }
    }

    public static int find(int a) {
        if (a == sets[a]) {
            return a;
        } else {
            return sets[a] = find(sets[a]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            sets[b] = a;
        }
    }

    public static void isSameParent(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}
