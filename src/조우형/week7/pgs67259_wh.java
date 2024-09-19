package 조우형.week7;
import java.util.*;

public class pgs67259_wh {

    public int solution(int[][] board) {
        int answer = 0;

        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(0,0,0));
        visited[0][0] = 0;

        while (!deque.isEmpty()) {
            Node node = deque.pollFirst();
            int x = node.x;
            int y = node.y;
            int dir = node.dir;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (board[nx][ny] == 1)
                    continue;

                if (dir == 0) { // 1이 좌우, -1이 상하
                    if (nx == x) {
                        if (visited[x][y] + 100 < visited[nx][ny]) {
                            deque.addLast(new Node(nx, ny, 1));
                            visited[nx][ny] = visited[x][y] + 100;
                        }
                    }
                    else {
                        if (visited[x][y] + 100 < visited[nx][ny]) {
                            deque.addLast(new Node(nx, ny, -1));
                            visited[nx][ny] = visited[x][y] + 100;
                        }
                    }
                }
                else if (dir == 1) {
                    if (nx == x){
                        if (visited[x][y] + 100 < visited[nx][ny]) {
                            deque.addLast(new Node(nx, ny, 1));
                            visited[nx][ny] = visited[x][y] + 100;
                        }
                    }
                    else {
                        if (visited[x][y] + 600 < visited[nx][ny]) {
                            deque.addLast(new Node(nx, ny, -1));
                            visited[nx][ny] = visited[x][y] + 600;
                        }
                    }
                }
                else {
                    if (nx == x) {
                        if (visited[x][y] + 600 < visited[nx][ny]) {
                            deque.addLast(new Node(nx, ny, 1));
                            visited[nx][ny] = visited[x][y] + 600;
                        }
                    }
                    else {
                        if (visited[x][y] + 100 < visited[nx][ny]) {
                            deque.addLast(new Node(nx, ny, -1));
                            visited[nx][ny] = visited[x][y] + 100;
                        }
                    }
                }

            }

        }
        return answer = visited[n-1][m-1];
    }


    class Node {
        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
        int x;
        int y;
        int dir; // 1 좌우, -1 상하
    }
}
