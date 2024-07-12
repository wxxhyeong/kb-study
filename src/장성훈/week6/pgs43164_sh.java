package 장성훈.week6;

import java.util.*;

class pgs43164_sh {
    static boolean[] visited;
    static ArrayList<String> route;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        route = new ArrayList<>();

        DFS("ICN", "ICN", tickets, 0);

        Collections.sort(route);
        answer = route.get(0).split(" ");
        return answer;
    }

    public void DFS(String departure, String arrival, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            route.add(arrival);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (departure.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                DFS(tickets[i][1], arrival + " " + tickets[i][1], tickets, cnt + 1);
                visited[i] = false;
            }
        }
    }
}