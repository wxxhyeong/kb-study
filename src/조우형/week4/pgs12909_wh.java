package 조우형.week4;

public class pgs12909_wh {

    boolean solution(String s) {

        char[] arr = s.toCharArray();

        int state = 0; // 괄호가 열리면 1, 닫히면 -1을 더해줌. state가 0이면 true

        for (int i = 0; i < arr.length; i++) {

            switch (arr[i]) {
                case '(':
                    state++;
                    break;
                case ')':
                    state--;
                    break;
            }

            if (state < 0) {
                return false;
            }
        }

        if (state > 0) {
            return false;
        }

        return true;
    }
}

//boolean solution(String s) {
//    Stack<Character> stack = new Stack<>();
//    for (int i = 0; i < s.length(); i++) {
//        if (s.charAt(i) == '(') {
//            stack.push('(');
//        } else if (s.charAt(i) == ')') {
//            if (stack.isEmpty()) {
//                return false;
//            }
//            stack.pop();
//        }
//    }
//    return stack.isEmpty();
//}
