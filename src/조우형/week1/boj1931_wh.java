package 조우형.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj1931_wh {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] rooms = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            rooms[i][0] = Integer.parseInt(stk.nextToken());
            rooms[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(rooms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int end = rooms[0][1];
        int cnt = 1;

        for (int i = 1; i < N; i++) {
            if (rooms[i][0] >= end) {
                cnt++;
                end = rooms[i][1];
            }
        }

        System.out.println(cnt);
    }
}
