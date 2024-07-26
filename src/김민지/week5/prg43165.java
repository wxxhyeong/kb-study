package 김민지.week5;

public class prg43165 {
    int cnt = 0;
    int target;

    public int solution(int[] numbers, int t) {
        target = t;
        dfs(numbers, 0, 0);
        return cnt;
    }

    public void dfs(int[] numbers, int depth, int result) {
        if (depth == numbers.length) {
            if (result == target) {
                cnt++;
            }
            return;
        }

        int tmp1 = result - numbers[depth];
        int tmp2 = result + numbers[depth];

        dfs(numbers, depth+1, tmp1);
        dfs(numbers, depth+1, tmp2);
    }
}
