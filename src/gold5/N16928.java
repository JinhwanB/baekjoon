package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 뱀과 사다리 게임
public class N16928 {

    static BufferedReader br;
    static BufferedWriter bw;
    static Map<Integer, Integer> laddersOrSnakes;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        laddersOrSnakes = new HashMap<>();
        int[] board = new int[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리의 수
        int m = Integer.parseInt(st.nextToken()); // 뱀의 수

        for (int i = 0; i < n; i++) { // 사다리 이동 저장
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            laddersOrSnakes.put(x, y);
        }

        for (int i = 0; i < m; i++) { // 뱀 이동 저장
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            laddersOrSnakes.put(u, v);
        }
        br.close();

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        bfs(board, q);

        bw.write(board[100] + "");
        bw.flush();
        bw.close();
    }

    private static void bfs(int[] board, Queue<Integer> q) {
        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int i = 1; i <= 6; i++) {
                int movedVal = poll + i;
                movedVal =
                        laddersOrSnakes.getOrDefault(movedVal, -1) != -1 ?
                        laddersOrSnakes.get(movedVal) : movedVal;

                if (movedVal <= 100 && board[movedVal] == 0) {
                    board[movedVal] = board[poll] + 1;

                    if (movedVal == 100) {
                        return;
                    }

                    q.offer(movedVal);
                }
            }
        }
    }
}
