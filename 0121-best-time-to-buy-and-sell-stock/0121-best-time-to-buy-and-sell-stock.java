class Solution {
    public int maxProfit(int[] prices) {
        int min_price = prices[0];
        int max_profit =0;

        for(int i =1;i<prices.length; i++){
            if(prices[i]<min_price){
                min_price=prices[i];
            }else{
                max_profit = Math.max(max_profit,prices[i]-min_price);
            }
        }
        return max_profit;
    }
}