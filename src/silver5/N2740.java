package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2740 {

    private static final int THRESHOLD = 16;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrix1 = new int[128][128];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                matrix1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] matrix2 = new int[128][128];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < k; j++) {
                matrix2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int big = Math.max(n, Math.max(m, k));
        int size = 1;
        while (size < big) {

            size *= 2;
        }

        int[][] result = multiply(matrix1, matrix2, size);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                bw.write(result[i][j] + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static int[][] loopMultiply(int[][] a, int[][] b, int size) {

        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    private static int[][] multiply(int[][] a, int[][] b, int size) {
        int[][] result = new int[size][size];

        if (size <= THRESHOLD) {
            return loopMultiply(a, b, size);
        }

        int newSize = size / 2;

        int[][] a11 = subMatrix(a, 0, 0, newSize);
        int[][] a12 = subMatrix(a, 0, newSize, newSize);
        int[][] a21 = subMatrix(a, newSize, 0, newSize);
        int[][] a22 = subMatrix(a, newSize, newSize, newSize);

        int[][] b11 = subMatrix(b, 0, 0, newSize);
        int[][] b12 = subMatrix(b, 0, newSize, newSize);
        int[][] b21 = subMatrix(b, newSize, 0, newSize);
        int[][] b22 = subMatrix(b, newSize, newSize, newSize);

        int[][] m1 = multiply(add(a11, a22, newSize), add(b11, b22, newSize), newSize);
        int[][] m2 = multiply(add(a21, a22, newSize), b11, newSize);
        int[][] m3 = multiply(a11, sub(b12, b22, newSize), newSize);
        int[][] m4 = multiply(a22, sub(b21, b11, newSize), newSize);
        int[][] m5 = multiply(add(a11, a12, newSize), b22, newSize);
        int[][] m6 = multiply(sub(a21, a11, newSize), add(b11, b12, newSize), newSize);
        int[][] m7 = multiply(sub(a12, a22, newSize), add(b21, b22, newSize), newSize);

        int[][] c11 = add(sub(add(m1, m4, newSize), m5, newSize), m7, newSize);
        int[][] c12 = add(m3, m5, newSize);
        int[][] c21 = add(m2, m4, newSize);
        int[][] c22 = add(add(sub(m1, m2, newSize), m3, newSize), m6, newSize);

        merge(c11, result, 0, 0, newSize);
        merge(c12, result, 0, newSize, newSize);
        merge(c21, result, newSize, 0, newSize);
        merge(c22, result, newSize, newSize, newSize);

        return result;
    }

    private static int[][] subMatrix(int[][] matrix, int row, int col, int size) {
        int[][] result = new int[size][size];
        for (int i = 0, matrixI = row; i < size; i++, matrixI++) {
            for (int j = 0, matrixJ = col; j < size; j++, matrixJ++) {
                result[i][j] = matrix[matrixI][matrixJ];
            }
        }

        return result;
    }

    private static int[][] add(int[][] a, int[][] b, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }

    private static int[][] sub(int[][] a, int[][] b, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }

        return result;
    }

    private static void merge(int[][] a, int[][] b, int row, int col, int size) {
        for (int i = 0, bI = row; i < size; i++, bI++) {
            for (int j = 0, bJ = col; j < size; j++, bJ++) {
                b[bI][bJ] = a[i][j];
            }
        }
    }

}