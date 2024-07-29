import java.io.*;
import java.util.*;
//import java.io.BufferedReader;  // BufferedReader 클래스를 import
//import java.io.IOException;      // IOException 클래스를 import
//import java.io.InputStreamReader; // InputStreamReader 클래스를 import
//import java.util.StringTokenizer; // StringTokenizer 클래스를 import
//import java.util.Queue;           // Queue 인터페이스를 import
//import java.util.LinkedList;      // LinkedList 클래스를 import

public class Main {

    static int[][] map;         // 미로의 지도를 저장할 배열
    static int n, m;            // 미로의 세로 길이와 가로 길이
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐 ... BFS 탐색 노드를 순서대로 관리하는데 유용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // import한 클래스, 입력 스트림에서 문자를 효율적으로 읽기 위해 버퍼링을 사용
        StringTokenizer st = new StringTokenizer(br.readLine()); // import한 클래스, 문자열을 구분자로 나누어 토큰으로 분리
        n = Integer.parseInt(st.nextToken()); // 미로의 세로 길이 입력 / parseInt( ): 문자열을 정수로 변환하는 메서드
        m = Integer.parseInt(st.nextToken()); // 미로의 가로 길이 입력

        map = new int[n][m]; // 미로 지도 배열 초기화

        // 미로 입력 처리
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0'; // 문자를 숫자로 변환하여 미로 정보 저장
            }
        }

        bfs(0, 0); // 시작점 (0, 0)에서 BFS 탐색 시작
        System.out.println(map[n - 1][m - 1]); // 우하단 도착 지점의 최단 거리 출력

        br.close();
    }

    // 너비 우선 탐색(BFS) 메서드
    static void bfs(int x, int y) {
        queue.offer(new int[]{x, y}); // 시작점을 큐에 추가

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 현재 위치를 꺼냄
            int cx = current[0]; // 현재 위치의 x 좌표
            int cy = current[1]; // 현재 위치의 y 좌표

            // 현재 위치에서 상하좌우 이동을 검사
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i]; // 다음 이동할 x 좌표
                int ny = cy + dy[i]; // 다음 이동할 y 좌표

                // 다음 이동할 위치가 미로의 범위 안에 있고, 이동할 수 있는 경우 (통로)
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1) { // 방문하지 않은 통로인 경우
                        queue.offer(new int[]{nx, ny}); // 큐에 다음 위치 추가
                        map[nx][ny] = map[cx][cy] + 1; // 다음 위치의 이동 거리를 기록
                    }
                }
            }
        }
    }
}


//입력 처리:
//BufferedReader와 StringTokenizer를 사용하여 입력을 처리합니다.
//n과 m은 미로의 세로와 가로 길이를 나타냅니다.
//map 배열에는 미로의 각 위치 정보가 저장됩니다. '1'은 이동 가능한 곳(통로), '0'은 벽을 나타냅니다.

//BFS 함수 설명 (bfs 메서드):
//BFS(너비 우선 탐색)를 사용하여 최단 경로를 탐색합니다. 시작점은 항상 (0, 0)입니다.
//queue를 사용하여 탐색할 위치를 관리합니다. 처음에는 시작점을 queue에 넣어줍니다.
//각 위치에서 상하좌우로 이동 가능한 경우를 탐색하며, 이동할 수 있는 위치를 큐에 추가하고 이동 거리를 map 배열에 기록합니다.

//탐색 종료 및 결과 출력:
//BFS가 끝나면 map[n-1][m-1]에는 시작점에서 우측 하단까지의 최소 이동 거리가 저장됩니다.
//이 값을 출력하여 최소 이동 거리를 확인할 수 있습니다.

//주석 설명:
//큐 활용: queue를 사용하여 BFS를 구현합니다. BFS는 너비(층)를 우선으로 탐색하므로 queue에 넣은 순서대로 탐색합니다.
//이동 거리 기록: map 배열에는 각 위치까지의 최단 거리가 저장됩니다. BFS의 특성상 처음 도착한 경우가 최소 이동 거리입니다.
//범위 검사: nx와 ny가 미로의 범위 내에 있고, 이동할 수 있는 위치인지 확인합니다.
//문자를 숫자로 변환: line.charAt(j) - '0'을 통해 문자를 정수로 변환하여 미로의 각 위치 정보를 저장합니다.