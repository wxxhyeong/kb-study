package 김소진.week7;

// DFS로 모든 컴퓨터 각각 연결된 것을 세야한다
// count 값을 리턴해서, 내림차순으로 출력한다
// 매개변수: 컴퓨터의 개수 N, 신뢰관계 개수 M

import java.util.*;

public class boj1325_sj {
    public static void main(String[] args) {
        // 사용자로부터 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 컴퓨터(정점)의 수와 신뢰 관계(간선)의 수를 입력 받음
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 그래프를 표현하기 위한 리스트 생성 (1번 정점부터 사용하기 위해 n+1 크기로 생성)
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>()); // 각 정점에 대한 리스트 초기화
        }

        // 신뢰 관계를 그래프에 입력 받음 (b를 신뢰하는 a를 그래프에 추가)
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(b).add(a);
        }

        // 각 정점에서 시작했을 때 해킹 가능한 컴퓨터 수를 저장할 배열
        int[] result = new int[n+1];

        // 모든 정점에 대해 BFS 탐색을 수행
        for(int i = 1; i <= n; i++){
            boolean[] visited = new boolean[n + 1]; // 방문 여부를 확인하기 위한 배열
            Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐
            queue.add(i); // 시작 정점을 큐에 추가
            visited[i] = true; // 시작 정점을 방문했다고 표시
            int count = 0; // 해킹 가능한 컴퓨터 수를 세기 위한 변수

            // 큐가 빌 때까지 반복
            while(!queue.isEmpty()){
                int current = queue.poll(); // 큐에서 정점을 하나 꺼냄
                count++; // 해킹 가능한 컴퓨터 수 증가
                // 현재 정점의 인접 정점을 모두 확인
                for(int neighbor: graph.get(current)){
                    if(!visited[neighbor]){ // 인접 정점이 아직 방문되지 않았다면
                        visited[neighbor] = true; // 인접 정점을 방문했다고 표시
                        queue.add(neighbor); // 인접 정점을 큐에 추가
                    }
                }
            }
            result[i] = count; // 현재 정점에서 시작했을 때 해킹 가능한 컴퓨터 수 저장
        }

        // 해킹 가능한 컴퓨터 수 중 최대 값을 찾음
        int maxHack = Arrays.stream(result).max().getAsInt();
        // 최대 해킹 가능한 컴퓨터 수를 가진 정점을 출력
        for(int i = 1; i <= n; i++){
            if(result[i] == maxHack){
                System.out.print(i + " "); // 정점을 출력
            }
        }
    }
}