package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 텔레포트
public class N16958 {

    static final int INF = 987654321;
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, t, m;
    static int[][] node;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시의 수
        t = Integer.parseInt(st.nextToken()); // 텔레포트 하는데 걸리는 시간
        node = new int[n + 1][3];
        dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                    continue;
                }

                dist[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            node[i][0] = s;
            node[i][1] = x;
            node[i][2] = y;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                dist[i][j] = dist[j][i] = Math.abs(node[i][1] - node[j][1]) + Math.abs(node[i][2] - node[j][2]);

                if (node[i][0] == 1 && node[j][0] == 1) {
                    dist[i][j] = dist[j][i] = Math.min(dist[i][j], t);
                }
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(dist[a][b] + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
