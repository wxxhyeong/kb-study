package 박희범.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2343_hb {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int low = 0;
        int high = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high += arr[i];
        }
        int min = Integer.MAX_VALUE;
        while(low < high){
            int mid = low + (high - low) / 2;
            int sum = 0;
            int cnt = 0;
            int localMax = 0;
            for (int i = 0; i < N; i++) {
                if(sum + arr[i] <= mid) {
                    sum += arr[i];
                    if( i == N - 1){
                        cnt++;
                    }
                }else{
                    cnt++;
                    localMax = Math.max(localMax, sum);
                    sum = 0;
                    sum += arr[i];
                }
                localMax = Math.max(localMax, sum);
            }
            if(cnt == M){
                min = Math.min(min, localMax);
            }
            System.out.println(cnt +", "+localMax+", " + mid);

            if(cnt < M){
                high = mid;
            }else{
                low = mid + 1;
            }

        }
        System.out.println(min);
    }
}
