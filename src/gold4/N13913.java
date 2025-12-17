package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 숨바꼭질 4
public class N13913 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, k;
    static int[] time = new int[100001];
    static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        k = Integer.parseInt(st.nextToken()); // 동생의 위치
        br.close();

        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int idx = k;

        while (idx != n) {
            stack.push(parent[idx]);
            idx = parent[idx];
        }

        bw.write(time[k] + "\n");

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        time[n] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = now + 1;
                } else if (i == 1) {
                    next = now - 1;
                } else {
                    next = now * 2;
                }

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (time[next] == 0) {
                    q.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }
        }
    }
}
