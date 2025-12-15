package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// LCS 2
public class N9252 {

    static BufferedReader br;
    static BufferedWriter bw;
    static String[] s1, s2;
    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s1 = br.readLine().split("");
        s2 = br.readLine().split("");
        br.close();

        for (int i = 0; i < s1.length; i++) {
            String c1 = s1[i];

            for (int j = 0; j < s2.length; j++) {
                String c2 = s2[j];

                if (c1.equals(c2)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    continue;
                }

                dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        String ans = getAns();

        if (!ans.isEmpty()) {
            bw.write(ans.length() + "\n");
            bw.write(ans);
            bw.flush();
            bw.close();
            return;
        }

        bw.write(0 + "");
        bw.flush();
        bw.close();
    }

    private static String getAns() {
        int x = s1.length;
        int y = s2.length;
        StringBuilder a = new StringBuilder();

        while (x != 0 && y != 0) {
            if (s1[x - 1].equals(s2[y - 1])) {
                a.append(s1[x - 1]);
                x -= 1;
                y -= 1;
                continue;
            }

            if (dp[x - 1][y] == dp[x][y]) {
                x -= 1;
                continue;
            }

            if (dp[x][y - 1] == dp[x][y]) {
                y -= 1;
                continue;
            }

            x -= 1;
            y -= 1;
        }

        return a.reverse().toString();
    }
}
