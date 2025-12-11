package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1로 만들기 2
public class N12852 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        br.close();

        dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }

        bw.write(dp[n] + "\n");

        while (n > 0) {
            bw.write(n + " ");

            if (n == 1) {
                break;
            }

            if (n % 3 == 0 && dp[n / 3] == dp[n] - 1) {
                n /= 3;
                continue;
            }

            if (n % 2 == 0 && dp[n / 2] == dp[n] - 1) {
                n /= 2;
                continue;
            }

            n -= 1;
        }

        bw.flush();
        bw.close();
    }
}
