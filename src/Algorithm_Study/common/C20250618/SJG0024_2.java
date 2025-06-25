package Algorithm_Study.common.C20250618;

public class SJG0024_2 {
    private static final int[] DISCOUNT_RATES = {10, 20, 30, 40};
    private int maxPlusSubscribers = 0;
    private int maxSalesAmount = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 즉시 계산 방식 사용
        generateAndCalculate(0, new int[emoticons.length], users, emoticons);
        return new int[]{maxPlusSubscribers, maxSalesAmount};
    }
    
    private void generateAndCalculate(int index, int[] discountRates, 
                                    int[][] users, int[] emoticons) {
        if (index == emoticons.length) {
            // 조합 완성 즉시 계산
            calculateResult(discountRates, users, emoticons);
            return;
        }
        
        for (int rate : DISCOUNT_RATES) {
            discountRates[index] = rate;
            generateAndCalculate(index + 1, discountRates, users, emoticons);
        }
    }
    
    private void calculateResult(int[] discountRates, int[][] users, int[] emoticons) {
        int plusCount = 0;
        int totalSales = 0;
        
        for (int[] user : users) {
            int userTotal = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (discountRates[i] >= user[0]) {
                    userTotal += emoticons[i] * (100 - discountRates[i]) / 100;
                }
            }
            
            if (userTotal >= user[1]) {
                plusCount++;
            } else {
                totalSales += userTotal;
            }
        }
        
        if (plusCount > maxPlusSubscribers || 
            (plusCount == maxPlusSubscribers && totalSales > maxSalesAmount)) {
            maxPlusSubscribers = plusCount;
            maxSalesAmount = totalSales;
        }
    }
}
