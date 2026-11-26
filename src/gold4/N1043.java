package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 거짓말
public class N1043 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] parent;
    static List<Integer> trueMember;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티의 수
        parent = new int[n + 1];
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        int trueCount = Integer.parseInt(st.nextToken());
        trueMember = new ArrayList<>();
        List<Set<Integer>> party = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i <= m; i++) {
            party.add(new HashSet<>());
        }

        if (trueCount == 0) {
            answer = m;
        } else {
            for (int i = 0; i < trueCount; i++) {
                int member = Integer.parseInt(st.nextToken());
                trueMember.add(member);
            }
        }

        for (int i = 0; i < m; i++) {
            int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            if (array[0] == 1) {
                party.get(i).add(array[1]);
                continue;
            }

            for (int j = 1; j < array[0]; j++) {
                int joiner1 = array[j];
                int joiner2 = array[j + 1];
                union(joiner1, joiner2);

                if (j == 1) {
                    party.get(i).add(joiner1);
                    party.get(i).add(joiner2);

                    continue;
                }

                party.get(i).add(joiner2);
            }
        }

        br.close();

        if (answer != 0) {
            bw.write(answer + "");
            bw.flush();
            bw.close();

            return;
        }

        for (int i = 0; i < m; i++) {
            Set<Integer> set = party.get(i);
            boolean isTrueParty = false;

            for (int joiner : set) {
                if (trueMember.contains(find(joiner))) {
                    isTrueParty = true;
                    break;
                }
            }

            if (!isTrueParty) {
                answer++;
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
            if (trueMember.contains(a)) {
                parent[b] = a;
                parent[a] = a;

                return;
            }

            if (trueMember.contains(b)) {
                parent[a] = b;
                parent[b] = b;

                return;
            }

            if (a < b) {
                parent[b] = a;

                return;
            }

            parent[a] = b;
        }
    }
}
