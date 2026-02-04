package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 구호물자
public class N11581 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static boolean[][] roads;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 교차로의 수
        roads = new boolean[n + 1][n + 1];

        for (int i = 1; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int c = Integer.parseInt(st.nextToken());
                roads[i][c] = true;
            }
        }
        br.close();

        for (int k = 1; k < n; k++) {
            for (int i = 1; i < n; i++) {
                if (!roads[i][k]) {
                    continue;
                }

                for (int j = 1; j < n; j++) {
                    if (roads[k][j]) {
                        roads[i][j] = true;
                    }
                }
            }
        }

        String res = "NO CYCLE";
        for (int i = 1; i < n; i++) {
            if (roads[1][i] && roads[i][i]) {
                res = "CYCLE";

                break;
            }
        }

        bw.write(res);
        bw.flush();
        bw.close();
    }
}
