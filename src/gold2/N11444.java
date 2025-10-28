package gold2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N11444 {

    static BufferedReader br;
    static BufferedWriter bw;
    static long n;
    static long[][] matrix = {{1, 1}, {1, 0}};

    static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Long.parseLong(br.readLine());
        br.close();

        if (n == 0 || n == 1) {
            bw.write(n + "");
            bw.flush();
            bw.close();
            return;
        }

        long result = matrixFibo(matrix, n - 1)[0][0];
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    private static long[][] matrixFibo(long[][] mat, long exp) {
        if (exp == 0 || exp == 1) {
            return mat;
        }

        long[][] result = matrixFibo(mat, exp / 2);
        result = multiply(result, result);
        if (exp % 2 != 0) {
            result = multiply(result, matrix);
        }

        return result;
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[2][2];

        result[0][0] = (a[0][0] * b[0][0] + a[1][0] * b[0][1]) % MOD;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;

        return result;
    }
}
