package platinum3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 도망자 원숭이
public class N1602 {

    static final int INF = 987654321;

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, q;
    static int[][] dist;
    static int[][] cost;
    static int[] dog;
    static Integer[] lowDogTimeArr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시의 개수
        m = Integer.parseInt(st.nextToken()); // 도로의 개수
        q = Integer.parseInt(st.nextToken()); // 질문의 개수
        dist = new int[n + 1][n + 1];
        cost = new int[n + 1][n + 1];
        dog = new int[n + 1];
        lowDogTimeArr = new Integer[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            dog[i] = Integer.parseInt(st.nextToken());
            lowDogTimeArr[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                    cost[i][j] = dog[i];
                    continue;
                }

                dist[i][j] = INF;
                cost[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            dist[a][b] = dist[b][a] = d;
            cost[a][b] = cost[b][a] = d + Math.max(dog[a], dog[b]);
        }

        Arrays.sort(lowDogTimeArr, 1, n + 1, Comparator.comparingInt((Integer o) -> dog[o]));

        int idx;
        for (int k = 1; k <= n; k++) {
            idx = lowDogTimeArr[k];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][idx] != INF && dist[idx][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][idx] + dist[idx][j]);
                        cost[i][j] = Math.min(cost[i][j], dist[i][j] + Math.max(dog[i], Math.max(dog[idx], dog[j])));
                    }
                }
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            bw.write((cost[s][t] == INF ? -1 : cost[s][t]) + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
