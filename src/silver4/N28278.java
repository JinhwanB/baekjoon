package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class N28278 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.startsWith("1")) {
                int num = Integer.parseInt(str.split(" ")[1]);

                stack.add(num);
                continue;
            }

            if (str.equals("2")) {
                if (!stack.isEmpty()) {
                    int val = stack.pop();
                    bw.write(val + "\n");
                    continue;
                }

                bw.write("-1\n");
                continue;
            }

            if (str.equals("3")) {
                bw.write(stack.size() + "\n");
                continue;
            }

            if (str.equals("4")) {
                if (stack.isEmpty()) {
                    bw.write("1\n");
                    continue;
                }

                bw.write("0\n");
                continue;
            }

            if (!stack.isEmpty()) {
                bw.write(stack.peek() + "\n");
                continue;
            }

            bw.write("-1\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
