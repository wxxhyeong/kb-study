package 장성훈.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class pgs43164_sh {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[][] tickets2 = {{"ICN", "AAA"}, {"AAA", "ICN"}, {"ICN", "CCC"}, {"CCC", "ICN"}, {"ICN", "DDD"}, {"DDD", "AAA"}};
        String[][] tickets3 = {{"ICN", "D"}, {"D", "ICN"}, {"ICN", "B"}};
        solution(tickets3);
    }

    public static String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        HashMap<String, HashMap<String, Integer>> routes = new HashMap<>();

        for (String[] ticket : tickets) {
            routes.putIfAbsent(ticket[0], new HashMap<>());
            HashMap<String, Integer> prevRoutes = routes.get(ticket[0]);

            prevRoutes.put(ticket[1], prevRoutes.getOrDefault(ticket[1], 0) + 1);
        }

        // 출력하기
        for (HashMap.Entry<String, HashMap<String, Integer>> entry : routes.entrySet()) {
            String route = entry.getKey();
            HashMap<String, Integer> prevRoutes = entry.getValue();
            System.out.println(route);
            for (String ticket : prevRoutes.keySet()) {
                System.out.println(ticket + ":" + prevRoutes.get(ticket));
            }
            System.out.println();
        }

        String start = "ICN";
        ArrayList<String> list = new ArrayList<>();
        list.add(start);
        System.out.println();

         System.out.println(dfs("ICN", routes, list, tickets.length + 1));
//        String[] answer = dfs("ICN", routes, list, tickets.length + 1).toArray(new String[0]);

        return null;//dfs(start, routes, list, tickets.length + 1).toArray(new String[0]);
    }

    public static ArrayList<String> dfs(String start, HashMap<String, HashMap<String, Integer>> routes, ArrayList<String> path, int target) {
        if (path.size() == target) {
            return path;
        }

        if (routes.containsKey(start)) {
            HashMap<String, Integer> route = routes.get(start);
            for (String end : route.keySet()) {
                if (route.get(end) == 0) {
                    continue;
                }

                route.put(end, route.get(end) - 1);
                ArrayList<String> newPath = new ArrayList<>(path);
                newPath.add(end);
                ArrayList<String> temp = dfs(end, routes, newPath, target);
                if (temp == null || temp.isEmpty()) {
                    route.put(end, route.get(end) + 1);
                } else {
                    return temp;
                }
            }
        }
        return null;
    }
}
