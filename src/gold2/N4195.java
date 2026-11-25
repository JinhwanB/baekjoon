package gold2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 친구 네트워크
public class N4195 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] parent;
    static int[] level;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int i = 0; i < t; i++) {
            int f = Integer.parseInt(br.readLine()); // 각 케이스별 친구 관계의 수
            parent = new int[f * 2];
            level = new int[f * 2];

            for (int j = 0; j < f * 2; j++) {
                parent[j] = j;
                level[j] = 1;
            }

            int idx = 0;
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < f; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!map.containsKey(name1)) {
                    map.put(name1, idx++);
                }

                if (!map.containsKey(name2)) {
                    map.put(name2, idx++);
                }

                bw.write(union(map.get(name1), map.get(name2)) + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
            level[a] += level[b];
        }

        return level[a];
    }
}
