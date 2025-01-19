package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2745 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] n = st.nextToken().toCharArray();
        int b = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 0; i < n.length; i++) {
            char c = n[i];
            int num = 0;
            if (c >= 'A' && c <= 'Z') {
                num = c - 55;
            } else {
                num = c - '0';
            }

            result += (int) (num * Math.pow(b, n.length - 1 - i));
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

}
