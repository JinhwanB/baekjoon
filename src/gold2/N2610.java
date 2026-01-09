package gold2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 회의준비
public class N2610 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 회의에 참석하는 사람의 수
        m = Integer.parseInt(br.readLine()); // 서로 알고 있는 관계의 수
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
            dist[b][a] = 1;
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
                }
            }
        }

        List<Integer> readers = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                readers.add(findReader(i, visited, dist));
            }
        }

        bw.write(readers.size() + "\n");

        Collections.sort(readers);
        for (Integer reader : readers) {
            bw.write(reader + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int findReader(int i, boolean[] visited, int[][] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;

        List<Integer> teams = new ArrayList<>();
        teams.add(i);

        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int j = 1; j <= n; j++) {
                if (dist[poll][j] != INF && !visited[j]) {
                    q.offer(j);
                    visited[j] = true;
                    teams.add(j);
                }
            }
        }

        int idx = -1;
        int res = INF;

        for (int a = 1; a <= n; a++) {
            if (!teams.contains(a)) {
                continue;
            }

            int max = 0;

            for (int b = 1; b <= n; b++) {
                if (!teams.contains(b)) {
                    continue;
                }

                max = Math.max(max, dist[a][b]);
            }

            if (res > max) {
                res = max;
                idx = a;
            }
        }

        return idx;
    }
}
