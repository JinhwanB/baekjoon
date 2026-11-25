package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 이진 검색 트리
public class N5639 {

    static BufferedReader br;
    static BufferedWriter bw;
    static List<Integer> preorder;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        preorder = new ArrayList<>();
        while (true) {
            String str = br.readLine();

            if (str == null || str.isEmpty()) {
                break;
            }

            int num = Integer.parseInt(str);
            preorder.add(num);
        }

        br.close();

        postorder(0, preorder.size() - 1);

        bw.flush();
        bw.close();
    }

    private static void postorder(int start, int end) throws IOException {
        if (start > end) {
            return;
        }

        int root = preorder.get(start);
        int mid = start + 1;

        while (mid <= end && preorder.get(mid) < root) {
            mid++;
        }

        postorder(start + 1, mid - 1);
        postorder(mid, end);

        bw.write(root + "\n");
    }
}
