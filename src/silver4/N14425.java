package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N14425 {

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
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, 1);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            count += map.getOrDefault(s, 0);
        }
        br.close();

        bw.write(count + "");
        bw.flush();
        bw.close();
    }

}
