package 박희범.week2;

public class pgs42883_hb {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length(); i++){
            int top = sb.length() - 1;

            while(top >= 0 && k > 0 && sb.charAt(top) < number.charAt(i)){
                sb.deleteCharAt(top--);
                k--;
            }
            sb.append(number.charAt(i));
        }
        while(k > 0){
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        return sb.toString();
    }
}
