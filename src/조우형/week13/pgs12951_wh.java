package 조우형.week13;

import java.util.Locale;

public class pgs12951_wh {
    public static void main(String[] args) {


        System.out.println(solution("3people  unFollowed   me"));
    }

    static public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean wasSpace = true;
        s = s.toLowerCase();


        for (int i = 0; i < s.length(); i++) {

            if (wasSpace && s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                sb.append((char)(s.charAt(i)-('a'-'A')));
                wasSpace = false;
                continue;
            }
            else if (s.charAt(i)==' '){
                wasSpace = true;
            }
            else {
                wasSpace = false;
            }

            sb.append(s.charAt(i));

        }
        return sb.toString();
    }
}
