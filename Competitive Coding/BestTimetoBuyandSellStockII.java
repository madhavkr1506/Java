public class BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(function1(prices));
    }

    public static int function1(int[] prices){
        try{
            int maxprofit = 0;
            for(int i=1;i<prices.length;i++){
                int profit = prices[i] - prices[i-1];
                if (profit > 0){
                    maxprofit += profit;
                }

            }
            return maxprofit;

        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
