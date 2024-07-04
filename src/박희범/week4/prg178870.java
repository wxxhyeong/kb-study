package 박희범.week4;

public class prg178870 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        answer = new int[2];
        int s = 0;
        int e = 0;
        int minL = sequence.length;
        int sum = sequence[s];
        while(s < sequence.length){
            if(sum == k){
                if(minL > e - s - 1){
                    minL = e - s - 1;
                    answer[0] = s;
                    answer[1] = e - 1;
                }
            }
            if(sum > k || e == sequence.length){
                sum -= sequence[s];
                s++;
            }else{
                if(e < sequence.length){
                    sum += sequence[e];
                }
                e++;
            }
        }
        return answer;
    }
}
