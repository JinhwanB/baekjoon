package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N17103 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static boolean[] primeCheck = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        findPrime();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int count = 0;

            for (int j = 2; j <= num / 2; j++) {
                if (!primeCheck[j] && !primeCheck[num - j]) {
                    count++;
                }
            }

            bw.write(count + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void findPrime() {
        primeCheck[0] = primeCheck[1] = true;

        for (int i = 2; i < primeCheck.length; i++) {
            if (!primeCheck[i]) {
                for (int j = 2; i * j < primeCheck.length; j++) {
                    primeCheck[i * j] = true;
                }
            }
        }
    }

}
