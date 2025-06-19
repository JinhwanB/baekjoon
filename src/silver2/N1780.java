package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1780 {

    static BufferedWriter bw;
    static int n;
    static int[][] paper;
    static int count1, count2, count3 = 0;

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
        br.close();

        separate(0, 0, n, n);

        bw.write(count1 + "\n" + count2 + "\n" + count3);
        bw.flush();
        bw.close();
    }

    private static void separate(int x1, int y1, int x2, int y2) {
        int first = paper[x1][y1];
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                int val = paper[i][j];
                if (first != val) {
                    int sepX = (x2 - x1) / 3;
                    int sepY = (y2 - y1) / 3;
                    separate(x1, y1, x1 + sepX, y1 + sepY);
                    separate(x1, y1 + sepY, x1 + sepX, y1 + sepY * 2);
                    separate(x1, y1 + sepY * 2, x1 + sepX, y2);
                    separate(x1 + sepX, y1, x1 + sepX * 2, y1 + sepY);
                    separate(x1 + sepX, y1 + sepY, x1 + sepX * 2, y1 + sepY * 2);
                    separate(x1 + sepX, y1 + sepY * 2, x1 + sepX * 2, y2);
                    separate(x1 + sepX * 2, y1, x2, y1 + sepY);
                    separate(x1 + sepX * 2, y1 + sepY, x2, y1 + sepY * 2);
                    separate(x1 + sepX * 2, y1 + sepY * 2, x2, y2);
                    return;
                }
            }
        }

        if (first == -1) {
            count1++;
            return;
        }

        if (first == 0) {
            count2++;
            return;
        }

        count3++;
    }

}
