package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백양로 브레이크
public class N11562 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, k;
    static int[][] dist;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 건물의 수
        m = Integer.parseInt(st.nextToken()); // 길의 수
        dist = new int[n + 1][n + 1];

        for (int[] ints : dist) {
            Arrays.fill(ints, INF);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()); // u에서 v로 가는 길의 양방향 여부, 0인 경우 일방, 1인 경우 양방

            dist[u][v] = 0;

            if (b == 1) {
                dist[v][u] = 0;
                continue;
            }

            dist[v][u] = 1;
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

        k = Integer.parseInt(br.readLine()); // 학생들의 질문의 수

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            bw.write(dist[s][e] + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
