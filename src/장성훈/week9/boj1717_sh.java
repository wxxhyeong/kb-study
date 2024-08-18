package 장성훈.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1717_sh {
    public static int[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nodes = new int[n+1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            }

            if (op == 1) {
                if (find(a) != find(b)) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
        System.out.println(Arrays.toString(nodes));
    }

    public static int find(int target) {
        if (target == nodes[target]) {
            return target;
        }
        return nodes[target] = find(nodes[target]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            nodes[Math.max(a,b)] = Math.min(a,b);
        }
    }
}
