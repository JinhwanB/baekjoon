package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int sum = 0;
        for (int i = 0; i <= n - 3; i++) {
            int v1 = cards[i];

            for (int j = i + 1; j < n - 1; j++) {
                int v2 = cards[j];

                for (int k = j + 1; k < n; k++) {
                    int v3 = cards[k];
                    int result = v1 + v2 + v3;

                    if (result <= m) {
                        sum = Math.max(sum, result);
                    }
                }
            }

            if (sum == m) {
                break;
            }
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
    }

}
