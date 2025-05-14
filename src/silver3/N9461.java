package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N9461 {

    static BufferedWriter bw;
    static int t;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp = new long[101];
        t = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n <= 5 || dp[n] != 0) {
                bw.write(dp[n] + "\n");
                continue;
            }

            for (int j = 6; j <= n; j++) {
                if (dp[j] != 0) {
                    continue;
                }

                dp[j] = dp[j - 1] + dp[j - 5];
            }

            bw.write(dp[n] + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }

}
