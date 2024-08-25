package 김민지.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1916_mj {   // 최소비용 구하기

    static class City implements Comparable<City> {
        int v, c;
        public City(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(City o) {
            return this.c - o.c;
        }
    }

    static int[] prices;
    static Map<Integer, List<City>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 도시 개수
        int M = Integer.parseInt(br.readLine());    // 버스 개수

        // graph 초기화
        for (int i=0; i<N; i++) {
            graph.put(i, new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new City(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        // prices 초기화
        int INF = Integer.MAX_VALUE;
        prices = new int[N];
        Arrays.fill(prices, INF);

        // 다익스트라
        Queue<City> q =  new PriorityQueue<>();
        q.add(new City(start, 0));
        prices[start] = 0;
        while (!q.isEmpty()) {
            City now = q.poll();

            if (now.c > prices[now.v]) continue;

            for (City next : graph.get(now.v)) {
                int newPrice = now.c + next.c;
                if (newPrice < prices[next.v]) {
                    prices[next.v] = newPrice;
                    q.add(new City(next.v, newPrice));
                }
            }
        }

        System.out.println(prices[end]);
    }
}
