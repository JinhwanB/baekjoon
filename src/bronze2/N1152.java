package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N1152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().trim();
        if (str.isEmpty()) {
            bw.write("0");
        } else {
            String[] arr = str.split(" "); // 앞 뒤 공백 제거 후 공백 기준으로 배열화
            bw.write(String.valueOf(arr.length));
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
