package 박희범.week9;

import java.io.*;
import java.util.StringTokenizer;

public class boj1717_hb {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n + 1];
        for(int i = 1; i <= n; i++)
            parent[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(oper == 0){
                union(a, b, parent);
            }else {
                bw.write(find(a, parent) == find(b, parent) ? "YES\n" : "NO\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
    static void union(int a, int b, int[] parent) {
        a = find(a, parent);
        b = find(b, parent);

        if(a == b)
            return;
        if(a < b){
            parent[a] = b;
        }else{
            parent[b] = a;
        }
    }

    static int find(int x, int[] parent){
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x], parent);
    }
}
