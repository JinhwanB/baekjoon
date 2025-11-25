package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 특정한 최단 경로
public class N1504 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, e;
    static List<List<int[]>> maps;
    static int[] dist;
    static int res1, res2 = 0;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        e = Integer.parseInt(st.nextToken()); // 간선의 개수

        maps = new ArrayList<>();
        dist = new int[n + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i <= n; i++) {
            maps.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 정점 a
            int b = Integer.parseInt(st.nextToken()); // 정점 b
            int c = Integer.parseInt(st.nextToken()); // a에서 b까지의 거리

            maps.get(a).add(new int[]{b, c});
            maps.get(b).add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()); // 반드시 지나야하는 정점 v1
        int v2 = Integer.parseInt(st.nextToken()); // 반드시 지나야하는 정점 v2
        br.close();

        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, n);

        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, n);

        int res = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        bw.write(res + "");
        bw.flush();
        bw.close();
    }

    private static int dijkstra(int s, int e) {
        Arrays.fill(dist, INF);

        boolean[] checked = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{s, 0});
        dist[s] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int end = poll[0];

            if (!checked[end]) {
                checked[end] = true;

                for (int[] node : maps.get(end)) {
                    int newEnd = node[0];
                    int newDistance = node[1];

                    if (dist[newEnd] > dist[end] + newDistance) {
                        dist[newEnd] = dist[end] + newDistance;
                        pq.offer(new int[]{newEnd, dist[newEnd]});
                    }
                }
            }
        }

        return dist[e];
    }
}
