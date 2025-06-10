package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2559 {

    static BufferedWriter bw;
    static int n;
    static int k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int max = Integer.MIN_VALUE;
        int idx = 0;
        while (idx + k - 1 < n) {

            int sum = 0;
            for (int i = idx; i < idx + k; i++) {
                sum += arr[i];
            }

            max = Math.max(max, sum);
            idx++;
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

}
