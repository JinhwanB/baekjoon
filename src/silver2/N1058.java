package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 친구
public class N1058 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[][] friends;
    static final int INF = 51;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        friends = new int[n + 1][n + 1];

        for (int[] friend : friends) {
            Arrays.fill(friend, INF);
        }

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();

            for (int j = 1; j <= n; j++) {
                char c = s.charAt(j - 1);

                if (c == 'Y') {
                    friends[i][j] = 1;
                }
            }
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (friends[i][j] > friends[i][k] + friends[k][j]) {
                        friends[i][j] = friends[i][k] + friends[k][j];
                    }
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (friends[i][j] == 2 || friends[i][j] == 1) {
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}
