package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Small World Network
public class N18243 {

    static final int INF = 987654321;

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, k;
    static int[][] friends;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 지구에 있는 사람의 수
        k = Integer.parseInt(st.nextToken()); // 친구 관계의 개수
        friends = new int[n + 1][n + 1];

        for (int[] friend : friends) {
            Arrays.fill(friend, INF);
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a][b] = 1;
            friends[b][a] = 1;
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j || i == k || k == j) {
                        continue;
                    }

                    friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }

                if (friends[i][j] > 6) {
                    bw.write("Big World!");
                    bw.flush();
                    bw.close();

                    return;
                }
            }
        }

        bw.write("Small World!");
        bw.flush();
        bw.close();
    }
}
