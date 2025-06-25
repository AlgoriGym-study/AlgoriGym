package Algorithm_Study.common.C202506.C20250618;

public class SJG0024 {
    static int[] discountRate = new int[] {10, 20, 30, 40}; // 할인율리스트
    static int maxPlus = 0; // 이모티콘 플러스 서비스 가입자 최대 수
    static int maxPay = 0; // 최대 판매액
    
    static int[][] userList;
    static int[] emoticonList;
    static int N;
    
    public int[] solution(int[][] users, int[] emoticons) {
        userList = users;
        emoticonList = emoticons;
        int[] discountRateList = new int[emoticons.length];
        N = emoticons.length;
        
        // 재귀를 활용한 완전탐색(브루트포스)
        recurDiscount(0, discountRateList);
        
        return new int[] {maxPlus, maxPay};
    }
    
    // 완전탐색 + 재귀
    private void recurDiscount(int idx, int[] discountRateList) {
        // 완전탐색으로 모든 이모티콘의 할인율이 지정되었을 때
        if(idx == N) {
            // 결과 연산
            calcResult(emoticonList, discountRateList, userList);
            return;
        }
        
        for(int rate : discountRate) {
            discountRateList[idx] = rate;
            recurDiscount(idx + 1, discountRateList);
        }
    }
    
    private void calcResult(int[] emoticonList, int[] discountRateList, int[][] userList) {
        int plus = 0;   // 플러스 가입
        int pay = 0;    // 구매
        
        for(int[] user : userList) {
            int userMinDiscountRate = user[0];  // 해당 비율 이상인 이모티콘은 모두 구매
            int userMaxCanPay = user[1];    // 해당 가격을 넘어서면 이모티콘 플러스 서비스 가입
            int userPay = 0;    // 유저가 지불한 값
            
            // 사용자가 구매할 이모티콘 총액
            for(int i = 0; i < N; i++) {
                if(discountRateList[i] >= userMinDiscountRate) {
                    userPay += emoticonList[i] * (100 - discountRateList[i]) / 100;
                }
            }
            
            // 플러스 가입 혹은 이모티콘 구매 확정
            if(userPay >= userMaxCanPay) plus++;
            else pay += userPay;
        }
        
        if(plus > maxPlus) {
            maxPlus = plus;
            maxPay = pay;
        } else if(plus == maxPlus && pay > maxPay) maxPay = pay;
    }
}
