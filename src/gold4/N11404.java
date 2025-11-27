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

// 플로이드
public class N11404 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, a, b, c;
    static List<List<int[]>> map;
    static int[][] cost;
    static boolean[] checked;
    static final int INF = 100000 * 100 * 2;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 도시의 개수
        m = Integer.parseInt(br.readLine()); // 버스의 개수
        map = new ArrayList<>();
        cost = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()); // 버스의 시작 도시
            b = Integer.parseInt(st.nextToken()); // 버스의 도착 도시
            c = Integer.parseInt(st.nextToken()); // 한 번 타는데 필요한 비용

            map.get(a).add(new int[]{b, c});
        }
        br.close();

        for (int i = 1; i <= n; i++) {
            dij(i);
            for (int j = 1; j <= n; j++) {
                int num = cost[i][j] == INF ? 0 : cost[i][j];
                bw.write(num + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void dij(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1[1]));
        checked = new boolean[n + 1];
        Arrays.fill(cost[s], INF);
        pq.offer(new int[]{s, 0});
        cost[s][s] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];

            if (checked[cur]) {
                continue;
            }

            checked[cur] = true;

            for (int[] ints : map.get(cur)) {
                int next = ints[0];
                int nextCost = ints[1];

                if (!checked[next] && cost[s][next] > cost[s][cur] + nextCost) {
                    cost[s][next] = cost[s][cur] + nextCost;
                    pq.offer(new int[]{next, cost[s][next]});
                }
            }
        }
    }
}
