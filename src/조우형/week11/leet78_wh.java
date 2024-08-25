package 조우형.week11;

import java.util.*;
class leet78_wh {
    int len;
    boolean[] visited;
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {

        len = nums.length;
        visited = new boolean[len];
        answer = new ArrayList<>();

        backtrack(0, new ArrayList<>(), nums);

        return answer;

    }

    public void backtrack(int start, List<Integer> cur, int[] nums) {
        if (start == len+1) return;
        answer.add(new ArrayList<>(cur));

        for (int i = start; i < len; i++) {
            cur.add(nums[i]);
            backtrack(i+1, cur, nums);
            cur.remove(cur.size()-1);
        }
    }
}
