package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 나만 안되는 연애
public class N14621 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학교의 수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int[] schools = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            String s = st.nextToken();
            if (s.equals("M")) {
                schools[i] = 1;
                continue;
            }

            schools[i] = 2;
        }

        List<Road> roads = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int sexS = schools[s];
            int sexE = schools[e];
            int c = Integer.parseInt(st.nextToken());
            roads.add(new Road(sexS, sexE, s, e, c));
            roads.add(new Road(sexE, sexS, e, s, c));
        }

        br.close();

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        roads.sort(Comparator.comparingInt(x -> x.c));
        int answer = 0;
        int curSexE = 0;
        for (Road road : roads) {
            if (find(road.s) == find(road.e)) {
                continue;
            }

            if (curSexE == 0 && road.sexE != road.sexS) {
                answer += road.c;
                curSexE = road.sexE;
                union(road.s, road.e);
                continue;
            }

            if (curSexE != 0 && road.sexE != road.sexS && curSexE != road.sexS) {
                answer += road.c;
                curSexE = road.sexE;
                union(road.s, road.e);
            }
        }

        for (int i = 1; i <= n; i++) {
            parent[i] = find(i);
        }

        int val = parent[1];
        for (int i = 2; i <= n; i++) {
            if (val != parent[i]) {
                answer = -1;
                break;
            }
        }

        bw.write(answer + "");
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

        int sexS, sexE, s, e, c;

        public Road(int sexS, int sexE, int s, int e, int c) {
            this.sexS = sexS;
            this.sexE = sexE;
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }
}
