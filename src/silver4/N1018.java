package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1018 {

    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String colors = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = colors.charAt(j);
                board[i][j] = c != 'W';
            }
        }
        br.close();

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                find(board, i, j);
            }
        }

        bw.write(min + "");
        bw.flush();
        bw.close();
    }

    private static void find(boolean[][] board, int y, int x) {
        int count = 0;
        boolean cur = board[y][x];
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (cur != board[i][j]) {
                    count++;
                }

                cur = !cur;
            }
            cur = !cur;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
