package 김민지.week1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedReader;


public class boj1931_mj {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(tmp[0]);
            meetings[i][1] = Integer.parseInt(tmp[1]);
        }

        Arrays.sort(meetings, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				
				return o1[1] - o2[1];
			}
		});

        int cnt = 0, end = 0;
        for (int i = 0; i < N; i++) {
            if (end <= meetings[i][0]) {
                end = meetings[i][1];
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
