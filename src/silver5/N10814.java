package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N10814 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<String[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
            }

            return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
        });

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            pq.add(new String[]{s1, s2, String.valueOf(i)});
        }
        br.close();

        while (!pq.isEmpty()) {
            String[] poll = pq.poll();

            bw.write(poll[0] + " " + poll[1] + "\n");
        }

        bw.flush();
        bw.close();
    }

}
