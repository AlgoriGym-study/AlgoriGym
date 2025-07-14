package Algorithm_Study.common.C202507.C20250716;

public class KMR0033 {

    public int solution(int[] priorities, int location) {
        int[] sorted = new int[priorities.length];
        int sIdx = 0;
        int nIdx = 0;
        boolean[] checked = new boolean[priorities.length];

        while (sIdx < priorities.length) {
            int maxPriority = -1;
            int maxIdx = -1;


            for (int i = nIdx; i < priorities.length; i++) {
                if(priorities[i] > maxPriority && !checked[i]) {
                    maxIdx = i;
                    maxPriority = priorities[i];
                }
            }

            for (int i = 0; i < nIdx; i++) {
                if(priorities[i] > maxPriority && !checked[i]) {
                    maxIdx = i;
                    maxPriority = priorities[i];
                }
            }

            if(maxIdx == location) {
                return sIdx + 1;
            }

            checked[maxIdx] = true;
            sorted[sIdx++] = maxIdx;
            nIdx = ++maxIdx % priorities.length;

            while (checked[nIdx]) {
                nIdx = ++nIdx % priorities.length;
            }


        }// while

        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            if(sorted[i] == location) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }
}
