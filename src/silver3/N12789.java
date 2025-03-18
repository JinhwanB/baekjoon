package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class N12789 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            q.add(num);
        }

        int turn = 1;
        while (!q.isEmpty()) {
            int qPeek = q.peek();

            if (qPeek == turn) {
                turn++;
                q.poll();
                continue;
            }

            if (!stack.isEmpty()) {
                int sPeek = stack.peek();
                if (sPeek == turn) {
                    stack.pop();
                    turn++;
                    continue;
                }
            }

            stack.add(q.poll());
        }

        String result = "Nice";
        while (!stack.isEmpty()) {
            int peek = stack.peek();
            if (peek == turn) {
                stack.pop();
                turn++;
                continue;
            }

            result = "Sad";
            break;
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }

}
