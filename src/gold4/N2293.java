package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 동전 1
public class N2293 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, k;
    static int[] coin, dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 동전의 수
        k = Integer.parseInt(st.nextToken()); // 목표 합
        coin = new int[n + 1];
        dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            for (int j = coin[i]; j <= k; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }
        br.close();

        bw.write(dp[k] + "");
        bw.flush();
        bw.close();
    }
}
