package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 호석이 두 마리 치킨
public class N21278 {

    static final int INF = 987654321;

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 건물의 개수
        m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int[][] dist = new int[n + 1][n + 1];

        for (int[] ints : dist) {
            Arrays.fill(ints, INF);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        br.close();

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

        int a = 0, b = 0, d = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }

                int sum = 0;

                for (int k = 1; k <= n; k++) {
                    int val1 = dist[k][i];
                    int val2 = dist[k][j];
                    sum += Math.min(val1, val2) * 2;
                }

                if (d > sum) {
                    a = i;
                    b = j;
                    d = sum;
                }
            }
        }

        bw.write(Math.min(a, b) + " " + Math.max(a, b) + " " + d);
        bw.flush();
        bw.close();
    }
}
