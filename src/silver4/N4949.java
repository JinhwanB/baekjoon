package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class N4949 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        loop:
        while (!(s = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '[') {
                    stack.add(c);
                    continue;
                }

                if (c == ')') {
                    if (stack.isEmpty()) {
                        bw.write("no\n");
                        continue loop;
                    }

                    char pop = stack.pop();
                    if (pop != '(') {
                        bw.write("no\n");
                        continue loop;
                    }
                }

                if (c == ']') {
                    if (stack.isEmpty()) {
                        bw.write("no\n");
                        continue loop;
                    }

                    char pop = stack.pop();
                    if (pop != '[') {
                        bw.write("no\n");
                        continue loop;
                    }
                }
            }

            if (stack.isEmpty()) {
                bw.write("yes\n");
                continue;
            }

            bw.write("no\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
