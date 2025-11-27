package gold2;

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

// 미확인 도착지
public class N9370 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int T, n, m, t, s, g, h, a, b, d;
    static List<List<int[]>> map;
    static int[] dist;
    static boolean[] checked;
    static int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 교차로 수
            m = Integer.parseInt(st.nextToken()); // 도로 수
            t = Integer.parseInt(st.nextToken()); // 목적지 후보의 수

            map = new ArrayList<>();

            for (int j = 0; j <= n; j++) {
                map.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()); // 예술가들의 출발지
            g = Integer.parseInt(st.nextToken()); // 예술가들이 지나간 교차로
            h = Integer.parseInt(st.nextToken()); // 예술가들이 지나간 교차로

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken()); // 교차로 a
                b = Integer.parseInt(st.nextToken()); // 교차로 b
                d = Integer.parseInt(st.nextToken()); // 도로의 길이

                if ((a == g && b == h) || (a == h && b == g)) {
                    d = d * 2 - 1;
                    map.get(a).add(new int[]{b, d});
                    map.get(b).add(new int[]{a, d});
                    continue;
                }

                d = d * 2;
                map.get(a).add(new int[]{b, d});
                map.get(b).add(new int[]{a, d});
            }

            List<Integer> resList = new ArrayList<>();

            for (int j = 0; j < t; j++) {
                int x = Integer.parseInt(br.readLine()); // 목적지 후보
                resList.add(x);
            }

            resList.sort(Comparator.naturalOrder());
            dij(s);

            for (Integer integer : resList) {
                int dis = dist[integer];

                if (dis % 2 != 0) {
                    bw.write(integer + " ");
                }
            }

            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dij(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        checked = new boolean[n + 1];
        dist = new int[n + 1];

        Arrays.fill(dist, INF);
        Arrays.fill(checked, false);
        dist[s] = 0;
        pq.offer(new int[]{s, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int dis = poll[1];

            if (checked[cur]) {
                continue;
            }

            checked[cur] = true;

            for (int[] ints : map.get(cur)) {
                int next = ints[0];
                int nextDis = ints[1];

                if (!checked[next] && dist[next] > dist[cur] + nextDis) {
                    dist[next] = dist[cur] + nextDis;
                    pq.offer(new int[]{next, dis + nextDis});
                }
            }
        }
    }
}
