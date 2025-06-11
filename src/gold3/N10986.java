package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N10986 {

    static BufferedWriter bw;
    static int n, m;
    static long[] cnt, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = new long[m];
        sum = new long[n];

        long result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum[i] = Integer.parseInt(st.nextToken());
                continue;
            }

            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }
        br.close();

        for (int i = 0; i < n; i++) {
            int remain = (int) (sum[i] % m);
            if (remain == 0) {
                result++;
            }

            cnt[remain]++;
        }

        for (int i = 0; i < m; i++) {
            long count = cnt[i];
            result += (count * (count - 1) / 2);
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

}
