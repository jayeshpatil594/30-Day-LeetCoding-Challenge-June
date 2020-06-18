class Solution {
    public int hIndex(int[] citations) {
        //Time: O(logn) Space: O(1)
        int l = 0;
        int r = citations.length - 1;
        
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(citations[mid] >= citations.length - mid){
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }
        return citations.length - l;
    }
}
