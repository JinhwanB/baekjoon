package gold1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 트리의 순회
public class N2263 {

    static BufferedReader br;
    static BufferedWriter bw;
    static List<Integer> inorder;
    static List<Integer> postorder;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        inorder = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
        postorder = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());

        br.close();

        freeOrder(0, n - 1, 0, n - 1);

        bw.flush();
        bw.close();
    }

    private static void freeOrder(int inStartIdx, int inEndIdx, int postStartIdx, int postEndIdx) throws IOException {
        if ((inStartIdx > inEndIdx) || (postStartIdx > postEndIdx)) {
            return;
        }

        int root = postorder.get(postEndIdx);
        bw.write(root + " ");

        int inorderIdx = inorder.indexOf(root);
        int left = inorderIdx - inStartIdx;
        freeOrder(inStartIdx, inorderIdx - 1, postStartIdx, postStartIdx + left - 1);
        freeOrder(inorderIdx + 1, inEndIdx, postStartIdx + left, postEndIdx - 1);
    }
}
