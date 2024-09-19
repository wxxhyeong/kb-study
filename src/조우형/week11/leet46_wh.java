package 조우형.week11;

import java.util.ArrayList;
import java.util.List;

public class leet46_wh {

    List<List<Integer>> answer;
    boolean[] visited;
    int len;

    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        visited = new boolean[len];
        answer = new ArrayList<>();
        back(0, new ArrayList<>(), nums);

        return answer;
    }

    public void back(int cur, List<Integer> al, int[] nums) {

        if (cur == len) {
            answer.add(new ArrayList<>(al));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                al.add(nums[i]);
                visited[i] = true;
                back(cur + 1, al, nums);
                al.remove(al.size() -1);
                visited[i] = false;
            }
        }
    }

}
