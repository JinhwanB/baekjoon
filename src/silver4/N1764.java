package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class N1764 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n + m; i++) {
            String name = br.readLine();
            if (!set.add(name)) {
                list.add(name);
            }
        }
        br.close();

        list.sort(Comparator.naturalOrder());
        bw.write(list.size() + "\n");
        for (String s : list) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }

}
