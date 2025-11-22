package gold2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N2696 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수

        while (t-- > 0) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int m = Integer.parseInt(br.readLine());
            int midCnt = (m + 1) / 2;
            bw.write(midCnt + "\n");

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int num = Integer.parseInt(st.nextToken());

                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }

                if (!minHeap.isEmpty()) {
                    if (maxHeap.peek() > minHeap.peek()) {
                        int n1 = maxHeap.poll();
                        int n2 = minHeap.poll();

                        maxHeap.offer(n2);
                        minHeap.offer(n1);
                    }
                }

                if (i % 2 == 0) {
                    if (cnt == 9 || i == m - 1) {
                        bw.write(maxHeap.peek() + "\n");
                        cnt = 1;
                        continue;
                    }

                    bw.write(maxHeap.peek() + " ");
                    cnt++;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
