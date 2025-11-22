package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 바이러스
public class N2606 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수

        List<List<Integer>> computers = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            computers.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            computers.get(u).add(v);
            computers.get(v).add(u);
        }
        br.close();

        boolean[] checked = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int cnt = 0;
        while (!q.isEmpty()) {
            int computer = q.poll();
            if (!checked[computer]) {
                checked[computer] = true;
                cnt++;
                q.addAll(computers.get(computer));
            }
        }

        bw.write(cnt - 1 + "");
        bw.flush();
        bw.close();
    }
}
