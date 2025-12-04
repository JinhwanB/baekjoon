package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 양팔저울
public class N2629 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, b;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 추의 개수
        arr = new int[n + 1];
        dp = new boolean[31][15001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp(0, 0);

        b = Integer.parseInt(br.readLine()); // 구슬의 개수
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < b; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num > 15000) {
                bw.write("N ");
                continue;
            }

            bw.write((dp[n][num] ? "Y " : "N "));
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void dp(int idx, int weight) {
        if (dp[idx][weight]) {
            return;
        }

        dp[idx][weight] = true;

        if (idx == n) {
            return;
        }

        dp(idx + 1, weight);
        dp(idx + 1, weight + arr[idx + 1]);
        dp(idx + 1, Math.abs(weight - arr[idx + 1]));
    }
}
