package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N25682 {

    static BufferedWriter bw;
    static int n, m, k, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[][] chess;
    static boolean color = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        chess = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();

            for (int j = 1; j <= m; j++) {
                char cur = str.charAt(j - 1);
                if (!color && cur == 'W') {
                    chess[i][j] = 1;
                }

                if (color && cur == 'B') {
                    chess[i][j] = 1;
                }

                color = !color;
            }

            if (m % 2 == 0) {
                color = !color;
            }
        }
        br.close();

        for (int i = 1; i <= n; i++) {
            int val = chess[i][1];

            for (int j = 2; j <= m; j++) {
                val += chess[i][j];
                chess[i][j] = val;
            }
        }

        for (int i = 1; i <= m; i++) {
            int val = chess[1][i];

            for (int j = 2; j <= n; j++) {
                val += chess[j][i];
                chess[j][i] = val;
            }
        }

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int val = chess[i][j] - (chess[i - k][j] + chess[i][j - k] - chess[i - k][j - k]);
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
        }

        int result = Math.min(min, k * k - max);
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

}
