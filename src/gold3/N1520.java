package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 내리막 길
public class N1520 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int m, n;
    static int[][] map, dp;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int res = findRoad(0, 0);

        bw.write(res + "");
        bw.flush();
        bw.close();
    }

    private static int findRoad(int y, int x) {
        if (y == m - 1 && x == n - 1) {
            return 1;
        }

        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;
        for (int i = 0; i < dy.length; i++) {
            int Y = y + dy[i];
            int X = x + dx[i];

            if (Y < 0 || Y >= m || X < 0 || X >= n || map[y][x] <= map[Y][X]) {
                continue;
            }

            dp[y][x] += findRoad(Y, X);
        }

        return dp[y][x];
    }
}
