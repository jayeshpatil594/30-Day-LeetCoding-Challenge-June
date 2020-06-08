class Solution {
    public boolean isPowerOfTwo(int n) {     
        //Iterative
        //Time : O(logn)
        if(n == 0){
            return false;
        }
        while(n % 2 == 0){
            n = n / 2;
        }
        return n == 1;
        
        
        /* //Bit Op 
           //Time : O(1)
           // (n = 2 ^ 0 = 1 = ...000001, n - 1 = 0 = ...000000) => (n & n-1) = (...000001 & ...000000) = 000000 = 0
           // (n = 2 ^ 1 = 2 = ...000010, n - 1 = 1 = ...000001) => (n & n-1) = (...000010 & ...000001) = 000000 = 0
           // (n = 2 ^ 2 = 4 = ...000100, n - 1 = 3 = ...000011) => (n & n-1) = (...000100 & ...000011) = 000000 = 0
         return n > 0 && (n & (n - 1)) == 0;
        */
         
        /* Recursive 
           Time : O(logn)
         return n > 0 && (n == 1 || (n%2 == 0 && isPowerOfTwo(n/2)));
        */
    }
}
