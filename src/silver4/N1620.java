package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N1620 {

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
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            nameMap.put(name, i);
            numMap.put(i, name);
        }

        for (int i = 0; i < m; i++) {
            String key = br.readLine();
            int num = nameMap.getOrDefault(key, 0);

            if (num == 0) {
                String name = numMap.get(Integer.parseInt(key));
                bw.write(name + "\n");
                continue;
            }

            bw.write(num + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }

}
