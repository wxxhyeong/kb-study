package 장성훈.week8;

//public class pgs143666_sh {
//}

import java.util.*;
class pgs143666_sh {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        Boolean[] visited = new Boolean[n+1];
        Arrays.fill(visited, false);

        for (int[] v : edge) {
            map.get(v[0]).add(v[1]);
            map.get(v[1]).add(v[0]);
        }

        int[] arr = new int[n+1];

        return bfs(1, visited, map);
    }

    public int bfs(int start,  Boolean[] visited, HashMap<Integer, ArrayList<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();

        int answer = 0;
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int now = queue.poll();
                for (int next : map.get(now)) {
                    if (!visited[now]) {
                        queue.offer(now);
                        visited[now] = true;
                    }
                }
            }
            if (!queue.isEmpty()) {
                answer = queue.size();
            }
        }


        return answer;
    }
}