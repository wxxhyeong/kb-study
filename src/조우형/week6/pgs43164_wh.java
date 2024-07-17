package 조우형.week6;

import java.util.*;
public class pgs43164_wh {

    public static void main(String[] args) {
        //solution(new String[][]{new String[]{"ICN", "JFK"}, new String[]{"HND", "IAD"}, new String[]{"JFK", "HND"}});
        solution(new String[][]{new String[]{"ICN", "SFO"}, new String[]{"ICN", "ATL"}, new String[]{"SFO", "ATL"}, new String[]{"ATL", "ICN"}, new String[]{"ATL","SFO"}});
    }

    static public String[] solution(String[][] tickets) {
        HashMap<String, ArrayList<String>> hashmap = new HashMap<>();

        for (String[] ticket : tickets) {
            if (!hashmap.containsKey(ticket[0])){
                hashmap.put(ticket[0], new ArrayList<>());
            }
            hashmap.get(ticket[0]).add(ticket[1]);
        }

        System.out.println("hashmap.toString() = " + hashmap.toString());
        int size = hashmap.size();
        HashMap<String, Boolean> visited = new HashMap<>();
        String[] answer = new String[size];

        for (String s : hashmap.keySet()) {
            visited.put(s, false);
        }

        for (String s : hashmap.keySet()) {
            Collections.sort(hashmap.get(s));
        }

        Deque<String> deque = new ArrayDeque<>();
        deque.add("ICN");
        visited.replace("ICN", true);


        while (!deque.isEmpty()) {
            String start = deque.pollFirst();

            for (String s : hashmap.get(start)) {
                if (!visited.get(s)) {

                }
            }

        }



        return answer;
    }
}
