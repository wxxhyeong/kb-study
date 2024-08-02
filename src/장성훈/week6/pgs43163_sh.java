package 장성훈.week6;

public class pgs43163_sh {
    public static void main(String[] args) {
        int ans = solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(ans);
    }

    public static boolean isOneLetterDifferent(String w1, String w2) {
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int answer = DFS(target, words, visited, begin, 0, 51);
        return answer > 50 ? 0 : answer;
    }

    public static int DFS(String target, String[] words, boolean[] visited, String curr, int cnt, int answer) {
        if (curr.equals(target)) {
            return cnt;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isOneLetterDifferent(curr, words[i])) {
                visited[i] = true;
                answer = Math.min(answer, DFS(target, words, visited, words[i], cnt + 1, answer));
                visited[i] = false;
            }
        }
        return answer;
    }
}
