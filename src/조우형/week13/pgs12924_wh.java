package 조우형.week13;

public class pgs12924_wh {

    public int solution1(int n) {
        int answer = 0;

        int sum = 0;
        int fir = 1;
        int sec = 1;
        while (fir <= n) {
            if (sum < n) {
                sum += sec;
                sec++;
            }
            else {
                if (sum == n) {
                    answer++;
                }
                sum -= fir;
                fir++;
            }

        }

        return answer;
    }
}
