package bronze5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N14681 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if(x > 0 && y > 0){
            bw.write("1");
        }

        if(x > 0 && y < 0){
            bw.write("4");
        }

        if(x < 0 && y > 0){
            bw.write("2");
        }

        if(x < 0 && y < 0){
            bw.write("3");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
