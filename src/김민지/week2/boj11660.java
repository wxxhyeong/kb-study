package 김민지.week2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 기본 데이터 초기화
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N+1][N+1];

        // graph 초기화
        for(int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++) {
                graph[i][j] = graph[i][j-1] + graph[i-1][j] - graph[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        // 결과 출력하기
        int result = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            result = graph[x2][y2] - graph[x1-1][y2] - graph[x2][y1-1] + graph[x1-1][y1-1];
            System.out.println(result);
        }
    }
}