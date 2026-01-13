package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 비밀 모임
public class N13424 {

    static final int INF = 987654321;

    static BufferedReader br;
    static BufferedWriter bw;
    static int t, n, m, k;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 방의 개수
            m = Integer.parseInt(st.nextToken()); // 비밀통로의 개수
            int[][] dist = new int[n + 1][n + 1];

            for (int j = 0; j <= n; j++) {
                Arrays.fill(dist[j], INF);
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                dist[a][b] = c;
                dist[b][a] = c;
            }

            for (int k = 1; k <= n; k++) {
                for (int x = 1; x <= n; x++) {
                    for (int y = 1; y <= n; y++) {
                        if (x == y) {
                            dist[x][y] = 0;
                            continue;
                        }

                        dist[x][y] = Math.min(dist[x][y], dist[x][k] + dist[k][y]);
                    }
                }
            }

            k = Integer.parseInt(br.readLine()); // 친구의 수
            int[] friends = new int[k];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                friends[j] = Integer.parseInt(st.nextToken());
            }

            int room = 0;
            int min = Integer.MAX_VALUE;

            for (int x = 1; x <= n; x++) {
                int sum = 0;

                for (int y = 0; y < k; y++) {
                    int friend = friends[y];
                    sum += dist[friend][x];
                }

                if (min > sum) {
                    min = sum;
                    room = x;
                }
            }

            bw.write(room + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
