//DP
class Solution {
    public int numSquares(int n) {
        //Time: O(n * sqrt(n))  Space: O(n)
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <=n; i++){
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            } 
        }
        return dp[n];
    }
}


//BFS
/*class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(n);
        visited.add(n);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int i = 0; i < size; i++){
                int cur=q.poll();
                for(int j = 1; j * j <= n; j++){
                    int v = cur - j * j;
                     if(v == 0){
                         return count;
                     }
                    if(!visited.contains(v)){
                        q.offer(v);
                        visited.add(v);
                    }
                }
            }
           
        }
        return count;
    }
}*/
