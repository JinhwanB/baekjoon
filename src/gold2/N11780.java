package gold2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 플로이드 2
public class N11780 {

    static final int INF = 10000001;

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;
    static int[][] next, cost;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 도시의 수
        m = Integer.parseInt(br.readLine()); // 버스의 수
        next = new int[n + 1][n + 1];
        cost = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(cost[i], INF);
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[a][b] = Math.min(cost[a][b], c);
            next[a][b] = a;
        }
        br.close();

        floyd();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (cost[i][j] == INF) {
                    bw.write(0 + " ");
                    continue;
                }

                bw.write(cost[i][j] + " ");
            }
            bw.write("\n");
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (next[i][j] == 0) {
                    bw.write(0 + "\n");
                    continue;
                }

                int e = j;
                stack.add(e);

                while (next[i][e] != i) {
                    stack.add(next[i][e]);
                    e = next[i][e];
                }

                bw.write(stack.size() + 1 + " " + i + " ");

                while (!stack.isEmpty()) {
                    bw.write(stack.pop() + " ");
                }

                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void floyd() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (j == k) {
                        continue;
                    }

                    if (cost[j][k] > cost[j][i] + cost[i][k]) {
                        cost[j][k] = cost[j][i] + cost[i][k];
                        next[j][k] = next[i][k];
                    }
                }
            }
        }
    }
}
