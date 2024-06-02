package 김민지.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class boj1541_mj {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toString();
         
        List<Integer> numList = new ArrayList<>();
        String[] splitNums = str.split("-");

        for (int i = 0; i < splitNums.length; i++) {
            int sum = 0;
            String[] tmp = splitNums[i].split("\\+");
            for (int j = 0; j < tmp.length; j++) {
                sum += Integer.parseInt(tmp[j]);
            }
            numList.add(sum);
        }

        long result = numList.get(0);
        for (int i = 1; i < numList.size(); i++) {
            result -= numList.get(i);
        }
        System.out.print(result);
    }
}