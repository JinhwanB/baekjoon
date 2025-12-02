package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 파일 합치기
public class N11066 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int t, k;
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine()); // 테스트 데이터 수

        for (int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine()); // 소설을 구성하는 장의 수
            sum = new int[k + 1];
            dp = new int[k + 1][k + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= k; j++) {
                sum[j] += sum[j - 1] + Integer.parseInt(st.nextToken());
            }

            minCostOfNovel();

            bw.write(dp[1][k] + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }

    private static void minCostOfNovel() {
        for (int i = 2; i <= k; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[j][i] = Integer.MAX_VALUE;
                for (int k = j; k < i; k++) {
                    dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i]);
                }

                dp[j][i] += sum[i] - sum[j - 1];
            }
        }
    }
}
