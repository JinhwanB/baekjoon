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

// 최소 스패닝 트리
public class N1197 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); // 정점의 개수
        int e = Integer.parseInt(st.nextToken()); // 간선의 개수
        List<Edge> graph = new ArrayList<>();
        parent = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Edge(a, b, c));
            graph.add(new Edge(b, a, c));
        }

        br.close();

        graph.sort(Comparator.comparingInt(x -> x.c));

        long cost = 0;
        for (Edge edge : graph) {
            if (find(edge.s) == find(edge.e)) {
                continue;
            }

            union(edge.s, edge.e);
            cost += edge.c;
        }

        bw.write(cost + "");
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

    static class Edge {

        int s, e, c;

        public Edge(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }
}
