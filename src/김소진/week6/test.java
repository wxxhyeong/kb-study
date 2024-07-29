// io와 util은 다른것인가?
import java.io.*;
import java.util.*;

publi class Main{

    static int[][] map;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
                StringTokenizer st = new STringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer,parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[n-1][m-1]);

        br.close();
    }

    static void bfs(int x, int y){
        queue.offer(new int[](x,y});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            fir(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >=0 && nx < n && ny >= 0 && ny < m){
                    if(map[nx][ny] == 1){
                        queue.offer(new int[]{nx, ny});
                        map[nx][ny] = map[cx][cy] + 1;
                    }
                }
        }
    }
}