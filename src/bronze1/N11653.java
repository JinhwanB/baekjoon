package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N11653 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            bw.write("");
        } else {
            while (n > 1) {
                for (int i = 2; i <= n; i++) {
                    if (n % i == 0) {
                        n /= i;
                        bw.write(i + "\n");
                        break;
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
