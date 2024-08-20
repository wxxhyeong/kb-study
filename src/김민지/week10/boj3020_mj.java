package 김민지.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj3020_mj {  // 개똥벌레

    public static void main(String[] args) throws IOException {  // 이분탐색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[N/2];
        int[] up = new int[N/2];
        for (int i = 0; i < N/2; i++) {
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            down[i] = x;
            up[i] = y;
        }
        // 순서가 달라져도 상관없으니
        // 최소값 및 개수 계산을 효율적으로 하기 위해
        Arrays.sort(down);
        Arrays.sort(up);

        int hurdleCnt = N;
        int total = 0;
        for (int i=1; i<=H; i++) {
            int tmpCnt = binarySearch(0, N/2, i, down) + binarySearch(0, N/2, H - i + 1, up) + 1;

            if (hurdleCnt == tmpCnt) {
                total++;
                continue;
            }
            if (tmpCnt < hurdleCnt) {
                hurdleCnt = tmpCnt;
                total = 1;
            }
        }
        System.out.println(hurdleCnt + ' ' + total);
    }

    public static int binarySearch(int left, int right, int h, int[] arr) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr.length - right;
    }





    public static void sol1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] graph = new int[H][N];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = 0;
            }
        }

        // 장애물
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(br.readLine());
            if (i%2 == 0) { // 석순
                for(int j=0; j<p; j++){
                    graph[H - 1 - j][i] = 1;
                }
            } else {  // 종유석
                for(int j=0; j<p; j++){
                    graph[j][i] = 1;
                }
            }
        }

        // 최적 경로의 장애물 수와 경로 수
        int[] hurdleCnt = new int[N];
        for (int i = 0; i < N; i++) {
            for (int a : graph[i]) {
                if(a == 1) hurdleCnt[i]++;
            }
        }

        int total = 0;
        int minValue = Arrays.stream(hurdleCnt).min().getAsInt();
        for (int cnt : hurdleCnt) {
            if (cnt == minValue)
                total++;
        }

        System.out.println(minValue + " " + total);
    }
}
