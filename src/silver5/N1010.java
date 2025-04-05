package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1010 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            dp = new int[n + 1][m + 1];

            int result = bc(n, m);
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int bc(int n, int m) {
        if (dp[n][m] > 0) {
            return dp[n][m];
        }

        if (n == m || n == 0) {
            return dp[n][m] = 1;
        }

        return dp[n][m] = bc(n - 1, m - 1) + bc(n, m - 1);
    }

}
