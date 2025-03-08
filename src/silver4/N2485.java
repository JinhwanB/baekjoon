package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2485 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int tree = Integer.parseInt(br.readLine());
            arr[i] = tree;
        }
        br.close();

        int gcd = 0;
        for (int i = 0; i < n - 1; i++) {
            int distance = arr[i + 1] - arr[i];
            gcd = getGcd(Math.max(gcd, distance), Math.min(gcd, distance));
        }

        int result = (arr[n - 1] - arr[0]) / gcd + 1 - arr.length;
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    private static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return getGcd(b, a % b);
    }

}
