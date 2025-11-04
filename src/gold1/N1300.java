package gold1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N1300 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 배열 크기
        k = Integer.parseInt(br.readLine());
        br.close();

        long min = 1;
        long max = k;
        while (min < max) {
            long mid = (min + max) / 2;

            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if (k <= count) {
                max = mid;
                continue;
            }

            min = mid + 1;
        }

        bw.write(min + "");
        bw.flush();
        bw.close();
    }
}
