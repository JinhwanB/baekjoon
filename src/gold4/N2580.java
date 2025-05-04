package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;

public class N2580 {

    static BufferedWriter bw;
    static int[][] arr;
    static List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        sdoku(0, 0);
    }

    private static void sdoku(int x, int y) throws IOException {
        if (y == 9) {
            sdoku(x + 1, 0);
            return;
        }

        if (x == 9) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    int num = arr[i][j];
                    bw.write(num + " ");
                }

                bw.write("\n");
            }

            bw.flush();
            bw.close();

            System.exit(0);
        }

        if (arr[x][y] == 0) {
            for (int k = 1; k <= 9; k++) {
                if (possible(x, y, k)) {
                    arr[x][y] = k;
                    sdoku(x, y + 1);
                }
            }

            arr[x][y] = 0;
            return;
        }

        sdoku(x, y + 1);
    }

    private static boolean possible(int x, int y, int val) {
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        // 33칸의 경우
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (arr[i][j] == val) {
                    return false;
                }
            }
        }
        // 가로
        for (int i = 0; i < 9; i++) {
            if (arr[x][i] == val) {
                return false;
            }
        }
        // 세로
        for (int i = 0; i < 9; i++) {
            if (arr[i][y] == val) {
                return false;
            }
        }

        return true;
    }

}
