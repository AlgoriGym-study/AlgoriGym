package Algorithm_Study.daily.CSY.April;

    import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class D20250406_모의고사 {
        static int[] one = {1, 2, 3, 4, 5};
        static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        public static void main(String[] args) {
            int[] answers = {1, 2, 3, 4, 5, 1, 3};
//		int[] answers = {1, 3, 2, 4, 2};
            int size = answers.length;
            int a = 0, b = 0, c = 0;
            int idx = 0, max = 0;
            for(int i = 0; i < size; i++) {
                idx = i % one.length;
                if(answers[i] == one[idx]) a++;

                idx = i % two.length;
                if(answers[i] == two[idx]) b++;

                idx = i % three.length;
                if(answers[i] == three[idx]) c++;
            }
            max = Math.max(a, Math.max(c, b));
            List<Integer> list = new ArrayList<>();

            if(max == a) list.add(1);
            if(max == b) list.add(2);
            if(max == c) list.add(3);

            int[] ans = list.stream().mapToInt(Integer :: intValue).toArray();
            System.out.println(Arrays.toString(ans));
        }

    }
