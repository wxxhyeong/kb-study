package 박희범.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178_hb {
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = s.charAt(j);
            }
        }
        System.out.println(bfs(n, m, maze));
    }
    static int bfs(int n , int m, char[][] maze){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        q.add(new int[]{0, 0, 1});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == n - 1 && cur[1]  == m - 1){
                return cur[2];
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(OOD(nr, nc, n, m) || maze[nr][nc] == '0' || visited[nr][nc])
                    continue;
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, cur[2] + 1});
            }
        }
        return -1;
    }

    static boolean OOD(int nr, int nc, int n, int m){
        if(nr < 0 || nc < 0 || nr >= n || nc >= m)
            return true;
        return false;
    }
}
