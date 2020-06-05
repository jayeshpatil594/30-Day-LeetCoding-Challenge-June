class Solution {
    Random random;
    int[] wSum;
    public Solution(int[] w) {
        //Time: O(n) Space : O(n)
        random = new Random();
        wSum = new int[w.length];
        for(int i = 1; i < w.length; i++){
            w[i] += w[i - 1];
        }
        wSum = w;
    }
    
    public int pickIndex() {
        //Time: O(logn)
        int index = random.nextInt(wSum[wSum.length - 1]) + 1;
        int l = 0;
        int r = wSum.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(wSum[mid] == index){
                return mid;
            }
            else if(wSum[mid] < index){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
