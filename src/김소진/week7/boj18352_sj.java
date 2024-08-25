package 김소진.week7;

//  최단 거리를 찾는 문제 → BFS (너비 우선 탐색) 알고리즘
//  추가설명: BFS는 모든 간선의 거리가 동일할 때 최단 거리를 찾는데 유리

// BFS 알고리즘 > 출발 도시 X에서 다른 도시로 최단 거리 찾고 > K인 도시 추출

import java.util.*;

class boj18352_sj {
    public static void main(String[] args) {

        // Scanner를 사용하여 입력 읽어옴
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 도시의 개수
        int M = sc.nextInt(); // 도로의 개수
        int K = sc.nextInt(); // 거리
        int X = sc.nextInt(); // 출발 도시

        // 도로 정보를 저장할 배열 초기화
        int[][] roads = new int[M][2];
        for (int i = 0; i < M; i++) {
            roads[i][0] = sc.nextInt(); // 도로의 출발 도시
            roads[i][1] = sc.nextInt(); // 도로의 도착 도시
        }

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] road: roads){
            graph.get(road[0]).add(road[1]);
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1); // 모든 도시에 대해 거리 값 -1로 초기화
        distance[X] = 0; // 출발 도시 거리는 0으로 초기화

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(X);

        // BFS 탐색 시작
        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int next: graph.get(current)){
                if(distance[next] == -1){ // 아직 방문하지 않은 도시라면?
                    distance[next] = distance[current] + 1;
                    queue.add(next); // 다음 도시 검사 시작
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int city = 1; city <= N; city++){
            if(distance[city] == K){
                result.add(city);
            }
        }

        if(result.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(result);
            for(int city: result){
                System.out.println(city);
            }
        }
    }
}


