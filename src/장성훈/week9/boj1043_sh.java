package 장성훈.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj1043_sh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> blackList = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int blackCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < blackCount; i++) {
            blackList.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<HashSet<Integer>> partyList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());

            HashSet<Integer> party = new HashSet<>();

            for (int j = 0; j < people; j++) {
                int p = Integer.parseInt(st.nextToken());
                party.add(p);
            }
            partyList.add(party);
        }

        for (int i = 0; i < M; i++) {
            for (HashSet<Integer> party : partyList) {
                HashSet<Integer> temp = new HashSet<>(party);
                temp.removeAll(blackList);
                if (temp.size() != party.size()) {
                    blackList.addAll(party);
                }
            }
        }

        int answer = 0;
        for (HashSet<Integer> party : partyList) {
            HashSet<Integer> temp = new HashSet<>(party);
            temp.removeAll(blackList);
            if (temp.size() == party.size()) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}


/*
6 5
1 6
2 4 5
2 1 2
2 2 3
2 3 4
2 5 6

10 3
1 1
2 1 2
2 2 3
2 3 4

10 3
1 1
2 4 3
2 3 2
2 2 1
 */