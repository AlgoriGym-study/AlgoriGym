package Algorithm_Study.daily.CSY.March;

import java.util.HashMap;
import java.util.Map;

public class D20250310_숫자문자열과_영단어 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        String s = "one4seveneight";

        while(s.matches(".*[a-zA-Z]+.*")) {
            if (s.contains("one")) {
                s = s.replace("one", "1");
            } else if (s.contains("two")) {
                s = s.replace("two", "2");
            } else if (s.contains("three")) {
                s = s.replace("three", "3");
            } else if (s.contains("four")) {
                s = s.replace("four", "4");
            } else if (s.contains("five")) {
                s = s.replace("five", "5");
            } else if (s.contains("six")) {
                s = s.replace("six", "6");
            } else if (s.contains("seven")) {
                s = s.replace("seven", "7");
            } else if (s.contains("eight")) {
                s = s.replace("eight", "8");
            } else if (s.contains("nine")) {
                s = s.replace("nine", "9");
            } else if (s.contains("zero")) {
                s = s.replace("zero", "0");
            }
        }

//        s = s.replaceAll("one", "1")
//                .replaceAll("two", "2")
//                    .replaceAll("three", "3")
//                        .replaceAll("four", "4")
//                            .replaceAll("five", "5")
//                                .replaceAll("six", "6")
//                                    .replaceAll("seven", "7")
//                                        .replaceAll("eight", "8")
//                                            .replaceAll("nine", "9");


        System.out.println(s);




    }
}
