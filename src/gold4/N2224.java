package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 명제 증명
public class N2224 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 명제의 수
        arr = new int[123][123];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " => ");
            int a = st.nextToken().charAt(0);
            int b = st.nextToken().charAt(0);
            arr[a][b] = 1;
        }
        br.close();

        for (int k = 'A'; k <= 'z'; k++) {
            for (int i = 'A'; i <= 'z'; i++) {
                for (int j = 'A'; j <= 'z'; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        int cnt = 0;
        List<String> resList = new ArrayList<>();
        for (int i = 'A'; i <= 'z'; i++) {
            for (int j = 'A'; j <= 'z'; j++) {
                if (i == j) {
                    continue;
                }

                if (arr[i][j] == 1) {
                    cnt++;
                    resList.add(((char) i) + " => " + ((char) j));
                }
            }
        }

        bw.write(cnt + "\n");

        for (String s : resList) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }
}
