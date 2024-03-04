package silver3;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int idx = queue.indexOf(num); // 구하고자 하는 숫자가 위치한 인덱스

            while(true) {
                if(idx <= queue.size() / 2){ // 해당 인덱스가 현재 큐에서 중앙보다 왼쪽에 있는 경우
                    int peek = queue.peek(); // 앞쪽부터 확인한다.
                    if (peek != num) { // 해당 숫자가 아니라면
                        queue.addLast(queue.poll()); // 앞에서 뺀 데이터를 뒤로 보내는 연산을 하고
                        count++; // 연산 횟수를 증가시킨다
                    } else { // 숫자를 찾은 경우
                        queue.poll(); // 해당 숫자를 제거
                        break;
                    }
                }else{ // 해당 인덱스가 현재 큐에서 중앙보다 오른쪽에 있는 경우
                    int peek = queue.peekLast(); // 뒤에서부터 확인한다
                    if(peek != num){ // 찾는 숫자가 아닌 경우
                        queue.offerFirst(queue.pollLast()); // 뒤에서 뺀 데이터를 앞쪽으로 옮기는 연산 진행
                        count++; // 연산 횟수 증가
                    }else{ // 수를 찾은 경우
                        queue.offerFirst(queue.pollLast()); // 찾은 숫자는 뒤에 위치해 있으므로 앞으로 옮긴다. (문제에서 앞에서 빼도록 한다고 되있음)
                        count++; // 연산 횟수 증가
                        queue.poll(); // 찾은 숫자 제거
                        break;
                    }
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
