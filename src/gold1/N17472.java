package gold1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 다리 만들기 2
public class N17472 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] map;
    static int[] parent;
    static int seq = 1;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
        int m = Integer.parseInt(st.nextToken()); // 지도의 가로 크기
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                if (!visited[i][j]) {
                    bfs(i, j);
                    seq++;
                }
            }
        }

        parent = new int[seq];

        for (int i = 1; i < seq; i++) {
            parent[i] = i;
        }

        List<Bridge> bridges = new ArrayList<>();

        // 가로 다리 놓기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                int start = map[i][j];
                int end = 0;
                int dist = 0;

                for (int k = j + 1; k < m; k++) {
                    if (map[i][j] == map[i][k]) {
                        break;
                    }

                    if (map[i][k] == 0) {
                        dist++;

                        continue;
                    }

                    end = map[i][k];

                    break;
                }

                if (dist >= 2 && end != 0) {
                    bridges.add(new Bridge(start, end, dist));
                }
            }
        }

        // 세로 다리 놓기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[j][i] == 0) {
                    continue;
                }

                int start = map[j][i];
                int end = 0;
                int dist = 0;

                for (int k = j + 1; k < n; k++) {
                    if (map[j][i] == map[k][i]) {
                        break;
                    }

                    if (map[k][i] == 0) {
                        dist++;

                        continue;
                    }

                    end = map[k][i];

                    break;
                }

                if (dist >= 2 && end != 0) {
                    bridges.add(new Bridge(start, end, dist));
                }
            }
        }

        bridges.sort(Comparator.comparingInt(x -> x.d));

        int answer = 0;

        for (Bridge bridge : bridges) {
            if (find(bridge.s) == find(bridge.e)) {
                continue;
            }

            answer += bridge.d;
            union(bridge.s, bridge.e);
        }

        for (int i = 1; i < seq; i++) {
            parent[i] = find(i);
        }

        int island = parent[1];

        for (int i = 2; i < seq; i++) {
            if (parent[i] != island) {
                answer = -1;

                break;
            }
        }

        bw.write(answer + "");
        bw.flush();
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        map[i][j] = seq;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];

            for (int k = 0; k < dy.length; k++) {
                int Y = y + dy[k];
                int X = x + dx[k];

                if (Y >= 0 && Y < map.length && X >= 0 && X < map[Y].length && map[Y][X] != 0 && !visited[Y][X]) {
                    visited[Y][X] = true;
                    map[Y][X] = seq;
                    q.offer(new int[]{Y, X});
                }
            }
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                parent[b] = a;

                return;
            }

            parent[a] = b;
        }
    }

    private static class Bridge {

        int s, e, d;

        public Bridge(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }
    }
}
