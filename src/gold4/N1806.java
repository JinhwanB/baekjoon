package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 부분합
public class N1806 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, s;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 수열의 길이
        s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] >= s) {
                br.close();
                bw.write(1 + "");
                bw.flush();
                bw.close();
                return;
            }
        }
        br.close();

        int start = 0;
        int end = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;

        while (start <= end && end <= n) {
            if (sum < s) {
                sum += arr[end++];
                continue;
            }

            res = Math.min(res, end - start);
            sum -= arr[start++];
        }

        bw.write((res == Integer.MAX_VALUE ? 0 : res) + "");
        bw.flush();
        bw.close();
    }
}
