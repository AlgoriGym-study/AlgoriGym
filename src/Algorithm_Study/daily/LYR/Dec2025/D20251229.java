package Algorithm_Study.daily.LYR.Dec2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D20251229 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 666;
        int count = 1;

        while(count != N){
            num++;
            if(String.valueOf(num).contains("666"))
                count++;
        }

        System.out.println(num);

    }
}
