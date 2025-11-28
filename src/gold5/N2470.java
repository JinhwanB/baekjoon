package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 두 용액
public class N2470 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int r1, r2, res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);
        int s = 0, e = n - 1;

        while (s < e) {
            int result = arr[s] + arr[e];

            if (Math.abs(result) < res) {
                res = Math.abs(result);
                r1 = arr[s];
                r2 = arr[e];
            }

            if (result > 0) {
                e--;
                continue;
            }

            s++;
        }

        bw.write(r1 + " " + r2);
        bw.flush();
        bw.close();
    }
}
