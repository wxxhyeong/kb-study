package 조우형.week12;

import java.util.*;
import java.io.*;

public class boj1010_wh {

    static int answer;
    static int N, M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            answer = 0;
            StringTokenizer stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());

            comb(0, 0);

            System.out.println(answer);
        }


    }

    public static void comb(int l, int cnt) {

        //if (l > N-)

        if (cnt == N) {
            System.out.println("-------------------------");
            answer++;
            return;
        }
        for (int i = l; i < N; i++) {
            for (int j = i; j < M; j++) {
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                comb(j, cnt+1);
            }
        }
    }
}
