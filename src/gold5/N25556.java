package gold5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class N25556 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> a = new ArrayList<>();
        ArrayList<Stack<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            stacks.add(new Stack<>());
        } // 4개의 스택 구현

        int N = Integer.parseInt(br.readLine()); // 수열의 크기
        boolean isYes = false; // 정렬이 가능한지 여부 판단

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        /*
          각 스택에 수를 넣기 전에 가장 위에있는 수와 비교하여 현재 넣고자 하는 수가 더 큰 경우에만 넣는다.
          처음 넣은 값이 가장 마지막에 나온다 즉, 나중에 넣은 수가 가장 처음 나오는 스택의 특징을 생각해보면
          문제에서 꺼낸 수들을 오른쪽에서 왼쪽으로 나열한다 하였기에 정렬이 되도록 나열하려면 peek 했을 시 큰 수부터 작은 수 순으로 나와야 한다.
         */
        for (int aNum : a) {
            for (Stack<Integer> stack : stacks) {
                isYes = false;

                if (stack.isEmpty()) { // 비어있는 스택일 시 그냥 넣는다.
                    stack.push(aNum);
                    isYes = true;
                    break;
                }

                int peek = stack.peek();

                if (aNum > peek) { // 비어있지 않다면 스택의 위에 있는 수가 현재 비교할 수보다 작은경우에만 스택에 넣는다
                    stack.push(aNum);
                    isYes = true;
                    break;
                }
            }

            if (!isYes) { // 위에서 수가 스택에 들어간 경우 true로 바꿔주었기에 false인 상태라면 수가 들어가지 않았으므로 정렬을 진행할 수 없다.
                break;
            }
        }

        if(isYes){
            bw.write("YES");
        }else{
            bw.write("NO");
        }

        bw.flush();
        bw.close();
    }
}
