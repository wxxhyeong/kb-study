package 조우형.week10;

import java.io.*;
import java.util.*;
public class boj1916_wh {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(stk.nextToken());
        int E = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] list = new ArrayList[V+1];
        for (int i = 0; i < V+1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());

            list[start].add(new int[]{end, v});
            list[end].add(new int[]{start, v});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
            Integer.compare(o1[1], o2[1]));


    }
}
