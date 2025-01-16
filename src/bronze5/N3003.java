package bronze5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N3003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] chess = {1, 1, 2, 2, 2, 8};

        for (int i : chess) {
            int nowCnt = Integer.parseInt(st.nextToken());
            bw.write(i - nowCnt + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
