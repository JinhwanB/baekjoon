package gold4;

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

// 트리
public class N4803 {

    static BufferedReader br;
    static BufferedWriter bw;
    static List<List<Integer>> tree;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseCount = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 노드 수
            int m = Integer.parseInt(st.nextToken()); // 간선 수
            int treeCount = 0;

            if (n == 0 && m == 0) {
                break;
            }

            tree = new ArrayList<>();
            parent = new int[n + 1];
            visited = new boolean[n + 1];

            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                tree.get(s).add(e);
                tree.get(e).add(s);
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    parent[i] = i;
                    boolean isTree = dfs(i);

                    if (isTree) {
                        treeCount++;
                    }
                }
            }

            switch (treeCount) {
                case 0 -> bw.write("Case " + caseCount + ": No trees.\n");
                case 1 -> bw.write("Case " + caseCount + ": There is one tree.\n");
                default -> bw.write("Case " + caseCount + ": A forest of " + treeCount + " trees.\n");
            }

            caseCount++;
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean dfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean flag = true;

        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : tree.get(current)) {
                if (visited[next]) {
                    if (parent[current] != next) {
                        flag = false;
                    }
                } else {
                    visited[next] = true;
                    q.offer(next);
                    parent[next] = current;
                }
            }
        }

        return flag;
    }
}
