package 장성훈.week7;

import java.util.*;

public class boj2251_sh {
    static Set<String> visited;
    static Set<Integer> answer;
    static int[] limit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = sc.nextInt();
        }

        visited = new HashSet<>();
        answer = new TreeSet<>();
        dfs(0,0, limit[2]);
        for(int num : answer) {
            System.out.print(num+" ");
        }
    }

    static void dfs(int a, int b, int c){
        String now = a + "" + b + "" + c;
        if (visited.contains(now)) {
            return;
        }

        if (a == 0) {
            answer.add(c);
        }

        visited.add(now);

        // 0 -> 1
        if(a+b > limit[1]) {
            dfs(a+b-limit[1], limit[1], c);
        }else {
            dfs(0, a+b, c);
        }

        // 1 -> 0
        if(a+b > limit[0]) {
            dfs(limit[0], a+b-limit[0], c);
        }else {
            dfs(a+b, 0, c);
        }

        // 2 -> 0
        if(a+c > limit[0]) {
            dfs(limit[0], b, a+c-limit[0]);
        }else {
            dfs(a+c, b, 0);
        }

        // 2 -> 1
        if(b+c > limit[1]) 	{
            dfs(a, limit[1], b+c-limit[1]);
        }else {
            dfs(a, b+c, 0);
        }

        // 0 -> 2
        dfs(a, 0, b+c);
        // 1 -> 2
        dfs(0, b, a+c);
    }
}
