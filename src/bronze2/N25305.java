package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N25305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            pq.add(score);
        }

        int count = 0;
        int result = 0;
        while (count != k && !pq.isEmpty()) {
            int curS = pq.poll();
            count++;

            result = curS;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

}
