package silver2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 노드의 개수

        LinkedList<Integer>[] list = new LinkedList[N + 1]; // 노드 연결 관계 저장
        for (int i = 1; i <= N; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisit = new boolean[N + 1]; // 방문 여부
        int[] result = new int[N + 1]; // 부모 노드 저장

        queue.add(1);
        isVisit[1] = true;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();

            for (Integer item : list[poll]) {
                if(!isVisit[item]){
                    isVisit[item] = true;
                    result[item] = poll;
                    queue.add(item);
                }
            }
        }

        for (int i = 2; i < result.length; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
