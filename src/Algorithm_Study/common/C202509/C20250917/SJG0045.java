package Algorithm_Study.common.C202509.C20250917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SJG0045 {
    static int n;
    static int[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inputs = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputs);

        int left = 1;
        int right = inputs[n - 1];
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (solve(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    // check시간으로 문제를 해결하는 간격을 만들 수 있는지 확인
    // check, check*2, check*3... 시간에 문제를 끝내는 시간을 맞추는것으로 확인한다
    // check시간 이하에 풀 수 있는 문제를 1블록으로 생각한다
    // 첫번째 문제 해결 이후 stack_block에는 1(하나의 블록크기)이 쌓여있어야 하고
    // 다음부터 문제를 풀때 stack_block에는 해당 문제 블록 - 1개가 쌓여 있도록 save_block에 저장된 블록을 빼서 해결한다
    public static boolean solve(int check) {
        int saveBlock = 0;
        int stackBlock = 0;

        for (int i = 0; i < inputs.length; i++) {
            // 첫번째 문제일때
            if (i == 0) {
                // 제일 작은 문제를 해결하지 못할때
                if (inputs[i] > check) {
                    return false;
                } else {
                    stackBlock++; // 1블록짜리가 하나 쌓이게 된다
                }
                continue;
            }

            // 문제 자체가 check시간 이하로 걸릴때 (한 블록으로 해결될때)
            // 해당 문제는 무조건 풀 수 있으므로 해당 블록을 저장해 놓는다
            if (inputs[i] <= check) {
                saveBlock++; // 해당 문제를 하나의 블록으로 저장해 놓는다 (필요할때 빼서 쓸 수 있음)
                continue;
            }

            // 두개 이상의 블록으로 해결이 될때
            int thisBlock = (inputs[i] / check);

            if (inputs[i] % check != 0) { // 해당 문제 시간이 check로 나누어 떨어지지 않을때
                thisBlock++;
            }

            // thisBlock을 해결하기 위해서는 stackBlock을 thisBlock - 1개로 만들수 있어야 한다
            // stackBlock을 thisBlock - 1개로 만들 수 있을때
            if (stackBlock + saveBlock >= thisBlock - 1) {
                // stackBlock을 thisBlock - 1로 만드는데 필요한 블록의 양
                int needBlock = (thisBlock - 1) - stackBlock;

                saveBlock -= needBlock;
                stackBlock += needBlock;

                stackBlock = (thisBlock - stackBlock); // stackBlock이 1이 된다
            }
            // stackBlock을 thisBlock - 1개로 만들 수 없을때
            else {
                return false;
            }
        }
        return true;
    }
}
