class Solution {
    public int change(int amount, int[] coins) {
        //Since we only need data from i - 1 row to fill ith row.
        // DP - Space optimised
        // Time : O(n * amount) Space :(amount)
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for(int j = 0; j < coins.length; j++){
            for(int i = 1; i <= amount; i++){
                //if current coin is samller than amount 
                if(coins[j] <= i){
                    dp[i] = dp[i] + dp[i - coins[j]];
                }
            }
        }
        return dp[amount];
    }
}

/*
    //DP- 2D Time : O(n * amount) Space : O(n * amount)
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        
        for(int j = 1; j <= coins.length; j++){
            dp[j][0] = 1;
            for(int i = 1; i <= amount; i++){
                dp[j][i] = dp[j - 1][i];
                //if current coin is samller than amount 
                if(coins[j  -1] <= i){
                    dp[j][i] = dp[j][i] + dp[j][i - coins[j - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}*/

/*
    Recursion + memo
    Time : O(n * amount)
    Space : O(n * amount)
class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        if(coins.length == 0) return 0;
        Integer[][] dp = new Integer[coins.length + 1][amount + 1];
        return totalWays(amount, coins, 0, dp);
    }
    public int totalWays(int amount, int[] coins, int index, Integer[][] dp){
        if(amount == 0){
            return 1;
        }
        if(index == coins.length || amount < 0){
            return 0;
        }
        if(dp[index][amount] != null){
            return dp[index][amount];
        }
        // ways to change if ith use current coin , we dont increment i as we might use this same coin again
        int x = totalWays(amount - coins[index], coins, index, dp);
        // total ways to change if ith dont use current coin , 
        // amount remains same but since we are not selecting this coin, then we must increment i
        int y = totalWays(amount, coins, index + 1, dp);
        dp[index][amount] = x + y;
        return dp[index][amount];
    }
}*/

/*
    //Recursion 
    //Time : Exponential O(2 ^ n)
class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        if(coins.length == 0) return 0;
        return totalWays(amount, coins, 0);
    }
    public int totalWays(int amount, int[] coins, int index){
        if(amount == 0){
            return 1;
        }
        if(index == coins.length || amount < 0){
            return 0;
        }
        // ways to change if ith use current coin , we dont increment i as we might use this same coin again
        int x = totalWays(amount - coins[index], coins, index);
        // total ways to change if ith dont use current coin , 
        // amount remains same but since we are not selecting this coin, then we must increment i
        int y = totalWays(amount, coins, index + 1);
        return x + y;
    }
}*/
