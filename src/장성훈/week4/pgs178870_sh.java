package 장성훈.week4;

public class pgs178870_sh {
    public static int[] solution(int[] sequence, int k) {
        int[] arr = new int[sequence.length + 1];
        for (int i = 0; i < sequence.length; i++) {
            arr[i + 1] = sequence[i] + arr[i];
        }

        int L = 0, R = -1;
        int tL = 0, tR = 1;
        while (tL < arr.length && tR < arr.length) {
            if (arr[tR] - arr[tL] < k) {
                tR++;
            } else if (arr[tR] - arr[tL] > k) {
                tL++;
            } else {
                if (R < 0) {
                    R = tR;
                    L = tL;
                }

                if (tR - tL < R - L) {
                    R = tR;
                    L = tL;
                }
                tR++;
                tL++;
            }
        }
        return new int[]{L, R - 1};
    }
}
