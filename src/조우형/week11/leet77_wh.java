package 조우형.week11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class leet77_wh {

    List<List<Integer>> answer;
    int k;
    int n;

    public List<List<Integer>> combine(int n, int k) {

        // 1부터 n까지 k개의 원소를 가지는 부분집합 구하기.
        answer = new ArrayList<>();
        this.k = k;
        this.n = n;
        backtrack(1, new ArrayList<>());

        return answer;
    }

    public void backtrack(int start, List<Integer> cur) {

        if (cur.size() == k) {
            answer.add(new ArrayList<>(cur));
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            backtrack(i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
