package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N15649 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (m == 1) {
            for (int i = 1; i <= n; i++) {
                bw.write(i + "\n");
            }

            bw.flush();
            bw.close();
            return;
        }

        visit = new boolean[n];
        arr = new int[m];
        dfs(0);

        bw.flush();
        bw.close();
    }

    private static void dfs(int depth) throws IOException {
        if (depth == m) {
            for (int i : arr) {
                bw.write(i + " ");
            }

            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

}
