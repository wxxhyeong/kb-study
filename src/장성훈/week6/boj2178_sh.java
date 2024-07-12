package 장성훈.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
public class boj2178_sh {
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maze = new int[n][m];

        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());    // 101111
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = bfs(maze, n, m);
        System.out.println(answer);
    }

    private static int bfs(int[][] maze, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        maze[0][0] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                if (x == n - 1 && y == m - 1) {
                    return maze[x][y];
                }

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 1){
                        maze[nx][ny] = maze[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}
