package 조우형.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj2178_wh {

    static int[][] a;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0});

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (a[nx][ny] == 1) {
                        a[nx][ny] = a[x][y] + 1;
                        deque.add(new int[]{nx,ny});
                    }
                }
            }
        }

        System.out.println(a[n-1][m-1]);

    }
}
