package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class N28279 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.startsWith("1")) {
                StringTokenizer st = new StringTokenizer(command);
                command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                deque.addFirst(num);
                continue;
            }

            if (command.startsWith("2")) {
                StringTokenizer st = new StringTokenizer(command);
                command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                deque.addLast(num);
                continue;
            }

            if (command.startsWith("3")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                    continue;
                }

                int frontNum = deque.pollFirst();
                bw.write(frontNum + "\n");
                continue;
            }

            if (command.startsWith("4")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                    continue;
                }

                int lastNum = deque.pollLast();
                bw.write(lastNum + "\n");
                continue;
            }

            if (command.startsWith("5")) {
                int count = deque.size();

                bw.write(count + "\n");
                continue;
            }

            if (command.startsWith("6")) {
                if (deque.isEmpty()) {
                    bw.write("1\n");
                    continue;
                }

                bw.write("0\n");
                continue;
            }

            if (command.startsWith("7")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                    continue;
                }

                int firstNum = deque.peekFirst();
                bw.write(firstNum + "\n");
                continue;
            }

            if (deque.isEmpty()) {
                bw.write("-1\n");
                continue;
            }

            int lastNum = deque.peekLast();
            bw.write(lastNum + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
