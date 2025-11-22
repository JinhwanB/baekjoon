package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추
public class N1012 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int cnt = 0;
    static int[][] bat;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 배추밭의 가로길이
            int n = Integer.parseInt(st.nextToken()); // 배추밭의 세로길이
            int k = Integer.parseInt(st.nextToken()); // 배추 갯수
            bat = new int[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 배추의 x위치
                int y = Integer.parseInt(st.nextToken()); // 배추의 y위치

                bat[y][x] = 1;
            }

            checked = new boolean[n][m];
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    int cur = bat[j][l];
                    if (cur == 1 && !checked[j][l]) {
                        cnt++;
                        checked[j][l] = true;
                        bfs(j, l);
                    }
                }
            }

            bw.write(cnt + "\n");
            cnt = 0;
        }
        br.close();

        bw.flush();
        bw.close();
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < dy.length; i++) {
                int Y = poll[0] + dy[i];
                int X = poll[1] + dx[i];
                if (Y >= 0 && Y < bat.length && X >= 0 && X < bat[0].length && !checked[Y][X] && bat[Y][X] == 1) {
                    q.offer(new int[]{Y, X});
                    checked[Y][X] = true;
                }
            }
        }
    }
}
