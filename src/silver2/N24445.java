package silver2;

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

// 알고리즘 수업 - 너비 우선 탐색 2
public class N24445 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        List<List<Integer>> graphs = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graphs.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graphs.get(u).add(v);
            graphs.get(v).add(u);
        }
        br.close();

        for (int i = 1; i <= n; i++) {
            graphs.get(i).sort((o1, o2) -> o2 - o1);
        }

        int[] checked = new int[n + 1];
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(r);

        while (!q.isEmpty()) {
            int newNode = q.poll();
            if (checked[newNode] == 0) {
                checked[newNode] = cnt;
                cnt++;
                q.addAll(graphs.get(newNode));
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(checked[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
