package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 키 순서
public class N2458 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, res = 0;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        checked = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            checked[a][b] = true;
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (checked[i][k] && checked[k][j]) {
                        checked[i][j] = true;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (checked[i][j] || checked[j][i]) {
                    cnt++;
                }
            }

            if (cnt == n - 1) {
                res++;
            }
            cnt = 0;
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}
