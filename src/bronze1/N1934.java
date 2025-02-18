package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1934 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int gcd = getGcd(Math.max(num1, num2), Math.min(num1, num2));
            int result = (num1 * num2) / gcd;
            bw.write(result + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }

    private static int getGcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }

        return getGcd(num2, num1 % num2);
    }

}
