package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 3
public class N13549 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, k;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        k = Integer.parseInt(st.nextToken()); // 동생의 위치
        br.close();

        checked = new boolean[100001];

        bfs(n);

        bw.flush();
        bw.close();
    }

    private static void bfs(int s) throws IOException {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, 0});
        checked[s] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int now = poll[0];
            int time = poll[1];

            if (now == k) {
                bw.write(time + "");
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next = 0;
                int nextTime = 0;

                if (i == 0) {
                    next = now * 2;
                    nextTime = time;
                }

                if (i == 1) {
                    next = now - 1;
                    nextTime = time + 1;
                }

                if (i == 2) {
                    next = now + 1;
                    nextTime = time + 1;
                }

                if (next >= 0 && next <= 100000 && !checked[next]) {
                    q.add(new int[]{next, nextTime});
                    checked[next] = true;
                }
            }
        }
    }
}
