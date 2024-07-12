class prg43165_sj {
        class Solution {
            int[] numbers; // 주어진 숫자 배열
            int target; // 목표 숫자
            int answer; // 타겟 숫자를 만들 수 있는 방법의 수

            // 깊이 우선 탐색(DFS) 메서드
            private void dfs(int index, int sum) {
                // 배열의 끝까지 탐색한 경우
                if (index == numbers.length) {
                    // 합이 타겟과 같으면 경우의 수 증가
                    if (sum == target) answer++;
                    return;
                }

                // 현재 숫자를 더하는 경우
                dfs(index + 1, sum + numbers[index]);
                // 현재 숫자를 빼는 경우
                dfs(index + 1, sum - numbers[index]);
            }

            // 주어진 숫자 배열과 목표 숫자를 받아서 경우의 수를 계산하는 메서드
            public int solution(int[] numbers, int target) {
                this.numbers = numbers; // 숫자 배열 초기화
                this.target = target; // 목표 숫자 초기화

                dfs(0, 0); // DFS 탐색 시작
                return answer; // 경우의 수 반환
            }
        }
}