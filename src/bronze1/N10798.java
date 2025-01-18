package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] arr = new char[5][15];
        for (char[] chars : arr) {
            Arrays.fill(chars, ' ');
        }

        for (char[] value : arr) {
            char[] cArr = br.readLine().toCharArray();
            System.arraycopy(cArr, 0, value, 0, cArr.length);
        }

        for (int i = 0; i < arr[0].length; i++) {
            for (char[] chars : arr) {
                char c = chars[i];
                if (c == ' ') {
                    continue;
                }

                bw.write(c);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
