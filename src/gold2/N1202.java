package gold2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1202 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 보석 수
        int k = Integer.parseInt(st.nextToken()); // 가방 수

        Jewel[] jewels = new Jewel[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 보석 무게
            int v = Integer.parseInt(st.nextToken()); // 보석 가격
            jewels[i] = new Jewel(m, v);
        }
        Arrays.sort(jewels, (o1, o2) -> {
            if (o1.m < o2.m) {
                return -1;
            } else if (o1.m > o2.m) {
                return 1;
            }

            return 0;
        });

        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            int w = Integer.parseInt(br.readLine());
            bags[i] = w;
        }
        br.close();
        Arrays.sort(bags);

        PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> {
            if (o2.v < o1.v) {
                return -1;
            } else if (o2.v > o1.v) {
                return 1;
            }

            return 0;
        });
        int index = 0;
        long max = 0;
        for (int i = 0; i < k; i++) {
            while (index < n && bags[i] >= jewels[index].m) {
                pq.offer(jewels[index]);
                index++;
            }

            if (!pq.isEmpty()) {
                max += pq.poll().v;
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    static class Jewel {

        int m;
        int v;

        Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
