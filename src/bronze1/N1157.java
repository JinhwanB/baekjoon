package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class N1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split("");
        Map<String, Integer> map = new HashMap<>();

        int max = 0;
        for (String s : arr) {
            String word = s.toUpperCase();
            int cnt = map.getOrDefault(word, 0);
            map.put(word, cnt + 1);
            max = Math.max(cnt + 1, max);
        }

        List<String> list = new ArrayList<>();
        for (Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value == max) {
                list.add(key);
            }
        }

        if (list.size() > 1) {
            bw.write("?");
        } else {
            bw.write(list.get(0));
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
