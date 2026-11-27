package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 전력난
public class N6497 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 집의 수
            int n = Integer.parseInt(st.nextToken()); // 길의 수

            if (m == 0 && n == 0) {
                break;
            }

            List<Road> list = new ArrayList<>();
            parent = new int[m];
            int answer = 0;

            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                list.add(new Road(x, y, z));
            }

            list.sort(Comparator.comparingInt(x -> x.z));

            for (Road road : list) {
                if (find(road.x) == find(road.y)) {
                    answer += road.z;

                    continue;
                }

                union(road.x, road.y);
            }

            bw.write(answer + "\n");
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

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                parent[b] = a;

                return;
            }

            parent[a] = b;
        }
    }

    private static class Road {

        int x, y, z;

        public Road(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
