package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 운동
public class N1956 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int v, e;
    static int[][] arr;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken()); // 마을 수
        e = Integer.parseInt(st.nextToken()); // 도로의 수
        arr = new int[v + 1][v + 1];

        for (int i = 1; i <= v; i++) {
            Arrays.fill(arr[i], INF);
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = c;
        }
        br.close();

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int res = INF;

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (arr[i][j] != INF && arr[j][i] != INF) {
                        res = Math.min(res, arr[i][j] + arr[j][i]);
                    }
                }
            }
        }

        bw.write((res == INF ? -1 : res) + "");
        bw.flush();
        bw.close();
    }
}
