class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //Time : O(n ^ 2) + O(nlogn) => O(n ^ 2)
        //Space : O(n) + O(n) => O(n)
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] parent = new int[nums.length];
        Arrays.fill(parent, -1);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
        }
        int max = dp[0];
        int indexOfMax = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] > max){
                max = dp[i];
                indexOfMax = i;
            }
        }
        int temp = indexOfMax;
        while(temp != -1){
            res.add(nums[temp]);
            temp = parent[temp];
        }
        Collections.reverse(res);
        return res;
    }
}
