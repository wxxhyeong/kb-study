package 조우형.week13;

public class pgs12911_wh {

    public int solution(int n) {
        //int answer = 0;

        int nOne = cntOne(binaryChange(n));

        int next = n+1;
        while (cntOne(binaryChange(next)) != nOne) {
            next++;
        }

        return next;
    }

    public String binaryChange(int n) {
        StringBuilder sb = new StringBuilder();
        while (n/2 != 0) {
            if (n%2 == 0) {
                sb.insert(0, 0);
            }
            else {
                sb.insert(0, 1);
            }

            n /= 2;
        }

        sb.insert(0, 1);
        return sb.toString();
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
}
