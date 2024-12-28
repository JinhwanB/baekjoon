package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        String[] split = String.valueOf(b).split("");

        for (int i = split.length - 1; i >= 0; i--) {
            int num = Integer.parseInt(split[i]);
            bw.write(a * num + "\n");
        }

        bw.write(String.valueOf(a * b));
        bw.flush();

        bw.close();
        br.close();
    }
}
