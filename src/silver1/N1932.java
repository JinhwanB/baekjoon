package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1932 {

    static BufferedWriter bw;
    static int n;
    static int[][] arr;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }

        bw.write(find(0, 0) + "");
        bw.flush();
        bw.close();
    }

    private static int find(int depth, int idx) {
        if (depth == n - 1) {
            return dp[depth][idx];
        }

        if (dp[depth][idx] == null) {
            dp[depth][idx] =
                Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];
        }

        return dp[depth][idx];
    }

}