package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 행렬 곱셈 순서
public class N11049 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 행렬의 갯수

        if (n == 1) {
            br.close();
            bw.write(1 + "");
            bw.flush();
            bw.close();
            return;
        }

        arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i] = r;
            arr[i + 1] = c;
        }
        br.close();

        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int res = minCost(0, n - 1);

        bw.write(res + "");
        bw.flush();
        bw.close();
    }

    private static int minCost(int p, int c) {
        if (p == c) {
            return 0;
        }

        if (dp[p][c] != Integer.MAX_VALUE) {
            return dp[p][c];
        }

        for (int i = p; i < c; i++) {
            int val = minCost(p, i) + minCost(i + 1, c) + (arr[p] * arr[i + 1] * arr[c + 1]);
            dp[p][c] = Math.min(dp[p][c], val);
        }

        return dp[p][c];
    }
}
