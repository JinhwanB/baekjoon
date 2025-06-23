package gold1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N11401 {

    static BufferedWriter bw;
    static long n, k;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());

        long num = factorial(n);
        long deno = factorial(k) * factorial(n - k) % MOD;

        bw.write(num * pow(deno, MOD - 2) % MOD + "");
        bw.flush();
        bw.close();
    }

    private static long factorial(long num) {
        long val = 1L;
        while (num > 0) {
            val = val * num % MOD;
            num--;
        }

        return val;
    }

    private static long pow(long base, int exp) {
        if (exp == 1) {
            return base % MOD;
        }

        long temp = pow(base, exp / 2);

        if (exp % 2 == 1) {
            return (temp * temp % MOD) * base % MOD;
        }

        return temp * temp % MOD;
    }

}
