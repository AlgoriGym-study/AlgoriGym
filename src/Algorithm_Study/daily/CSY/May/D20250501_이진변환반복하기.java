package Algorithm_Study.daily.CSY.May;

public class D20250501_이진변환반복하기 {

    public int[] solution(String s) {


        String result = s; // 이진 결과
        int sum = 0; // 제거한 0의 개수 누적합
        int count = 0; // 몇 번 변환했는지


        while(!result.equals("1")){
            char[] arr = result.toCharArray();
            int cnt = 0;
            for(char c : arr){
                if(c == '0') cnt++;
            }
            sum += cnt;
            int needToChange = arr.length - cnt;

            result = Integer.toBinaryString(needToChange);
            count++;
        }
        System.out.println(sum);


        int[] answer = {count, sum};
        return answer;
    }


}