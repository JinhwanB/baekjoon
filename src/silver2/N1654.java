package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1654 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];

        long min = 0;
        long max = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        max++;
        br.close();

        long mid;
        while (min < max) {
            mid = (min + max) / 2;
            long count = 0;

            for (int i : arr) {
                count += i / mid;
            }

            if (count >= n) {
                min = mid + 1;
                continue;
            }

            max = mid;
        }

        bw.write(min - 1 + "");
        bw.flush();
        bw.close();
    }
}
