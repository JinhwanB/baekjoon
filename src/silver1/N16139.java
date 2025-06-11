package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N16139 {

    static BufferedWriter bw;
    static String s;
    static int q;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = br.readLine();
        q = Integer.parseInt(br.readLine());
        dp = new int[s.length() + 1][26];

        for (int i = 1; i <= s.length(); i++) {
            int curSearchChar = s.charAt(i - 1) - 'a';

            for (int j = 0; j < 26; j++) {
                int beforeVal = dp[i - 1][j];
                dp[i][j] = curSearchChar == j ? beforeVal + 1 : beforeVal;
            }
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken()) + 1;
            int r = Integer.parseInt(st.nextToken()) + 1;

            int cnt = dp[r][a] - dp[l - 1][a];
            bw.write(cnt + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }

}
