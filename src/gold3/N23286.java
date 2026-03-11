package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 허들 넘기
public class N23286 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, t;

    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 수
        m = Integer.parseInt(st.nextToken()); // 간선의 수
        t = Integer.parseInt(st.nextToken()); // 연습 횟수
        int[][] times = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    times[i][j] = 0;
                    continue;
                }

                times[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            times[u][v] = h;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (times[i][j] > Math.max(times[i][k], times[k][j])) {
                        times[i][j] = Math.max(times[i][k], times[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            bw.write((times[s][e] == INF ? -1 : times[s][e]) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
