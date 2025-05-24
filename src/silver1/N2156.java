package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2156 {

    static BufferedWriter bw;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i], dp[i - 1]);
        }

        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }

}
