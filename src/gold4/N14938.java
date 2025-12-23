package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 서강그라운드
public class N14938 {

    static final int INF = 1501;

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, r;
    static int[] item;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 지역의 개수
        m = Integer.parseInt(st.nextToken()); // 예은이의 수색범위
        r = Integer.parseInt(st.nextToken()); // 길의 개수
        item = new int[n + 1];
        dist = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], l);
            dist[b][a] = Math.min(dist[b][a], l);
        }
        br.close();

        int res = floyd();

        bw.write(res + "");
        bw.flush();
        bw.close();
    }

    private static int floyd() {
        int max = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int fir = item[j];
                for (int k = 1; k <= n; k++) {
                    if (j == k) {
                        continue;
                    }

                    if (dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }

                    if (dist[j][k] <= m) {
                        fir += item[k];
                    }
                }

                max = Math.max(max, fir);
            }
        }

        return max;
    }
}
