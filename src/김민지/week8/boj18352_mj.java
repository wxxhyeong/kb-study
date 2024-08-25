package 김민지.week8;

import java.io.*;
import java.util.*;

public class boj18352_mj { // 특정 거리의 도시 찾기
    // Bfs
    // Node, min(weight)
    static class City {
        int node, weight;

        public City(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static List<Integer>[] graph;
    static List<City> cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 도시 개수
        int M = Integer.parseInt(st.nextToken());   // 도로의 수
        int K = Integer.parseInt(st.nextToken());   // 거리 정보
        int X = Integer.parseInt(st.nextToken());   // 출발 도시

        graph = new ArrayList[N + 1];
        // graph 생성
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        // 최단 거리 정보를 저장할 리스트 생성
        cities = new ArrayList<>();
        for (int i=0; i < N+1; i++) {
            cities.add(new City(i, K+99));
        }

        BFS(X);

        // 결과
        List<Integer> results = new ArrayList<>();
        cities.stream().forEach(a -> {
            if (a.weight == K) results.add(a.node);
        });

        if (results.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(results);
            results.forEach(System.out::println);
        }
    }

    public static void BFS(int node) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.add(node);
        cities.set(node,new City(node,0));  // 시작 노드의 weight를 0으로 세팅

        while (!que.isEmpty()) {
            int now = que.poll();
            for (Integer next : graph[now]) {
                int weight = cities.get(now).weight + 1;

                if (weight < cities.get(next).weight) { // 다음 스탭의 노드의 weight가 더 작은수로 접근이 가능하다면
                    cities.set(next, new City(next, weight));
                    que.add(next);
                }
            }
        }
    }
}