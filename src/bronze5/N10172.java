package bronze5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class N10172 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("|\\_/|" + "\n");
        bw.write("|q p|   /}" + "\n");
        bw.write("( 0 )\"\"\"\\" + "\n");
        bw.write("|\"^\"`    |" + "\n");
        bw.write("||_/=\\\\__|");
        bw.flush();
        bw.close();
    }
}
