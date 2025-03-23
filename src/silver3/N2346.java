package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

public class N2346 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> balloons = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            balloons.offerLast(new int[]{i, num});
        }
        br.close();

        if (!balloons.isEmpty()) {
            int[] firstBalloon = balloons.pollFirst();
            int move = firstBalloon[1];
            bw.write("1 ");
            for (int i = 0; i < n - 1; i++) {
                if (move < 0) {
                    for (int j = 0; j < move * -1 - 1; j++) {
                        int[] balloon = balloons.pollLast();
                        balloons.offerFirst(balloon);
                    }

                    int[] balloon = balloons.pollLast();
                    int balloonNum = Objects.requireNonNull(balloon)[0];
                    move = balloon[1];

                    bw.write(balloonNum + " ");
                    continue;
                }

                for (int j = 0; j < move - 1; j++) {
                    int[] balloon = balloons.pollFirst();
                    balloons.offerLast(balloon);
                }

                int[] balloon = balloons.pollFirst();
                int balloonNum = Objects.requireNonNull(balloon)[0];
                move = balloon[1];

                bw.write(balloonNum + " ");
            }
        }

        bw.flush();
        bw.close();
    }

}
