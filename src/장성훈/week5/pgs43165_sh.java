package 장성훈.week5;

import java.util.Map;
import java.util.HashMap;

public class pgs43165_sh {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(nums, target));
    }

    public static int solution(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // key를 만들 수 있는 경우의 수

        for (int num : numbers) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (Integer key : map.keySet()) {
                temp.put(key+num, temp.getOrDefault(key+num, 0) + map.get(key));
                temp.put(key-num, temp.getOrDefault(key-num, 0) + map.get(key));
            }
            map = temp; // 경우의 수 목록을 갱신
        }
        return map.get(target);
    }
}
