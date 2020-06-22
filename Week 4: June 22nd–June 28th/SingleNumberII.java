class Solution {
    public int singleNumber(int[] nums) {
        //Time : O(n)  Space: O(1)
        int res = 0;
        for(int i = 0; i < 32; i++){
             int sumOfOnes = 0;
            for(int num : nums){
                if(((num >> i) & 1) == 1){  //get the digit of ith least significant position in binary representation of num
                    sumOfOnes++;
                }
            }
            //Binary OR Operator copies a bit if it exists in either operand
            //eg : if a = 60 and b = 13
            // a = 0011 1100
            // b = 0000 1101
           //a|b = 0011 1101 = 61
            res = res | (sumOfOnes % 3) << i; //in sumOfOnes%3 only the single number contributes.
        }
        return res;
    }
}

/*class Solution {
//Time : O(n) Space: O(n)
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for(int n : nums){
            if(map.get(n) < 3){
                res = n;
                break;
            }
        }
        return res;
    }
}*/
