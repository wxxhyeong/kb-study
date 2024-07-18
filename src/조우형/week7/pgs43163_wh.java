package 조우형.week7;

public class pgs43163_wh {

    static String[] words;
    static boolean[] visited;
    static int answer;
    static String target;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        this.words = words;
        this.target = target;
        visited = new boolean[words.length];
        Integer.Max
        dfs(0, begin);


        return answer;
    }

    static void dfs(int cnt, String word) {

        if (word.equals(target)) {
            answer = answer < cnt ? answer : cnt;
            return;
        }


        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && getDiff(word, words[i])) {
                visited[i] = true;
                dfs(cnt+1, words[i]);
                visited[i] = false;
            }
        }
    }

    // 알파벳이 하나만 다른 언어 찾는 함수
    static boolean getDiff(String str1, String str2) {

        int diff = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)){
                diff++;
            }
        }

        return diff == 1;
    }
}
