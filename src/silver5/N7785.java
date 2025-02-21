package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class N7785 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String val = st.nextToken();

            if (val.equals("leave")) {
                set.remove(key);
                continue;
            }

            set.add(key);
        }
        br.close();

        List<String> list = new ArrayList<>(set);
        list.sort((o1, o2) -> o2.compareTo(o1));
        for (String s : list) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }

}
