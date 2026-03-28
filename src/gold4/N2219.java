package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 보안 시스템 설치
public class N2219 {

    static final int INF = 987654321;

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;
    static int[][] lines;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 컴퓨터 수
        m = Integer.parseInt(st.nextToken()); // 회선의 수
        lines = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i != j) {
                    lines[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lines[a][b] = c;
            lines[b][a] = c;
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }

                    lines[i][j] = Math.min(lines[i][j], lines[i][k] + lines[k][j]);
                }
            }
        }

        int computer = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (lines[i][j] != INF) {
                    sum += lines[i][j];
                }
            }

            if (sum != 0 && sum < min) {
                computer = i;
                min = sum;
            }
        }

        bw.write(computer + "");
        bw.flush();
        bw.close();
    }
}
