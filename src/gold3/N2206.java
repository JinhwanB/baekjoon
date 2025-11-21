package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
public class N2206 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] matrix = new char[n + 1][m + 1];
        boolean[][][] checked = new boolean[n + 1][m + 1][2];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = s.charAt(j - 1);
            }
        }
        br.close();

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1, 0, 1});
        bfs(matrix, checked, q);

        bw.write(min + "");
        bw.flush();
        bw.close();
    }

    private static void bfs(char[][] matrix, boolean[][][] checked, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            int destroyed = poll[2];
            int cnt = poll[3];

            if (y == n && x == m) {
                min = cnt;
                return;
            }

            for (int i = 0; i < dy.length; i++) {
                int Y = y + dy[i];
                int X = x + dx[i];

                if (Y > 0 && Y < matrix.length && X > 0 && X < matrix[0].length) {
                    if (matrix[Y][X] == '1') { // 벽인 경우
                        if (destroyed == 0) { // 벽을 부신 적이 없는 경우
                            checked[Y][X][1] = true;
                            q.offer(new int[]{Y, X, 1, cnt + 1});
                        }
                    }

                    if (matrix[Y][X] == '0') { // 벽이 아닌 경우
                        if (destroyed == 0 && !checked[Y][X][0]) { // 벽을 부신 적이 없는 경우
                            checked[Y][X][0] = true;
                            q.offer(new int[]{Y, X, 0, cnt + 1});
                            continue;
                        }

                        if (destroyed == 1 && !checked[Y][X][1]) { // 벽을 한 번 부신 경우
                            checked[Y][X][1] = true;
                            q.offer(new int[]{Y, X, 1, cnt + 1});
                        }
                    }
                }
            }
        }

        min = -1;
    }
}
