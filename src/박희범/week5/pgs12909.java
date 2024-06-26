package 박희범.week5;

import java.util.*;

class pgs12909 {
    boolean solution(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                sb.append('(');
            else{
                if(sb.length() == 0)
                    return false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.length() == 0;
    }
}