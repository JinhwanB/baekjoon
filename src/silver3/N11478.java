package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class N11478 {

    static BufferedReader br;
    static BufferedWriter bw;
    static String s;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = br.readLine();
        br.close();

        Set<String> set = new HashSet<>();
        int a = 0;
        while (a < s.length()) {
            StringBuilder str = new StringBuilder();
            for (int i = a; i < s.length(); i++) {
                str.append(s.charAt(i));
                set.add(str.toString());
            }
            a++;
        }

        bw.write(set.size() + "");
        bw.flush();
        bw.close();
    }

}
