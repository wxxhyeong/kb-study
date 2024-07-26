package 조우형.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1167_wh {
    static int n, dist;
    static ArrayList<Integer[]>[] tree;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer stk;

        tree = new ArrayList[n + 1];
        distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(stk.nextToken());
            
            while(stk.hasMoreTokens()){
                int e = Integer.parseInt(stk.nextToken());
                if (e != -1) {
                    int dist = Integer.parseInt(stk.nextToken());
                    tree[v].add(new Integer[]{e, dist});
                }
            }
        }

        for (ArrayList<Integer[]> integers : tree) {
            if (integers != null) {
                for (Integer[] integer : integers) {
                    if (integer != null) {
                        System.out.print("integer = " + Arrays.toString(integer) +"\t");
                    }
                }
            }
        }


        dist = 0;
        for (int i = 1; i <= n; i++) {

        }
    }

    static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        while (!deque.isEmpty()) {
            int v = deque.pollFirst();

            for (Integer[] integers : tree[v]) {
                int next = integers[0];
                int dist = integers[1];

                if (!visited[next]) {
                    if (distance[next] < distance[v] + dist) {
                        distance[next] = distance[v] + dist;
                    }
                }
            }
        }
    }
}
