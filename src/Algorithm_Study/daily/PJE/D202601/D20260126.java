package Algorithm_Study.daily.PJE.D202601;

public class D20260126 {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        for(int[] query : queries){
            int start = query[0];
            int end = query[1];
            StringBuilder reversed = new StringBuilder(sb.substring(start, end+1)).reverse();
            sb.replace(start,end+1,reversed.toString());
        }
        return sb.toString();
    }
//     public String solution(String my_string, int[][] queries) {
//         char[] arr = my_string.toCharArray();
        
//         for (int[] query : queries) {
//             int start = query[0];
//             int end = query[1];
            
//             // 핵심: 중간까지만 스왑
//             while (start < end) {
//                 char temp = arr[start];
//                 arr[start] = arr[end];
//                 arr[end] = temp;
//                 start++;
//                 end--;
//             }
//         }
        
//         return new String(arr);
//     }
}
