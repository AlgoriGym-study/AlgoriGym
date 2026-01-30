package Algorithm_Study.daily.YHS.D202601;

public class D20260130_지폐접기 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (true) {
            int walletBigger = Math.max(wallet[0], wallet[1]);
            int walletSmaller = Math.min(wallet[0], wallet[1]);
            int billBigger = Math.max(bill[0], bill[1]);
            int billSmaller = Math.min(bill[0], bill[1]);

            if (walletBigger >= billBigger && walletSmaller >= billSmaller) break;
            else {
                if (bill[0] > bill[1])
                    bill[0] /= 2;
                else bill[1] /= 2;
                answer++;
            }
        }

        return answer;
    }
}
