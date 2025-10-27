package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N10830 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] matrix;
    static int n;
    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[][] result = squareMatrix(matrix, b);
        for (int[] ints : result) {
            for (int j = 0; j < result[0].length; j++) {
                int num = ints[j];
                bw.write(num + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static int[][] squareMatrix(int[][] mainMatrix, long exp) {
        if (exp == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mainMatrix[i][j] >= MOD) {
                        mainMatrix[i][j] %= MOD;
                    }
                }
            }

            return mainMatrix;
        }

        int[][] ret = squareMatrix(mainMatrix, exp / 2);
        ret = mulMatrix(ret, ret);

        if (exp % 2 == 1) {
            ret = mulMatrix(ret, matrix);
        }

        return ret;
    }

    private static int[][] mulMatrix(int[][] a, int[][] b) {
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                    res[i][j] %= MOD;
                }
            }
        }

        return res;
    }
}
