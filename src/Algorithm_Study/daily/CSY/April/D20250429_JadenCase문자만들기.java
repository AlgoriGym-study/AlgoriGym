package Algorithm_Study.daily.CSY.April;

public class D20250429_JadenCase문자만들기 {
    public static void main(String[] args) {
        String s = "3people unFollowed me";

        System.out.println(Solution(s));

    }
    static String Solution(String s){

        StringBuilder sb = new StringBuilder();
        boolean isStart = true; // 첫 번째 문자는 무조건 대문자

        for(char c : s.toCharArray()){
            if(isStart){
                sb.append(Character.toUpperCase(c));
            }else {
                sb.append(Character.toLowerCase(c));
            }

            isStart = (c == ' '); // 공백이 나오면 다음 문자는 대문자가 되어야 함. 즉, true로 바꿔줘야 함.
        }

        return sb.toString();

    }
}
