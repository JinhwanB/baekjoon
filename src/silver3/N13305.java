package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N13305 {

    static BufferedWriter bw;
    static int n;
    static int[] oil, road;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        road = new int[n - 1];
        oil = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        long result = 0;
        long minCost = oil[0];
        for (int i = 0; i < n - 1; i++) {
            minCost = Math.min(minCost, oil[i]);

            result += (minCost * road[i]);
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

}
