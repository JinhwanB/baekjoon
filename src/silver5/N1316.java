package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class N1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        roop:
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            char[] arr = br.readLine().toCharArray();

            for (int j = 0; j < arr.length; j++) {
                char c = arr[j];
                int idx = map.getOrDefault(c, -1);

                if (idx != -1 && j - idx > 1) {
                    continue roop;
                }

                map.put(c, j);
            }

            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

}
