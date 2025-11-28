package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 두 수의 합
public class N3273 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());
        br.close();

        int s = 0;
        int e = n - 1;

        while (s < e) {
            int res = arr[s] + arr[e];

            if (res > x) {
                e--;
                continue;
            }

            if (res < x) {
                s++;
                continue;
            }

            cnt++;
            s++;
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}
