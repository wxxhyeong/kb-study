package 조우형.week8;
import java.util.*;
public class pgs92343_wh {
    static ArrayList<Integer>[] arrayList;

    class Solution {
        public int solution(int[] info, int[][] edges) {
            int answer = 0;
            boolean[] visited = new boolean[info.length];

            arrayList = new ArrayList[info.length];
            for (int i = 0; i < arrayList.length; i++) {
                arrayList[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                arrayList[edge[0]].add(edge[1]);
            }


            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{0, 1, 0}); // [노드, 양 수, 늑대 수]
            visited[0] = true;


            while (!deque.isEmpty()) {

                int[] node = deque.pollFirst();
                int cur = node[0];
                int sheep = node[1];
                int wolf = node[2];

                for (int next : arrayList[cur]) {

                    if (info[next] == 1) {
                        if (!visited[next]) {
                            if (sheep > wolf + 1) {
                                deque.add(new int[]{next, sheep, wolf + 1});
                            }
                        }

                    }
                }
            }

            return answer;
        }


        void dfs(int cur, int sheep, int wolf, int[] info) {


            for (int next : arrayList[cur]) {
                if (info[next] == 1) {
                    
                    if (sheep > wolf + 1) {
                        dfs(next, sheep, wolf, info);
                    }
                }
            }
        }
    }
}
