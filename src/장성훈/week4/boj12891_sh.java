package 장성훈.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12891_sh {
    enum Nucleotide {
        A(0), C(1), G(2), T(3);
        private final int value;

        Nucleotide(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        int[] requirement = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < requirement.length; i++) {
            requirement[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[] check = new int[4];
        int i = 0;
        for (; i < p; i++) {
            char ch = str.charAt(i);
            int index = Nucleotide.valueOf(String.valueOf(ch)).getValue();
            check[index]++;
        }
        if (compareArray(requirement, check)) {
            answer++;
        }

        for (; i < s; i++) {
            char prev = str.charAt(i - p);
            int prevIdx = Nucleotide.valueOf(String.valueOf(prev)).getValue();
            check[prevIdx]--;

            char now = str.charAt(i);
            int nowIdx = Nucleotide.valueOf(String.valueOf(now)).getValue();
            check[nowIdx]++;

            if (compareArray(requirement, check)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean compareArray(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) {
            if (a[i] > b[i]) {
                return false;
            }
        }
        return true;
    }
}
