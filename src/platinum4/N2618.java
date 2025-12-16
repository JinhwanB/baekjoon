package platinum4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 경찰차
public class N2618 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, w;
    static int[][] event, dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        event = new int[1001][2];
        dp = new int[1001][1001];
        n = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());

        for (int i = 1; i <= w; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            event[i][0] = a;
            event[i][1] = b;
        }
        br.close();

        int res = solve(1, 0, 0);
        bw.write(res + "\n");

        int o = 0;
        int t = 0;

        for (int i = 1; i <= w; i++) {
            int dis = getDis(1, o, i);

            if (dp[o][t] - dis == dp[i][t]) {
                o = i;
                bw.write(1 + "\n");
                continue;
            }

            t = i;
            bw.write(2 + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int solve(int e, int o, int t) {
        if (e > w) {
            return 0;
        }

        if (dp[o][t] != 0) {
            return dp[o][t];
        }

        int case1 = solve(e + 1, e, t) + getDis(1, o, e);
        int case2 = solve(e + 1, o, e) + getDis(2, t, e);

        return dp[o][t] = Math.min(case1, case2);
    }

    private static int getDis(int type, int start, int end) {
        int[] s = event[start];
        int[] e = event[end];

        if (start == 0) {
            if (type == 1) {
                s = new int[]{1, 1};
            } else {
                s = new int[]{n, n};
            }
        }

        return Math.abs(s[0] - e[0]) + Math.abs(s[1] - e[1]);
    }
}
