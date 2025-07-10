public class StockBuyandSellMaxoneTransactionAllowed {
    public static void main(String[] args) {
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(function1(prices));
    }

    public static int function1(int[] prices){
        try{
            // TC: O(N^2)
            // int maxprofit = 0;
            // int len_ = prices.length;
            // for(int i=0;i<len_;i++){
            //     for(int j=i;j<len_;j++){
            //         maxprofit = Math.max(maxprofit, prices[j] - prices[i]);
            //     }
            // }   
            // return maxprofit;

            // TC: O(N)

            int maxprofit = 0;
            int minsofar = prices[0];
            for(int i=1;i<prices.length;i++){
                minsofar = Math.min(minsofar, prices[i]);
                maxprofit = Math.max(maxprofit, prices[i] - minsofar);
            }
            return maxprofit;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
