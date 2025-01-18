package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2783 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];

        for (int i = 0; i < arr1.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr1[0].length; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr2[0].length; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int result = arr1[i][j] + arr2[i][j];
                bw.write(result + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
