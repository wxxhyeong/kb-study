import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class boj13023_sj {
    // 인접 리스트를 저장할 배열
    static ArrayList<Integer>[] A;
    // 방문 여부를 확인할 배열
    static boolean visited[];
    // 깊이가 5인 경로가 존재하는지 확인할 변수
    static boolean arrive;

    // 깊이 우선 탐색(DFS) 메서드
    static void dfs(int now, int depth) {
        // 깊이가 5가 되면 경로가 존재함을 표시하고 종료
        if(depth == 5) {
            arrive = true;
            return;
        }
        // 현재 정점을 방문 표시
        visited[now] = true;
        // 현재 정점에 인접한 정점들을 순회
        for(int i : A[now]) {
            // 방문하지 않은 정점에 대해 DFS 호출
            if(visited[i] == false) {
                dfs(i, depth + 1);
            }
        }
        // DFS 종료 후 방문 표시 해제 (백트래킹)
        visited[now] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 수 N과 간선의 수 M을 입력받음
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트와 방문 배열 초기화
        A = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        // 간선 정보를 입력받아 인접 리스트에 추가
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            A[e1].add(e2);
            A[e2].add(e1);
        }

        // 각 정점에서 DFS를 시작
        for(int i = 0; i < N; i++) {
            dfs(i, 1);
            // 깊이가 5인 경로가 존재하면 반복문 종료
            if(arrive == true) {
                break;
            }
        }

        // 깊이가 5인 경로가 존재하면 1, 그렇지 않으면 0 출력
        if(arrive == true) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
