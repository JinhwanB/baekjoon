package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 저울
public class N10159 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;
    static int[][] stuffs;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        stuffs = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            stuffs[a][b] = 1;
            stuffs[b][a] = -1;
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (stuffs[i][k] == 1 && stuffs[k][j] == 1) {
                        stuffs[i][j] = 1;
                    }

                    if (stuffs[i][k] == -1 && stuffs[k][j] == -1) {
                        stuffs[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }

                if (stuffs[i][j] == 0) {
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }
}
