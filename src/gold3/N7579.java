package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 앱
public class N7579 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;
    static int[] memory, cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 앱 수
        m = Integer.parseInt(st.nextToken()); // 필요한 메모리
        memory = new int[n];
        cost = new int[n];
        dp = new int[n][10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int mem = memory[i];
            int c = cost[i];
            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {
                    if (j >= c) {
                        dp[i][j] = mem;
                    }
                } else {
                    if (j >= c) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c] + mem);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

                if (dp[i][j] >= m) {
                    res = Math.min(res, j);
                }
            }
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}
