import java.util.*;

// 필드 정의
class Solution {
//    항공권 사용 여부 기록 → 사용되었으면 'true' 표시
    static boolean[] visit;
//    가능한 경로들을 저장하는 리스트 (ArrayList 클래스 사용)
    static ArrayList<String> list;

//    메소드 선언
    public String[] solution(String[][] tickets) {
        // visit - 항공권 사용 여부를 나타내는 배열 초기화
//        visit 배열은 주어진 항공권의 수만큼의 크기를 갖음
//        tickets[i][0]은 i번째 항공권의 출발지, tickets[i][1]은 i번째 항공권의 도착지
        visit = new boolean[tickets.length];
        // list - 가능한 경로를 저장할 리스트 초기화
        list = new ArrayList<>();
        // 경로는 항상 'ICN'으로 시작
        String path = "ICN";

        // DFS 탐색 시작
        dfs(tickets, "ICN", path, 0);
        // 모든 경로가 담긴 리스트를 알파벳 순으로 정렬 (Collection 클래스 사용)
        Collections.sort(list);
        // 가장 첫 번째 경로를 반환 (알파벳 순으로 가장 앞서는 경로)
        return list.get(0).split(" ");
    }

    // DFS 탐색 메소드 선언
    static void dfs(String[][] tickets, String start, String path, int count) {
        // 모든 항공권을 사용한 경우, 현재 경로를 리스트에 추가
        if (count == tickets.length) {
            // 경로를 리스트에 추가
            list.add(path);
            return;
        }
        // 모든 항공권으로 순회
        for (int i = 0; i < tickets.length; i++) {
            // 현재 항공권을 사용하지 않았고 && 출발지가 일치하는 경우
            if (!visit[i] && tickets[i][0].equals(start)) {
                // 현재 항공권을 사용 상태로 변경
                visit[i] = true;
                // 다음 목적지로 DFS 탐색, 경로를 이어나감
                dfs(tickets, tickets[i][1], path + " " + tickets[i][1], count + 1);
                // 다른 경로를 탐색하기 위해 현재 항공권을 다시 미사용 상태로 변경
                visit[i] = false;
            }
        }
    }
}


// 깊이 우선 탐색(DFS)을 통해 모든 항공권 경로를 찾고, 그 중 알파벳 순서로 가장 빠른 경로 반환
// solution 메소드는 입력된 항공권 정보를 기반으로 경로를 찾아 반환
