package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// DSLR
public class N9019 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int t;
    static int cnt = Integer.MAX_VALUE;
    static String ans = "";

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            boolean[] flag = new boolean[10000];
            String[] command = new String[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Arrays.fill(command, "");
            bfs(a, b, flag, command);
            bw.write(command[b] + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }

    private static void bfs(int a, int b, boolean[] flag, String[] command) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        flag[a] = true;

        while (!q.isEmpty() && !flag[b]) {
            int now = q.poll();

            int D = (now * 2) % 10000;
            int S = now == 0 ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now % 10) * 1000 + now / 10;

            if (!flag[D]) {
                q.add(D);
                flag[D] = true;
                command[D] = command[now] + "D";
            }

            if (!flag[S]) {
                q.add(S);
                flag[S] = true;
                command[S] = command[now] + "S";
            }

            if (!flag[L]) {
                q.add(L);
                flag[L] = true;
                command[L] = command[now] + "L";
            }

            if (!flag[R]) {
                q.add(R);
                flag[R] = true;
                command[R] = command[now] + "R";
            }
        }
    }
}
