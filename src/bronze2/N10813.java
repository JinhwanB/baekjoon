package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class N10813 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        IntStream.range(1, arr.length).forEach(idx -> {
            arr[idx] = idx;
        });

        for (int l = 0; l < m; l++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        for (int i = 1; i < arr.length; i++) {
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
