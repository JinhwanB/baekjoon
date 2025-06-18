package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N1992 {

    static BufferedWriter bw;
    static int n;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        tree = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                tree[i][j] = Integer.parseInt(String.valueOf(c));
            }
        }
        br.close();

        separate(0, 0, n, n);
        
        bw.flush();
        bw.close();
    }

    private static void separate(int x1, int y1, int x2, int y2) throws IOException {
        int first = tree[x1][y1];

        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                int val = tree[i][j];
                if (first != val) {
                    bw.write("(");
                    separate(x1, y1, (x1 + x2) / 2, (y1 + y2) / 2);
                    separate(x1, (y1 + y2) / 2, (x1 + x2) / 2, y2);
                    separate((x1 + x2) / 2, y1, x2, (y1 + y2) / 2);
                    separate((x1 + x2) / 2, (y1 + y2) / 2, x2, y2);
                    bw.write(")");
                    return;
                }
            }
        }

        bw.write(first + "");
    }

}
