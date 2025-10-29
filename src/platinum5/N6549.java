package platinum5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class N6549 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] height;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while (!(str = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            long maxArea = getArea();
            bw.write(maxArea + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static long getArea() {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int preHeight = height[stack.pop()];
                long width = stack.isEmpty() ? i : i - 1 - stack.peek();

                maxArea = Math.max(maxArea, preHeight * width);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = height[stack.pop()];
            long width = stack.isEmpty() ? height.length : height.length - 1 - stack.peek();

            maxArea = Math.max(maxArea, curHeight * width);
        }

        return maxArea;
    }
}
