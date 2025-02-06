package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N24313 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fn1 = Integer.parseInt(st.nextToken());
        int fn2 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int gn = Integer.parseInt(br.readLine());
        br.close();

        int num1 = fn1 * gn + fn2;
        int num2 = c * gn;
        if (num1 <= num2 && c >= fn1) {
            bw.write("1");
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
    }

}
