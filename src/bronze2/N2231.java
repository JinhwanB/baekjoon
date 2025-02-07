package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;
        for (int i = 1; i < n; i++) {
            int sum = i;
            String[] arr = String.valueOf(i).split("");
            for (String s : arr) {
                sum += Integer.parseInt(s);
            }

            if (sum == n) {
                result = i;
                break;
            }
        }

        if (result == 0) {
            bw.write(0 + "");
        } else {
            bw.write(result + "");
        }

        bw.flush();
        bw.close();
    }

}
