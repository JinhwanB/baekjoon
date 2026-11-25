package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 여행 가자
public class N1976 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 도시의 수
        int m = Integer.parseInt(br.readLine()); // 여행계획에 속한 도시들의 수

        if (m == 1) {
            bw.write("YES");
            br.close();
            bw.flush();
            bw.close();

            return;
        }

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                int connect = Integer.parseInt(st.nextToken());

                if (connect == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int root = find(first);

        for (int i = 0; i < m - 1; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (find(node) != root) {
                bw.write("NO");
                br.close();
                bw.flush();
                bw.close();
                return;
            }
        }

        br.close();

        bw.write("YES");
        bw.flush();
        bw.close();
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (rootA < rootB) {
                parent[rootB] = rootA;
                return;
            }
        }

        parent[rootA] = rootB;
    }
}
