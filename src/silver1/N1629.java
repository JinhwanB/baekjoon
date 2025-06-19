package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1629 {

    static BufferedWriter bw;
    static long a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        br.close();

        long pow = pow(a, b);

        bw.write(pow + "");
        bw.flush();
        bw.close();
    }

    private static long pow(long a, long b) {
        if (b == 1) {
            return a % c;
        }

        long val = pow(a, b / 2);

        if (b % 2 == 1) {
            return (val * val % c) * a % c;
        }

        return val * val % c;
    }

}
