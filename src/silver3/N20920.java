package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N20920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            int i = map.get(o1);
            int j = map.get(o2);
            if (i == j) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }

                return o2.length() - o1.length();
            }

            return j - i;
        });

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() < m) {
                continue;
            }

            int cnt = map.getOrDefault(s, 0);
            map.put(s, cnt + 1);
        }
        br.close();

        pq.addAll(map.keySet());

        while (!pq.isEmpty()) {
            String s = pq.poll();
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }

}
