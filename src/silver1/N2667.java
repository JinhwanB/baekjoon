package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 단지번호붙이기
public class N2667 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 지도의 크기
        boolean[][] checked = new boolean[n][n];
        char[][] houses = new char[n][n];
        for (int i = 0; i < n; i++) {
            houses[i] = br.readLine().toCharArray();
        }
        br.close();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = houses[i][j];
                if (c == '1' && !checked[i][j]) {
                    q.offer(new int[]{i, j});
                    checked[i][j] = true;
                    int houseCnt = 1;

                    while (!q.isEmpty()) {
                        int[] poll = q.poll();
                        for (int k = 0; k < dx.length; k++) {
                            int y = poll[0] + dy[k];
                            int x = poll[1] + dx[k];
                            if (y >= 0 && y < n && x >= 0 && x < n && !checked[y][x] && houses[y][x] == '1') {
                                q.offer(new int[]{y, x});
                                checked[y][x] = true;
                                houseCnt++;
                            }
                        }
                    }

                    pq.offer(houseCnt);
                }
            }
        }

        bw.write(pq.size() + "\n");

        while (!pq.isEmpty()) {
            bw.write(pq.poll() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
