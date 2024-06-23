package 장성훈.week4;

public class pgs42885_sh {
    public int solution(int[] people, int limit) {
        java.util.Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int answer = 0;

        while (left <= right) {
            int boat = people[right];
            right--;

            if (left > right) {
                answer++;
                break;
            }

            if (boat + people[right] <= limit) {
                right--;
            } else if (boat + people[left] <= limit) {
                left++;
            }

            answer++;
        }

        return answer;
    }
}
