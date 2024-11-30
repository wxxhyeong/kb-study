package 조우형.week13;

public class pgs12945_wh {

    public static void main(String[] args) {
        System.out.println(solution(46));
    }

    static public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-2]%1234567 + dp[i-1]%1234567;
            //dp[i] = dp[i-2] + dp[i-1];
        }

        //System.out.println(dp[n]);


        return dp[n]%1234567;
    }
}
