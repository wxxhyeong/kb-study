package 김소진.week7;

// DFS로 모든 컴퓨터 각각 연결된 것을 세야한다
// count 값을 리턴해서, 내림차순으로 출력한다
// 매개변수: 컴퓨터의 개수 N, 신뢰관계 개수 M

import java.util.*;

public class boj1325_sj {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < m; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph.get(b).add(a);
            }

            int[] result = new int[n+1];

            for(int i = 1; i <= n; i++){
                boolean[] visited = new boolean[n + 1];
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                int count = 0;

                while(!queue.isEmpty()){
                    int current = queue.poll();
                    count++;
                    for(int neighbor: graph.get(current)){
                        if(!visited[neighbor]){
                            visited[neighbor] = true;
                            queue.add(neighbor);
                        }
                    }
                }
                result[i] = count;
            }

            int maxHack = Arrays.stream(result).max().getAsInt();
            for(int i = 1; i <= n; i++){
                if(result[i] == maxHack){
                    System.out.print(i + " ");
                }
            }
        }
    }
