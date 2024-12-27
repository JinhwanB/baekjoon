package bronze5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N18108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int y = Integer.parseInt(br.readLine());
        int bulToSeo = 2541 - 1998;

        int answer = y - bulToSeo;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
