import java.io.*;
import java.util.*;

public class boj1167_sj {

    static List<int[]>[] tree; // 트리의 인접 리스트를 저장할 배열
    static boolean[] visited;  // 방문 여부를 체크할 배열
    static int maxDistance = 0; // 트리의 지름(최대 거리)
    static int farthestNode = 0; // 가장 먼 노드를 저장할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine()); // 트리의 정점 개수 입력

        tree = new ArrayList[V + 1]; // 트리의 인접 리스트 초기화
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>(); // 각 정점을 리스트로 초기화
        }

        // 간선 정보 입력 처리
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken()); // 현재 정점 번호
            while (true) {
                int adj = Integer.parseInt(st.nextToken()); // 인접 정점 번호
                if (adj == -1) break; // -1이면 입력 종료
                int weight = Integer.parseInt(st.nextToken()); // 인접 정점까지의 거리
                tree[node].add(new int[]{adj, weight}); // 인접 리스트에 추가
            }
        }

        // 첫 번째 DFS 수행: 임의의 정점(1번 정점)에서 가장 먼 정점을 찾음
        visited = new boolean[V + 1]; // 방문 여부 초기화
        dfs(1, 0); // DFS 시작 (시작 정점: 1, 초기 거리: 0)

        // 두 번째 DFS 수행: 첫 번째 DFS에서 찾은 정점에서 다시 가장 먼 정점을 찾음
        visited = new boolean[V + 1]; // 방문 여부 초기화
        dfs(farthestNode, 0); // DFS 시작 (시작 정점: farthestNode, 초기 거리: 0)

        System.out.println(maxDistance); // 트리의 지름 출력
    }

    // DFS 메서드: 현재 정점(node)과 누적 거리(distance)를 인자로 받음
    static void dfs(int node, int distance) {
        visited[node] = true; // 현재 정점을 방문 처리
        if (distance > maxDistance) { // 누적 거리가 최대 거리보다 크면
            maxDistance = distance; // 최대 거리 갱신
            farthestNode = node; // 가장 먼 정점을 현재 정점으로 갱신
        }

        // 현재 정점에 인접한 모든 정점을 탐색
        for (int[] adj : tree[node]) {
            int nextNode = adj[0]; // 다음 인접 정점
            int nextDist = adj[1]; // 다음 인접 정점까지의 거리
            if (!visited[nextNode]) { // 인접 정점을 방문하지 않았다면
                dfs(nextNode, distance + nextDist); // 인접 정점으로 DFS 수행
            }
        }
    }
}
