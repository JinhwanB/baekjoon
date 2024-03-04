package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }
        sb.append("<"); // 출력 형식 맞추기 "<..,..,..>"

        while(queue.size() != 1){
            for(int i = 0; i < K - 1; i++){
                int poll = queue.poll();
                queue.offer(poll); // K번째 수가 아닌 수들은 삭제하면 안되므로 다시 큐에 넣는다.
            }
            sb.append(queue.poll()).append(", "); // K번째 수
        }

        sb.append(queue.poll()).append(">"); // 마지막으로 큐에 남아 있는 수
        System.out.println(sb);
    }
}
