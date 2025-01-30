package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N5073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        loop:
        while (!(str = br.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(str);
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            pq.add(n1);
            pq.add(n2);
            pq.add(n3);

            // Equilateral :  세 변의 길이가 모두 같은 경우
            // Isosceles : 두 변의 길이만 같은 경우
            // Scalene : 세 변의 길이가 모두 다른 경우
            // 단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다.
            while (!pq.isEmpty()) {
                int max = pq.poll();
                int next1 = pq.poll();
                int next2 = pq.poll();

                if (max >= next1 + next2) {
                    bw.write("Invalid\n");
                    continue loop;
                }
            }

            if (n1 == n2 && n2 == n3) {
                bw.write("Equilateral\n");
            } else {
                if (n1 == n2 || n2 == n3 || n1 == n3) {
                    bw.write("Isosceles\n");
                } else {
                    bw.write("Scalene\n");
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
