package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N15650 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        br.close();

        if (m == 1) {
            for (int i = 1; i <= n; i++) {
                bw.write(i + "\n");
            }

            bw.flush();
            bw.close();
            return;
        }

        visited = new boolean[n];
        arr = new int[m];

        bfs(0);

        bw.flush();
        bw.close();
    }

    private static void bfs(int depth) throws IOException {
        if (depth == m) {
            for (int i : arr) {
                bw.write(i + " ");
            }

            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                arr[depth] = i + 1;
                visited[i] = true;
                if (depth > 0 && arr[depth] < arr[depth - 1]) {
                    visited[i] = false;
                    continue;
                }

                bfs(depth + 1);
                visited[i] = false;
            }
        }
    }

}
