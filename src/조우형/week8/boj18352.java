package 조우형.week8;

import java.util.*;
import java.io.*;
public class boj18352 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());

        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer>[] arrayList = new ArrayList[n+1];


        for (int i = 1; i <= n; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());

            arrayList[s].add(e);
        }

        int[] visited = new int[n+1];;
        for (int i = 0; i <= n; i++) {
            visited[i] = -1;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(x);
        visited[x] = 0;


        while(!deque.isEmpty()) {
            int cur = deque.pollFirst();

            for (int next : arrayList[cur]) {
                if (visited[next] == -1){
                    int dist = visited[cur] + 1;
                    if (dist == k) {
                        visited[next] = dist;
                        answer.add(next);
                        continue;
                    }
                    deque.add(next);
                    visited[next] = dist;
                }
            }
        }

        Collections.sort(answer);

        if (!answer.isEmpty()){
            for (int a : answer) {
                System.out.println(a);
            }
        }
        else {
            System.out.println("-1");
        }
    }
}
