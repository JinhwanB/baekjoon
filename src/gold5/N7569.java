package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class N7569 {

    static BufferedReader br;
    static BufferedWriter bw;
    static Queue<int[]> q;
    static int m, n, h;
    static int[][][] box;
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int zeroCnt = 0;
    static int dayCnt = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
        n = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수
        h = Integer.parseInt(st.nextToken()); // 쌓아올려지는 상자의 수
        box = new int[h][n][m];
        q = new LinkedList<>();

        for (int i = h - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    if (box[i][j][k] == 0) {
                        zeroCnt++;
                    }

                    if (box[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                    }
                }
            }
        }
        br.close();

        bfs();

        bw.write(zeroCnt != 0 ? (-1 + "") :
                 dayCnt != 0 ? (dayCnt - 1 + "") : (dayCnt + ""));
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int curH = poll[0];
            int curY = poll[1];
            int curX = poll[2];

            for (int i = 0; i < dh.length; i++) {
                int H = curH + dh[i];
                int Y = curY + dy[i];
                int X = curX + dx[i];

                if (H >= 0 && H < h && Y >= 0 && Y < n && X >= 0 && X < m && box[H][Y][X] == 0) {
                    zeroCnt--;
                    box[H][Y][X] = box[curH][curY][curX] + 1;
                    q.offer(new int[]{H, Y, X});

                    if (zeroCnt == 0) {
                        dayCnt = box[H][Y][X];
                        return;
                    }
                }
            }
        }
    }
}
