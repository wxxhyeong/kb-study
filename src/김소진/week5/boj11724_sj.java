import java.util.*;

public class boj11724_sj{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        n, m 값을 입력받음
        int n = sc.nextInt(); // 정점의 수
        int m = sc.nextInt(); // 간선의 수

//        그래프를 인접 리스트로 표현하기 위해 ArrayList 초기화
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

//        각 정점에 대해 인점 리스트를 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

//        방문 여부를 확인할 배열 초기화
        boolean[] visited = new boolean[n+1];
//        DFS를 수행하기 위한 스택 초기화
        Stack<Integer> stack = new Stack<>();
//        연결 요소의 수를 셀 변수 초기화
        int count = 0;

//        각각의 노드 순회
        for(int i =1 ; i< visited.length; i++ ){

            if(!visited[i]){
                stack.push(i);
                visited[i] = true;

                while (!stack.isEmpty()){
                    ArrayList<Integer> cur = graph.get(stack.pop());

                    for(int j = 0; j <cur.size(); j++){
                        if(!visited[cur.get(j)]){
                            stack.push(cur.get(j));
                            visited[cur.get(j)] = true;
                        }
                    }
                }
                count++;
            }
        }
        System.out.println(count);
    }
}