package 조우형.week13;

public class pgs70129_wh {

    public int[] solution(String s) {
        int[] answer = new int[2];

        //이진 변환 횟수와, 제거된 0의 개수
        int delZero = 0;
        int changeCnt = 0;
        int one = 0;

        while (one != 1) {
            changeCnt++;
            one = cntOne(s); // 1의 개수 세기
            delZero += s.length() - one; // 0의 개수 추가

            s = binaryNum(one);
        }

        answer[0] = changeCnt;
        answer[1] = delZero;

        return answer;
    }


    public int cntOne(String s) {

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            }
        }

        return cnt;
    }

    public String binaryNum(int num) {
        StringBuilder sb = new StringBuilder();
        while (num/2 != 0) {
            sb.insert(0, num%2);
            num = num/2;
        }
        sb.insert(0, 1);

        return sb.toString();
    }
}
