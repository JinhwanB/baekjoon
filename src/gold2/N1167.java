package gold2;

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
public class N1167 {

    static BufferedReader br;
    static BufferedWriter bw;
    static List<List<int[]>> trees;
    static boolean[] visited;
    static int[] maxNode = {0, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(br.readLine());
        trees = new ArrayList<>();
        visited = new boolean[v + 1];

        for (int i = 0; i <= v; i++) {
            trees.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e;

            while ((e = Integer.parseInt(st.nextToken())) != -1) {
                int d = Integer.parseInt(st.nextToken());
                trees.get(s).add(new int[]{e, d});
            }
        }

        br.close();

        visited[1] = true;
        dfs(1, 0);

        Arrays.fill(visited, false);

        visited[maxNode[0]] = true;
        dfs(maxNode[0], 0);

        bw.write(maxNode[1] + "");
        bw.close();
    }

    private static void dfs(int s, int dis) {
        for (int[] node : trees.get(s)) {
            if (!visited[node[0]]) {
                visited[node[0]] = true;
                dfs(node[0], dis + node[1]);
            }
        }

        if (maxNode[1] < dis) {
            maxNode = new int[]{s, dis};
        }
    }
}
