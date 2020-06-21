//Bottom-up DP
//Time: O(m * n)
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];
        for (int i = 0; i < m + 1; i++) {
			dp[i][n] = Integer.MAX_VALUE;
		}
		for (int j = 0; j < n + 1; j++) {
			dp[m][j] = Integer.MAX_VALUE;
		}
        dp[m][n-1] = 0;
        dp[m-1][n] = 0;
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 0);
            }
        }
        return dp[0][0] + 1;
    }
}

/*
//Recursion + memo  (Top - down)
//Time: O(n * m)
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] memo = new int[dungeon.length][dungeon[0].length];
        for(int i = 0; i < dungeon.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return minHealthReq(dungeon, 0, 0, memo);
    }
    public int minHealthReq(int[][] dungeon, int i, int j, int[][] memo){
        if(i == dungeon.length - 1 && j == dungeon[0].length - 1){
            return dungeon[i][j] > 0 ? 1 : Math.abs(dungeon[i][j]) + 1;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(i == dungeon.length - 1 || j == dungeon[0].length - 1){
            return memo[i][j] = i == dungeon.length - 1 ? 
                        Math.max(1, minHealthReq(dungeon, i , j+ 1, memo) - dungeon[i][j]) : 
                        Math.max(1, minHealthReq(dungeon, i + 1, j, memo) - dungeon[i][j]);
        }
        return memo[i][j] = Math.max(1, Math.min(Math.max(1, minHealthReq(dungeon, i , j+ 1, memo) - dungeon[i][j]), 
                                    Math.max(1, minHealthReq(dungeon, i + 1, j, memo) - dungeon[i][j])));
    }
}
*/

/*
//brute force : Recursion
//Time : Exponential
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        return minHealthReq(dungeon, 0, 0);
    }
    public int minHealthReq(int[][] dungeon, int i, int j){
        //base case
        if(i == dungeon.length - 1 && j == dungeon[0].length - 1){
            return dungeon[i][j] > 0 ? 1 : Math.abs(dungeon[i][j]) + 1;
        }
        if(i == dungeon.length - 1 || j == dungeon[0].length - 1){
            return i == dungeon.length - 1 ? 
                        Math.max(1, minHealthReq(arr, i , j+ 1) - dungeon[i][j]) : 
                        Math.max(1, minHealthReq(arr, i + 1, j) - dungeon[i][j]);
        }
        return Math.max(1, Math.min(Math.max(1, minHealthReq(arr, i , j+ 1) - dungeon[i][j]), 
                                    Math.max(1, minHealthReq(arr, i + 1, j) - dungeon[i][j])));
    }
}
*/
