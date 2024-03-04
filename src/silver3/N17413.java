package silver3;

import java.util.Scanner;
import java.util.Stack;

public class N17413 {

    private static String S;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        S = sc.nextLine();

        System.out.println(solve());
        sc.close();
    }

    private static String solve() {
        StringBuilder result = new StringBuilder(); // 최종 출력할 문자열
        boolean flag = true; // 여는 태그와 닫는 태그 구분
        Stack<Character> stack = new Stack<>(); // 단어 뒤집기 위한 stack

        for(int i = 0; i < S.length(); i++){
            Character c = S.charAt(i);

            if(c == '<'){ // 여는 태그일 때
                while(!stack.isEmpty()){ // 스택이 비어있지 않다면
                    result.append(stack.pop()); // 스택에서 하나씩 뺀다
                }
                flag = false;
            }else if(c == '>'){ // 닫는 태그일 때
                result.append(c); // 닫는 태그를 result에 붙인다.
                flag = true;
                continue; // 닫는 태그('>')가 스택에 들어가는 것 방지
            }

            if(flag){ // 태그가 아닌 문자열 상태일 때
                if(c == ' '){ // 공백일 때
                    while(!stack.isEmpty()){
                        result.append(stack.pop());
                    }
                    result.append(c); // 공백을 result에 붙인다.
                }else{ // 공백이 아닐 때
                    stack.push(c); // 스택에 넣는다
                }
            }else{ // 태그 안의 문자열일 때
                result.append(c); // result에 붙인다.
            }

            if(i == S.length() - 1){ // S의 마지막 문자열일 때
                while(!stack.isEmpty()){ // 스택 안에 문자가 남아있다면 모두 뺀다.
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }
}
