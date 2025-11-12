package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 알고리즘 수업 - 깊이 우선 탐색 1
public class N24479 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int cnt;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        List<List<Integer>> graphs = new ArrayList<>();
        int[] checked = new int[n + 1];

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
            Collections.sort(graphs.get(i));
        }

        cnt = 1;
        dfs(graphs, checked, r);

        for (int i = 1; i < checked.length; i++) {
            bw.write(checked[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(List<List<Integer>> graphs, int[] checked, int r) {
        checked[r] = cnt;

        for (int i = 0; i < graphs.get(r).size(); i++) {
            int newNode = graphs.get(r).get(i);
            if (checked[newNode] == 0) {
                cnt++;
                dfs(graphs, checked, newNode);
            }
        }
    }
}
