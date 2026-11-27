package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 행성 연결
public class N16398 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 행성의 수
        List<Plow> plows = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                int c = Integer.parseInt(st.nextToken());
                plows.add(new Plow(i, j, c));
            }
        }

        br.close();

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        plows.sort(Comparator.comparingInt(x -> x.c));

        long answer = 0;

        if (!plows.isEmpty()) {
            for (Plow plow : plows) {
                if (plow.s == plow.e || find(plow.s) == find(plow.e)) {
                    continue;
                }

                answer += plow.c;
                union(plow.s, plow.e);
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                parent[b] = a;

                return;
            }

            parent[a] = b;
        }
    }

    private static class Plow {

        int s, e, c;

        public Plow(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }
}
