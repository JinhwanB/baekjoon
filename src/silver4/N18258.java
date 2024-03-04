package silver4;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N18258 {

    static Deque<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            switch (str) {
                case "push" -> {
                    int value = Integer.parseInt(st.nextToken());
                    push(value);
                }
                case "pop" -> bw.write(pop() + "\n");
                case "size" -> bw.write(size() + "\n");
                case "empty" -> bw.write(empty() + "\n");
                case "front" -> bw.write(front() + "\n");
                case "back" -> bw.write(back() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void push(int X){
        queue.offer(X);
    }

    private static int pop(){
        return queue.isEmpty() ? -1 : queue.poll();
    }

    private static int size(){
        return queue.size();
    }

    private static int empty(){
        return queue.isEmpty() ? 1 : 0;
    }

    private static int front(){
        return queue.isEmpty() ? -1 : queue.peek();
    }

    private static int back(){
        return queue.isEmpty() ? -1 : queue.getLast();
    }
}
