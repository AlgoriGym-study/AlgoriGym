package Algorithm_Study.common.C202508.C20250806;

public class SJG0038_2 {
    public static void main(String[] args) {
        String s = "111222333444555666777888999000";
        int result = findLargestCoolNum(s);
        System.out.println(result); // Expected output: 999
    }
    
    public static int findLargestCoolNum(String s) {
    int max = -1;
    if (s.length() < 3) return -1;

    for (int i = 0; i + 2 < s.length(); i++) { // 마지막 윈도우 포함
        char c = s.charAt(i);
        if (c == s.charAt(i + 1) && c == s.charAt(i + 2)) {
            int val = (c - '0') * 111; // "000" -> 0, "777" -> 777
            if (val == 999) return 999; // 최댓값이면 즉시 종료
            if (val > max) max = val;
        }
    }
    return max;
}
}
