package gold2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N12015 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 수열 크기
        int[] a = new int[n];
        int[] lis = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        lis[0] = a[0];
        int lisLength = 1;
        for (int i = 1; i < n; i++) {
            int num = a[i];

            if (lis[lisLength - 1] < num) {
                lis[lisLength] = num;
                lisLength++;
                continue;
            }

            int min = 0;
            int max = lisLength;
            while (min < max) {
                int mid = (min + max) / 2;

                if (lis[mid] < num) {
                    min = mid + 1;
                    continue;
                }

                max = mid;
            }

            lis[min] = num;
        }

        bw.write(lisLength + "");
        bw.flush();
        bw.close();
    }
}
