package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 지름
public class N1967 {

    static int n;
    static List<List<int[]>> tree;
    static boolean[] visited;
    static int[] answer = new int[]{0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            tree.get(parent).add(new int[]{child, dist});
            tree.get(child).add(new int[]{parent, dist});
        }

        br.close();

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, 0);
            Arrays.fill(visited, false);
        }

        bw.write(answer[1] + "");
        bw.close();
    }

    private static void dfs(int s, int dist) {
        for (int[] node : tree.get(s)) {
            if (!visited[node[0]]) {
                visited[node[0]] = true;
                dfs(node[0], dist + node[1]);
            }
        }

        if (dist > answer[1]) {
            answer = new int[]{s, dist};
        }
    }
}
