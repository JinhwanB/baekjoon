public class Main {

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }

    public static String solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < arr.length; i++) {
            if(s.contains(arr[i])){
                s = s.replace(arr[i], String.valueOf(i));
            }
        }

        return s;
    }
}