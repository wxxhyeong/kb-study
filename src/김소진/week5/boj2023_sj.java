import java.util.*;
import java.io.*;

public class boj2023_sj{
//    입력할 값 n, 소수 생성 길이
    static int n;
//    결과를 저장할 객체 생성
    static StringBuilder sb = new StringBuilder();

//    isPrime: 소수 판별 메서드
    static boolean isPrime(int x){
//        1은 소수가 아님
        if(x == 1)return false;
//        2부터 검사 시작
        for(int i=2; i<=Math.sqrt(x); i++)
            if(x % i == 0)
                return false; // 나머지가 0이면 소수가 아님
                return true;
    }

//    DFS: Depth-First Search, 깊이 우선 탐색
    static void DFS(String str, int len){

        if(len == n)
            sb.append(str).append("\n");
        else{
            for(int i=1; i <= 9; i++){
                String s = str + i;
//                소수인지 확인
                if(isPrime(Integer.parseInt(s.toString())))
                    DFS(s, len + 1);
            }
        }
    }

//    실행 함수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        DFS("", 0);
        System.out.println(sb.toString());
    }
}
