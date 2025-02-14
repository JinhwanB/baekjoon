package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N18870 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        // 정렬을 위한 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        // key: 입력받은 숫자, value: 입력받은 숫자보다 작은 수의 갯수
        Map<Integer, Integer> map = new HashMap<>();

        // 입력받은 순서대로 출력하기 위한 배열
        int[] cnt = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());
            pq.add(new int[]{val, i}); // 입력받은 수와 순서를 배열로 우선순위 큐에 저장
        }
        br.close();

        int count = 0; // 더 작은 수의 갯수 (작은 순서대로 정렬이 되어있기에 하나씩 증가시키면 됨)
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            if (map.getOrDefault(poll[0], -1) != -1) { // 이미 count된 숫자인 경우
                cnt[poll[1]] = map.get(poll[0]);
                continue;
            }

            map.put(poll[0], count);
            cnt[poll[1]] = count;
            count++;
        }

        for (int j = 1; j < cnt.length; j++) {
            int i = cnt[j];
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();

    }

}
