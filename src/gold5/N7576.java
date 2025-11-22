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
public class N7576 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int zeroCnt = 0; // 안 익은 토마토 수
    static int dayCnt = 0; // 모두 익는 날짜

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 상자의 가로 크기
        int n = Integer.parseInt(st.nextToken()); // 상자의 세로 크기

        int[][] box = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 0) {
                    zeroCnt++;
                }

                if (box[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        br.close();

        if (zeroCnt == 0) {
            bw.write(dayCnt + "");
            bw.flush();
            bw.close();
            return;
        }

        bfs(box, q);

        if (zeroCnt != 0) {
            bw.write(-1 + "");
            bw.flush();
            bw.close();
            return;
        }

        bw.write(dayCnt - 1 + "");
        bw.flush();
        bw.close();
    }

    private static void bfs(int[][] box, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i = 0; i < dy.length; i++) {
                int Y = y + dy[i];
                int X = x + dx[i];

                if (Y >= 0 && Y < box.length && X >= 0 && X < box[0].length && box[Y][X] == 0) {
                    q.offer(new int[]{Y, X});
                    zeroCnt--;
                    box[Y][X] = box[y][x] + 1;
                    dayCnt = Math.max(dayCnt, box[Y][X]);
                }
            }
        }
    }
}
