package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2563 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] paper = new int[100][100];
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int endX = startX + 10;
            int startY = Integer.parseInt(st.nextToken());
            int endY = startY + 10;

            for (int j = startY; j < endY; j++) {
                for (int k = startX; k < endX; k++) {
                    if (paper[j][k] == 1) {
                        continue;
                    }

                    paper[j][k] = 1;
                }
            }
        }

        int result = 0;
        for (int[] paperArr : paper) {
            for (int i : paperArr) {
                if (i == 1) {
                    result++;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

}
