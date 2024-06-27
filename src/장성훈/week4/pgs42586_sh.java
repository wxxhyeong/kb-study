package 장성훈.week4;

import java.util.ArrayList;
import java.util.List;

public class pgs42586_sh {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int progress = 0;   // 현재 진행중인 작업
        while (progress < progresses.length) {
            // 현재 작업이 완료되기위해 필요한 days를 구하고, 남은 작업들의 진행도를 days 만큼 업데이트
            int remainingWork = 100 - progresses[progress];
            int days = (remainingWork + speeds[progress] - 1) / speeds[progress];
            for (int i = progress; i < progresses.length; i++) {
                progresses[i] += days * speeds[i];
            }

            // 완료된 작업의 개수를 앞에서부터 계산
            int finished = 0;
            for (; progress < progresses.length; progress++) {
                // 작업이 덜끝났다면 추가 작업일이 필요하므로 종료
                if (progresses[progress] < 100) {
                    break;
                }
                finished++;
            }
            answer.add(finished);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
