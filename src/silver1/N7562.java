package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트의 이동
public class N7562 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] dy = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int targetY;
    static int targetX;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이
            int[][] chessMap = new int[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int curY = Integer.parseInt(st.nextToken()); // 현재 나이트가 있는 y 위치
            int curX = Integer.parseInt(st.nextToken()); // 현재 나이트가 있는 x 위치

            st = new StringTokenizer(br.readLine());
            targetY = Integer.parseInt(st.nextToken()); // 나이트가 이동하려고 하는 y 위치
            targetX = Integer.parseInt(st.nextToken()); // 나이트가 이동하려고 하는 x 위치

            if (curY == targetY && curX == targetX) {
                bw.write(0 + "\n");
                continue;
            }

            bfs(chessMap, curY, curX);
        }
        br.close();

        bw.flush();
        bw.close();
    }

    private static void bfs(int[][] chessMap, int y, int x) throws IOException {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < dy.length; i++) {
                int Y = poll[0] + dy[i];
                int X = poll[1] + dx[i];
                if (Y >= 0 && Y < chessMap.length && X >= 0 && X < chessMap[0].length && chessMap[Y][X] == 0) {
                    q.offer(new int[]{Y, X});
                    chessMap[Y][X] = chessMap[poll[0]][poll[1]] + 1;
                    if (Y == targetY && X == targetX) {
                        bw.write(chessMap[Y][X] + "\n");
                        return;
                    }
                }
            }
        }
    }
}
