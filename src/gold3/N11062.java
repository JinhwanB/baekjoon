package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 카드 게임
public class N11062 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int t, n;
    static int[] cards;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            cards = new int[n];
            dp = new int[n + 1][n + 1];
            for (int j = 0; j < n; j++) {
                cards[j] = Integer.parseInt(st.nextToken());
            }

            solve(0, n - 1, true);
            bw.write(dp[0][n - 1] + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }

    private static int solve(int left, int right, boolean flag) {
        if (left > right) {
            return 0;
        }

        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        if (flag) {
            return dp[left][right] = Math.max(cards[left] + solve(left + 1, right, false), cards[right] + solve(left, right - 1, false));
        }

        return dp[left][right] = Math.min(solve(left + 1, right, true), solve(left, right - 1, true));
    }
}
