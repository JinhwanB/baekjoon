package gold2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 궁금한 민호
public class N1507 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, res;
    static int[][] dist, arr;
    static boolean[][] checked;
    static final int INF = 50000;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        res = 0;
        n = Integer.parseInt(br.readLine()); // 도시의 개수
        dist = new int[n + 1][n + 1]; // 주어진 모든 도시에 대한 최소 이동 시간
        arr = new int[n + 1][n + 1]; // 최소 도로
        checked = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = dist[i][j];
            }
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j || i == k || k == j) {
                        continue;
                    }

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        bw.write(-1 + "");
                        bw.flush();
                        bw.close();
                        return;
                    }

                    if (dist[i][j] == dist[i][k] + dist[k][j]) {
                        arr[i][j] = INF;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != INF && i != j && !checked[i][j]) {
                    res += arr[i][j];
                    checked[i][j] = checked[j][i] = true;
                }
            }
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}
