package 조우형.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj2251_wh {

    static int[] water;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());
        water = new int[]{A, B, C};

        boolean[] answer = new boolean[201];
        boolean[][] waterAB = new boolean[201][201];

        Deque<AB> deque = new ArrayDeque<>();
        deque.add(new AB(0, 0));
        waterAB[0][0] = true;
        answer[C] = true;

        int[][] graph = new int[][]{{1, 2}, {0, 2}, {0, 1}};
        while (!deque.isEmpty()) {
            AB ab = deque.pollFirst();
            int a = ab.a;
            int b = ab.b;
            int c = C - a - b;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    int[] nwater = new int[]{a, b, c};

                    nwater[i] = nwater[i] + nwater[graph[i][j]];
                    nwater[graph[i][j]] = 0;

                    if (nwater[i] > water[i]) {
                        nwater[graph[i][j]] = nwater[i] - water[i];
                        nwater[i] = water[i];
                    }

                    if (!waterAB[nwater[0]][nwater[1]]) {
                        waterAB[nwater[0]][nwater[1]] = true;
                        deque.add(new AB(nwater[0], nwater[1]));
                        if (nwater[0] == 0) {
                            answer[nwater[2]] = true;
                        }
                    }
                }
            }

        }

        for (int i = 0; i < 201; i++) {
            if (answer[i])
                System.out.print(i+" ");
        }
    }
}


class AB {
    int a;
    int b;

    public AB(int a, int b) {
        this.a = a;
        this.b = b;
    }
}