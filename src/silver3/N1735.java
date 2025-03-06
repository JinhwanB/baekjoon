package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1735 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int a;
    static int b;
    static int c;
    static int d;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        br.close();

        int gcd = getGcd(Math.max(b, d), Math.min(b, d));
        int denominator = b * d / gcd;
        int numerator = a * (denominator / b) + c * (denominator / d);

        gcd = getGcd(Math.max(denominator, numerator), Math.min(denominator, numerator));

        bw.write(numerator / gcd + " " + denominator / gcd);
        bw.flush();
        bw.close();
    }

    private static int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return getGcd(b, a % b);
    }

}
