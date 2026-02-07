package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Line Friends (Small)
public class N14588 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, q;
    static int[][] node;
    static int[][] friends;

    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 선분의 수
        node = new int[n + 1][2];
        friends = new int[n + 1][n + 1];

        for (int[] friend : friends) {
            Arrays.fill(friend, INF);
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            node[i][0] = l;
            node[i][1] = r;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if ((node[j][0] >= node[i][0] && node[j][0] <= node[i][1]) || (node[j][1] >= node[i][0] && node[j][1] <= node[i][1]) || (node[j][0] < node[i][0] && node[j][1] > node[i][1])) {
                    friends[i][j] = friends[j][i] = 1;
                }
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
                }
            }
        }

        q = Integer.parseInt(br.readLine()); // 질문의 수
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (friends[a][b] == INF) {
                bw.write("-1\n");
                continue;
            }

            bw.write(friends[a][b] + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
