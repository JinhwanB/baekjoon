package gold4;

import java.io.*;
import java.util.PriorityQueue;

public class N1715 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 1000의 묶음 크기의 데이터가 100000개 있을 시 int 데이터 크기 초과이므로 long
        PriorityQueue<Long> queue = new PriorityQueue<>(); // 우선순위큐 사용
        for(int i = 0; i < N; i++){
            queue.offer(Long.parseLong(br.readLine()));
        }

        long result = 0; // 최종 출력값

        /**
         * 우선순위 큐를 사용한 이유
         * 작은 값이 우선으로 나와 연산이 되어야 결과가 최소값이 된다
         */
        while(queue.size() > 1){
            long poll1 = queue.poll();
            long poll2 = queue.poll();

            long sum = poll1 + poll2;

            result += poll1 + poll2;
            queue.offer(sum);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
