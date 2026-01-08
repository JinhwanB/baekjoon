package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 우주 탐사선
public class N17182 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, k, res;
    static int[][] dist;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 행성의 개수
        k = Integer.parseInt(st.nextToken()); // 발사되는 행성의 위치
        dist = new int[n][n];
        checked = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        checked[k] = true;
        res = Integer.MAX_VALUE;
        solve(1, k, 0);

        bw.write(res + "");
        bw.flush();
        bw.close();
    }

    private static void solve(int cnt, int prev, int d) {
        if (cnt == n) {
            res = Math.min(res, d);
        }

        for (int i = 0; i < n; i++) {
            if (checked[i]) {
                continue;
            }

            checked[i] = true;
            solve(cnt + 1, i, d + dist[prev][i]);
            checked[i] = false;
        }
    }
}
