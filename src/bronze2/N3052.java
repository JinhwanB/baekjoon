package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class N3052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            int last = num % 42;
            s.add(last);
        }

        bw.write(String.valueOf(s.size()));
        bw.flush();
        bw.close();
        br.close();
    }

}
