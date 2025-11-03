package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2110 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int c;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 집의 수
        c = Integer.parseInt(st.nextToken()); // 공유기 수

        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(houses);

        if (c == 2) {
            bw.write(houses[n - 1] - houses[0] + "");
            bw.flush();
            bw.close();
            return;
        }

        if (c == n) {
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        }

        int min = 0;
        int max = houses[n - 1] - houses[0] + 1;
        while (min < max) {
            int mid = (min + max) / 2;

            int cnt = 1;
            int lastInstall = houses[0];
            for (int i = 1; i < n; i++) {
                int curLocate = houses[i];

                if (Math.abs(curLocate - lastInstall) >= mid) {
                    cnt++;
                    lastInstall = curLocate;
                }
            }

            if (cnt < c) {
                max = mid;
                continue;
            }

            min = mid + 1;
        }

        bw.write(min - 1 + "");
        bw.flush();
        bw.close();
    }
}
