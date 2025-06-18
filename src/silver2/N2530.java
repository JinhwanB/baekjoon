package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2530 {

    static BufferedWriter bw;
    static int n;
    static int[][] paper;
    static int whiteCount, blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        separate(0, 0, n, n);

        bw.write(whiteCount + "\n" + blueCount);
        bw.flush();
        bw.close();
    }

    private static void separate(int x1, int y1, int x2, int y2) {
        int first = paper[x1][y1];
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                int val = paper[i][j];
                if (first != val) {
                    separate(x1, y1, (x1 + x2) / 2, (y1 + y2) / 2);
                    separate(x1, (y1 + y2) / 2, (x1 + x2) / 2, y2);
                    separate((x1 + x2) / 2, y1, x2, (y1 + y2) / 2);
                    separate((x1 + x2) / 2, (y1 + y2) / 2, x2, y2);
                    return;
                }
            }
        }

        if (first == 0) {
            whiteCount++;
            return;
        }

        blueCount++;
    }

}
