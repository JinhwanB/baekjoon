package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N4134 {

    static BufferedReader br;
    static BufferedWriter bw;
    static long n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Long.parseLong(br.readLine());

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());

            if (num == 0 || num == 1 || num == 2) {
                bw.write(2 + "\n");
                continue;
            }

            while (true) {
                int cnt = 0;
                for (int j = 2; j <= Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        cnt++;
                        break;
                    }
                }

                if (cnt == 0) {
                    break;
                }

                num++;
            }

            bw.write(num + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
