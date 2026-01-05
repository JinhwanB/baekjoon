package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 택배
public class N1719 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;
    static int[][] dist, res;
    static final int INF = 10000001;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 집하장의 개수
        m = Integer.parseInt(st.nextToken()); // 집하장간 경로의 개수
        dist = new int[n + 1][n + 1];
        res = new int[n + 1][n + 1];

        for (int[] a : dist) {
            Arrays.fill(a, INF);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                res[i][j] = j;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = Math.min(dist[b][a], c);
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        res[i][j] = res[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int num = res[i][j];

                if (i == j) {
                    bw.write("- ");
                    continue;
                }

                bw.write(num + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
