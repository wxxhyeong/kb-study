package 김소진.week7;

// 물통의 용량(int)
// BFS 탐색

import java.util.*;

public class boj2252_sj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 각 물통의 용량 입력
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        // 방문 여부를 체크하기 위한 배열
        boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];

        // 가능한 물의 양을 저장할 집합
        Set<Integer> results = new HashSet<>();

        // 초기 상태: (0, 0, C)
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, C});
        visited[0][0][C] = true;

        while (!queue.isEmpty()) {
            // 현재 상태를 큐에서 꺼냄
            int[] state = queue.poll();
            int a = state[0]; // 물통 A의 물 양
            int b = state[1]; // 물통 B의 물 양
            int c = state[2]; // 물통 C의 물 양

            // 물통 C에 담겨있는 물의 양을 결과에 추가
            results.add(c);

            // 가능한 모든 물의 이동을 시뮬레이션
            // 물통 A에서 B로 물을 옮기는 경우
            if (a > 0 && b < B) {
                int transfer = Math.min(a, B - b);
                if (!visited[a - transfer][b + transfer][c]) {
                    visited[a - transfer][b + transfer][c] = true;
                    queue.add(new int[] {a - transfer, b + transfer, c});
                }
            }
            // 물통 A에서 C로 물을 옮기는 경우
            if (a > 0 && c < C) {
                int transfer = Math.min(a, C - c);
                if (!visited[a - transfer][b][c + transfer]) {
                    visited[a - transfer][b][c + transfer] = true;
                    queue.add(new int[] {a - transfer, b, c + transfer});
                }
            }
            // 물통 B에서 A로 물을 옮기는 경우
            if (b > 0 && a < A) {
                int transfer = Math.min(b, A - a);
                if (!visited[a + transfer][b - transfer][c]) {
                    visited[a + transfer][b - transfer][c] = true;
                    queue.add(new int[] {a + transfer, b - transfer, c});
                }
            }
            // 물통 B에서 C로 물을 옮기는 경우
            if (b > 0 && c < C) {
                int transfer = Math.min(b, C - c);
                if (!visited[a][b - transfer][c + transfer]) {
                    visited[a][b - transfer][c + transfer] = true;
                    queue.add(new int[] {a, b - transfer, c + transfer});
                }
            }
            // 물통 C에서 A로 물을 옮기는 경우
            if (c > 0 && a < A) {
                int transfer = Math.min(c, A - a);
                if (!visited[a + transfer][b][c - transfer]) {
                    visited[a + transfer][b][c - transfer] = true;
                    queue.add(new int[] {a + transfer, b, c - transfer});
                }
            }
            // 물통 C에서 B로 물을 옮기는 경우
            if (c > 0 && b < B) {
                int transfer = Math.min(c, B - b);
                if (!visited[a][b + transfer][c - transfer]) {
                    visited[a][b + transfer][c - transfer] = true;
                    queue.add(new int[] {a, b + transfer, c - transfer});
                }
            }
        }

        // 결과를 정렬하여 출력
        List<Integer> sortedResults = new ArrayList<>(results);
        Collections.sort(sortedResults);
        for (int res : sortedResults) {
            System.out.print(res + " ");
        }
    }
}
