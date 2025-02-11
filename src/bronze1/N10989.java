package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N10989 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        int[] cnt = new int[10001];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            cnt[num]++;
        }
        br.close();

        for (int i = 1; i < cnt.length; i++) {
            while (cnt[i] > 0) {
                bw.write(i + "\n");
                cnt[i]--;
            }
        }
        bw.flush();
        bw.close();
    }

}
