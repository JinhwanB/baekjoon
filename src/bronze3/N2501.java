package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int result = 0;
        if (k == 1) {
            bw.write(String.valueOf(1));
        } else {
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    cnt++;
                }

                if (k == cnt) {
                    result = i;
                    break;
                }
            }
            bw.write(String.valueOf(result));
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
