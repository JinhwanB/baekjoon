package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class N1181 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }

            return o1.length() - o2.length();
        });

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            if (set.add(s)) {
                pq.add(s);
            }
        }
        br.close();

        while (!pq.isEmpty()) {
            String cur = pq.poll();

            bw.write(cur + "\n");
        }

        bw.flush();
        bw.close();
    }

}
