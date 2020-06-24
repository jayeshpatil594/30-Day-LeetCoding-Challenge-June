//DP
class Solution {
    public int numTrees(int n) {
        //Time : O(n ^ 2) Space: O(n)
        int dp[] = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}

//recursion + memo
/*class Solution {
    public int numTrees(int n) {
        //Time : O(n ^ 2) Space : O(n)
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        if(n == 0 || n == 1){
            return 1;
        }
        for(int i = 1; i <= n; i++){
            if(!map.containsKey(i - 1)){
                map.put(i - 1, numTrees(i - 1));
            }
            if(!map.containsKey(n - i)){
                map.put(n - i, numTrees(n - i));
            }
            res += map.get(i - 1) * map.get(n - i);
        }
        return res;
    }
}*/

//recursion
/*class Solution {
    public int numTrees(int n) {
        //Time: O(n * n!)
        int res = 0;
        if(n == 0 || n == 1){
            return 1;
        }
        for(int i = 1; i <= n; i++){
            res += numTrees(i - 1) * numTrees(n - i);
        }
        return res;
    }
}*/

