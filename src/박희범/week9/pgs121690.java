package 박희범.week9;

import java.util.*;

class pgs121690 {
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    public int solution(int n, int m, int[][] hole) {
        int answer = 0;
        boolean[][][] visited = new boolean[n][m][2];
        for(int[] h : hole){
            visited[h[0] - 1][h[1] - 1][0] = true;
            visited[h[0] - 1][h[1] - 1][1] = true;
        }
        answer = bfs(visited, n, m);
        return answer;
    }
    int bfs(boolean[][][] visited, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == n - 1 && cur[1] == m - 1)
                return cur[3];
            for(int i = 0; i < 4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(!OOD(nr, nc, n, m) && !visited[nr][nc][cur[2]]){
                    visited[nr][nc][cur[2]] = true;
                    q.add(new int[]{nr, nc, cur[2], cur[3] + 1});
                }
                if(cur[2] == 1){
                    nr = cur[0] + dr[i] * 2;
                    nc = cur[1] + dc[i] * 2;
                    if(OOD(nr, nc, n, m) || visited[nr][nc][0])
                        continue;
                    visited[nr][nc][0] = true;
                    q.add(new int[]{nr, nc, 0, cur[3] + 1});
                }
            }
        }
        return -1;
    }
    boolean OOD(int r, int c, int n, int m){
        if(r < 0 || c < 0 || r >= n || c >= m)
            return true;
        return false;
    }
}