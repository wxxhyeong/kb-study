package 김민지.week8;

import java.util.*;
import java.io.*;

public class boj2251_mj {   // 물통

    static class Water {
        int a, b, c;
        public Water(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static List<Integer> answers = new ArrayList<>();
    static int capaA, capaB, capaC;
    static boolean[][][] visited = new boolean[201][201][201];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        capaA = Integer.parseInt(st.nextToken());
        capaB = Integer.parseInt(st.nextToken());
        capaC = Integer.parseInt(st.nextToken());

        BFS();

        Collections.sort(answers);
        for (int i = 0; i < answers.size(); i++) {
            System.out.print(answers.get(i) + " ");
        }
    }

    public static void BFS(){
        Queue<Water> q = new LinkedList<>();
        q.offer(new Water(0, 0, capaC));

        while(!q.isEmpty()){
            Water water = q.poll();
            int a = water.a;
            int b = water.b;
            int c = water.c;

            if (visited[a][b][c]) { // 방문 했으면 넘기기
                continue;
            }
            visited[a][b][c] = true;

            if (a == 0) {   // a가 비었으면 c 담기
                answers.add(c);
            }

            // 6가지의 물 옮기기 케이스
            // a -> b
            if (a + b > capaB) {    // 넘치는 경우
                q.offer(new Water(a - (capaB - b), capaB, c));
            } else {
                q.offer(new Water(0, b + a, c));
            }
            // a -> c
            if (a + c > capaC) {
                q.offer(new Water(a - (capaC - c), b, capaC));
            } else {
                q.offer(new Water(0, b, c + a));
            }
            // b -> a
            if (b + a > capaA) {
                q.offer(new Water(capaA, b - (capaA - a), c));
            } else {
                q.offer(new Water(a + b, 0, c));
            }
            // b -> c
            if (b + c > capaC) {
                q.offer(new Water(a, b - (capaC - c), capaC));
            } else {
                q.offer(new Water(a, 0, c + b));
            }
            // c -> a
            if (c + a > capaA) {
                q.offer(new Water(capaA, b, c - (capaA - a)));
            } else {
                q.offer(new Water(a + c, b, 0));
            }
            // c -> b
            if (c + b > capaB) {
                q.offer(new Water(a, capaB, c - (capaB - b)));
            } else {
                q.offer(new Water(a, b + c, 0));
            }
        }
    }
}
