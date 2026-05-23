class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            if(profit>maxProfit){
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
//Approach      | Time  | Space | Result
// Brute Force   | O(n²) | O(1)  | TLE on large input
// Optimized     | O(n)  | O(1)  | Accepted 
class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                
                int profit = prices[j] - prices[i];
                
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}