package 조우형.week5;

public class pgs43165_wh {

    static String[] plusMinus = {"+","-"};
    boolean[] visited;
    static int[] numbers;
    static int target;
    static int answer;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        answer = 0;

        visited = new boolean[numbers.length];

        for(int i = 0; i < 2; i++) {
            dfs(i, 0, 0);
        }

        return answer;
    }

    static void dfs(int sym, int idx, int sum) {

        if (idx == numbers.length) {
            return;
        }

        sum += Integer.parseInt(plusMinus[sym] + numbers[idx]);

        if (sum == target && idx == numbers.length-1) {
            answer++;
        }

        for (int i = 0; i < plusMinus.length; i++) {
            dfs(i, idx+1, sum);
        }
    }
}
