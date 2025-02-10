package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int num = 666;
        int count = 1;
        while (count != n) {
            num++;

            String str = String.valueOf(num);
            if (str.contains("666")) {
                count++;
            }
        }

        bw.write(num + "");
        bw.flush();
        bw.close();
    }

}
