package 장성훈.week6;

public class pgs92343_sh {
    static int answer = 0;
    static boolean[] visited;

    public static void main(String[] args) {

        int ans = solution(new int[] {0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1}, {1,2}, {1,4}, {0,8}, {8,7}, {9,10}, {9,11}, {4,3}, {6,5}, {4,6}, {8,9}});

        System.out.println(ans);
    }

    public static int solution(int[] info, int[][] edges) {
        answer = 0;
        visited = new boolean[info.length];

        visited[0] = true;
        dfs(1, 0, info, edges);

        return answer;
    }

    public static void dfs(int sheep, int wolf, int[] info, int[][] edges) {
        if (sheep <= wolf)
            return;

        answer = Math.max(answer, sheep);

        for (int[] edge: edges) {
            int parent = edge[0];
            int child = edge[1];

            if (visited[parent] && !visited[child]) {
                visited[child] = true;
                if (info[child] == 0) {
                    dfs(sheep+1, wolf, info, edges);
                } else {
                    dfs(sheep, wolf+1, info, edges);
                }
                visited[child] = false;
            }
        }
    }
}
