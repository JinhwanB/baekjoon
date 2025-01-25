package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2581 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = 0;
        loop:
        for (int i = m; i <= n; i++) {
            if (i == 1) {
                continue;
            }

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue loop;
                }
            }

            sum += i;

            if (min == 0) {
                min = i;
            }
        }

        if (sum == 0) {
            bw.write("-1");
        } else {
            bw.write(sum + "\n" + min);
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

}
