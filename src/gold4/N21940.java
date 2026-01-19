package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 가운데에서 만나기
public class N21940 {

    static final int INF = 987654321;

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시의 개수
        m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int[][] dist = new int[n + 1][n + 1];

        for (int[] ints : dist) {
            Arrays.fill(ints, INF);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            dist[a][b] = t;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        dist[i][j] = 0;
                        continue;
                    }

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        k = Integer.parseInt(br.readLine()); // 친구들의 총 인원
        int[] friends = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        int min = INF;

        loop:
        for (int i = 1; i <= n; i++) {
            int sum = 0;

            for (int j = 0; j < k; j++) {
                int friend = friends[j];
                int val = dist[friend][i] + dist[i][friend];

                if (val >= INF) {
                    continue loop;
                }

                sum = Math.max(sum, val);
            }

            pq.offer(new int[]{i, sum});
            min = Math.min(min, sum);
        }

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int node = poll[0];
            int l = poll[1];

            if (l != min) {
                break;
            }

            bw.write(node + " ");
        }

        bw.flush();
        bw.close();
    }
}
