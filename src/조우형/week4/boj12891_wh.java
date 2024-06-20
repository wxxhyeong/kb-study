package 조우형.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12891_wh {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(stk.nextToken()); // 임의로 만든 DNA 문자열
        int P = Integer.parseInt(stk.nextToken()); // 사용할 부분 문자열 길이

        char[] tempDna = br.readLine().toCharArray(); // 임의로 만든 문자열
        char[] reqDna = new char[]{'A', 'C', 'G', 'T'};
        int[] dnaCond = new int[4]; // acgt 조건

        int cnt = 0;
        int result = 0;

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int input = Integer.parseInt(stk.nextToken());

            dnaCond[i] = input;; // acgt 요구사항 개수
        }

        int[] cntArr = new int[4]; // 내 부분문자열에서 acgt 개수 체크

        for (int i = 0; i < P; i++) {
            for (int j = 0; j < 4; j++) {
                if (reqDna[j] == tempDna[i]) {
                    cntArr[j]++;
                }
            }
        }
        //System.out.println("cnt = " + cnt);
        for (int k = 0; k < 4; k++) {
            if (cntArr[k] >= dnaCond[k]) {
                cnt++;
            }
        }

        if (cnt == 4) {
            result++;
        }


        int start = 0;

//        System.out.println("S = " + S);
//        System.out.println("P = " + P);
//        System.out.println("cnt = " + cnt);
//        System.out.println("result = " + result);
//        System.out.println("Arrays.toString(cntArr) = " + Arrays.toString(cntArr));


        for (int i = P; i < S; i++) {
            int count = cnt;
           //System.out.println("-------------------------");
            for (int k = 0; k < 4; k++) {
                if (tempDna[i] == reqDna[k]) {
                    cntArr[k]++;
                }
            }

            for (int k = 0; k < 4; k++) {
                if (tempDna[start] == reqDna[k]) {
                    cntArr[k]--;
                }
            }
            start++;
//            System.out.println("start = " + start);
//            System.out.println("end = " + i);
//            System.out.println("cntArr = " + Arrays.toString(cntArr));
//            System.out.println("Arrays.toString(dnaCond) = " + Arrays.toString(dnaCond));

            for (int k = 0; k < 4; k++) {
                if (cntArr[k] >= dnaCond[k]) {
                    count++;
                }
            }

           // System.out.println("cnt = " + count);
            if (count - cnt == 4) {
                result++;
            }
        }

        System.out.println(result);
    }
}
