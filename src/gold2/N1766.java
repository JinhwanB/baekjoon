package gold2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 문제집
public class N1766 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 문제의 수
        int m = Integer.parseInt(st.nextToken()); // 먼저 푸는 곳이 좋은 문제에 대한 정보의 개수
        List<List<Integer>> list = new ArrayList<>();
        int[] indegrees = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            indegrees[b]++;
        }
        br.close();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int num = pq.poll();
            bw.write(num + " ");

            for (Integer i : list.get(num)) {
                indegrees[i]--;

                if (indegrees[i] == 0) {
                    pq.offer(i);
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
