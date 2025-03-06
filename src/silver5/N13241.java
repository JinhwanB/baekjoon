package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N13241 {

    static BufferedReader br;
    static BufferedWriter bw;
    static long n;
    static long m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        br.close();

        long gcd = getGcd(Math.max(n, m), Math.min(n, m));
        long result = n * m / gcd;

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    private static long getGcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }

        return getGcd(b, a % b);
    }

}
