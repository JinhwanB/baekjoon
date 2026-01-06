package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 구슬 찾기
public class N2617 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, half, res;
    static int[][] balls;
    static int[] b, s;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 구슬의 수
        m = Integer.parseInt(st.nextToken()); // 저울에 올려본 쌍의 개수
        half = (n + 1) / 2;
        res = 0;
        balls = new int[n + 1][n + 1];
        b = new int[n + 1];
        s = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            balls[a1][a2] = 1;
            balls[a2][a1] = -1;
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (balls[i][k] == 1 && balls[k][j] == 1) {
                        balls[i][j] = 1;
                    }

                    if (balls[i][k] == -1 && balls[k][j] == -1) {
                        balls[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (balls[i][j] == 1) {
                    b[i]++;
                }

                if (balls[i][j] == -1) {
                    s[i]++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (b[i] >= half) {
                res++;
            }

            if (s[i] >= half) {
                res++;
            }
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}
