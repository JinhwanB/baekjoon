package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 회장뽑기
public class N2660 {

    static final int INF = 51;
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[][] friends;
    static int[] scores;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 회원의 수
        friends = new int[n + 1][n + 1];

        for (int[] friend : friends) {
            Arrays.fill(friend, INF);
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1) {
                break;
            }

            friends[a][b] = Math.min(friends[a][b], 1);
            friends[b][a] = Math.min(friends[b][a], 1);
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (friends[i][j] > friends[i][k] + friends[k][j]) {
                        friends[i][j] = friends[i][k] + friends[k][j];
                    }
                }
            }
        }

        scores = new int[n + 1];
        int min = INF;

        for (int i = 1; i <= n; i++) {
            int score = 0;

            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }

                score = Math.max(score, friends[i][j]);
            }

            scores[i] = score;
            min = Math.min(min, score);
        }

        pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            int score = scores[i];

            if (score == min) {
                pq.offer(i);
            }
        }

        bw.write(min + " " + pq.size() + "\n");

        while (!pq.isEmpty()) {
            int poll = pq.poll();

            bw.write(poll + " ");
        }

        bw.flush();
        bw.close();
    }
}
