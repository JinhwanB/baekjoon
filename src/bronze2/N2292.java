package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        int rangeStart = 2;

        if (n == 1) {
            bw.write(String.valueOf(1));
        } else {
            while (n >= rangeStart) {
                rangeStart += (cnt * 6);
                cnt++;
            }
            bw.write(String.valueOf(cnt));
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
