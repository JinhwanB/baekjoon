package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        n = Integer.parseInt(st.nextToken()); // 집 수
        c = Integer.parseInt(st.nextToken()); // 와이파이 수

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
    }
}
