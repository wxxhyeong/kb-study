package 김소진.week7;

//이분 그래프
//

import java.util.*;

public class boj1707_sj {
    // 그래프의 정보를 저장하기 위한 리스프
    private static List<Integer>[] graph;
    // 정점의 색을 저장하기 위한 배열 (0: 미방문, 1: 그룹1, -1: 그룹2)
    private static int[] colors;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스의 개수 입력
        int K = sc.nextInt();

        // 각 테스트 케이스에 대해 반복
        for (int t = 0; t < K; t++) {
            // 정점의 개수와 간선의 개수 입력
            int V = sc.nextInt();
            int E = sc.nextInt();

            // 그래프 초기화
            graph = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            // 간선 정보 입력
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                // 양방향 간선 추가
                graph[u].add(v);
                graph[v].add(u);
            }

            // 색 배열 초기화
            colors = new int[V + 1];
            boolean isBipartite = true;

            // 모든 정점을 검사
            for (int i = 1; i <= V; i++) {
                // 정점이 미방문 상태인 경우 BFS 시작
                if (colors[i] == 0) {
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            // 결과 출력
            System.out.println(isBipartite ? "YES" : "NO");
        }

        sc.close();
    }

    // BFS를 이용해 이분 그래프인지 검사
    private static boolean bfs(int start) {
        // BFS를 위한 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        // 시작 정점을 큐에 추가하고 그룹1에 배정
        queue.offer(start);
        colors[start] = 1;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 정점을 하나 꺼냄
            int node = queue.poll();
            // 인접한 모든 정점을 검사
            for (int neighbor : graph[node]) {
                // 인접한 정점이 미방문 상태인 경우
                if (colors[neighbor] == 0) {
                    // 현재 정점과 다른 그룹으로 배정하고 큐에 추가
                    colors[neighbor] = -colors[node];
                    queue.offer(neighbor);
                }
                // 인접한 정점이 같은 그룹인 경우 이분 그래프가 아님
                else if (colors[neighbor] == colors[node]) {
                    return false;
                }
            }
        }

        // 이분 그래프인 경우
        return true;
    }
}