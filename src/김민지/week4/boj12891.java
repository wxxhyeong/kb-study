package 김민지.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        char[] dna = br.readLine().toCharArray();
        int[] default_cnt = new int[4];
        int[] alpha_cnt = new int[4];

        // 각 문자별 개수 조건
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            default_cnt[i] = Integer.parseInt(st.nextToken());
        }

        // DNA의 초기 부분문자열의 문자별 개수
        for (int i = 0; i < M; i++) {
            if (dna[i] == 'A')
                alpha_cnt[0]++;
            else if (dna[i] == 'C')
                alpha_cnt[1]++;
            else if (dna[i] == 'G')
                alpha_cnt[2]++;
            else if (dna[i] == 'T')
                alpha_cnt[3]++;
        }

        for (int i = 0; i <= N - M; i++) {
            boolean flag = true;

            // 부분문자열의 값 비교
            for (int j = 0; j < alpha_cnt.length; j++) {
                if (alpha_cnt[j] < default_cnt[j]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                cnt++;
            }

            if (i == N - M) {
                break;
            }

            // alpha_cnt의 값 바꾸기
            // starP의 문자 --, endP의 문자 ++
            alpha_cnt[getIndex(dna[i])]--;
            alpha_cnt[getIndex(dna[M + i])]++;
        }

        System.out.println(cnt);
    }

    private static int getIndex(char alph) {
        if (alph == 'A') {
            return 0;
        } else if (alph == 'C') {
            return 1;
        } else if (alph == 'G') {
            return 2;
        } else if (alph == 'T') {
            return 3;
        }
        return -1;
    }
}
