package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class N5622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = br.readLine().toCharArray();

        for (char c = 'A'; c <= 'Z'; c++) {
            int ac = c - 65;

            if (ac <= 2) {
                map.put(c, 3);
                continue;
            }

            if (ac <= 5) {
                map.put(c, 4);
                continue;
            }

            if (ac <= 8) {
                map.put(c, 5);
                continue;
            }

            if (ac <= 11) {
                map.put(c, 6);
                continue;
            }

            if (ac <= 14) {
                map.put(c, 7);
                continue;
            }

            if (ac <= 18) {
                map.put(c, 8);
                continue;
            }

            if (ac <= 21) {
                map.put(c, 9);
                continue;
            }

            map.put(c, 10);
        }

        int sum = 0;
        for (char c : arr) {
            sum += map.get(c);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }

}
