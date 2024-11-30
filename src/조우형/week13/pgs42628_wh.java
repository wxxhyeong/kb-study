package 조우형.week13;

import java.util.*;

class pgs42628_wh {
    public int[] solution(String[] operations) {
        int[] answer = new int[]{0,0};

        Queue<Integer> pqdec = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> pqinc = new PriorityQueue<>();

        for (String o: operations) {

            if (o.charAt(0) == 'I') {
                pqdec.add(Integer.parseInt(o.substring(2)));
                pqinc.add(Integer.parseInt(o.substring(2)));
            }
            else {
                if (pqdec.isEmpty()) continue;
                if (o.charAt(2) == '-') {
                    int del = pqinc.poll();
                    pqdec.remove(del);
                }
                else {
                    int del = pqdec.poll();
                    pqinc.remove(del);
                }
            }
        }

        if (pqinc.isEmpty()) return answer;


        return answer = new int[]{pqdec.poll(), pqinc.poll()};
    }
}