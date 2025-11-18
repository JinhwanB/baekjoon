package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
public class N2178 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = s.charAt(j - 1);
            }
        }
        br.close();

        int[][] count = new int[n + 1][m + 1];

        bfs(map, count);

        bw.flush();
        bw.close();
    }

    private static void bfs(char[][] map, int[][] count) throws IOException {
        count[1][1] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1});
        roop:
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < dy.length; i++) {
                int Y = poll[0] + dy[i];
                int X = poll[1] + dx[i];
                if (Y > 0 && Y < map.length && X > 0 && X < map[0].length && map[Y][X] == '1' && count[Y][X] == 0) {
                    count[Y][X] = count[poll[0]][poll[1]] + 1;
                    if (Y == map.length - 1 && X == map[0].length - 1) {
                        bw.write(count[Y][X] + "");
                        break roop;
                    }
                    q.offer(new int[]{Y, X});
                }
            }
        }
    }
}
