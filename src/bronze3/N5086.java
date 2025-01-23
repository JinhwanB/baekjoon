package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N5086 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        while (!str.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a > b) {
                if (isMultiple(a, b)) {
                    bw.write("multiple\n");
                    str = br.readLine();
                    continue;
                }
            }

            if (a < b) {
                if (isFactor(a, b)) {
                    bw.write("factor\n");
                    str = br.readLine();
                    continue;
                }
            }

            bw.write("neither\n");
            str = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isFactor(int a, int b) {
        return b % a == 0;
    }

    public static boolean isMultiple(int a, int b) {
        return a % b == 0;
    }

}
