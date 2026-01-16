package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// n단 논법
public class N15723 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[123][123];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char[] charArray = s.toCharArray();
            int a = charArray[0];
            int b = charArray[charArray.length - 1];

            arr[a][b] = 1;
        }

        for (int k = 'a'; k <= 'z'; k++) {
            for (int i = 'a'; i <= 'z'; i++) {
                for (int j = 'a'; j <= 'z'; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            char[] charArray = s.toCharArray();
            int a = charArray[0];
            int b = charArray[charArray.length - 1];

            if (arr[a][b] == 1) {
                bw.write("T\n");
                continue;
            }

            bw.write("F\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
