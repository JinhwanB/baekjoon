package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class N9506 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        while ((n = Integer.parseInt(br.readLine())) != -1) {
            int sum = 0;
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                    q.offer(i);
                }
            }

            if (n == sum) {
                bw.write(n + " = ");
                while (q.size() > 1) {
                    int num = q.poll();
                    bw.write(num + " + ");
                }
                bw.write(q.poll() + "\n");
            } else {
                bw.write(n + " is NOT perfect.\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
