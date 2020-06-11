class Solution {
    public void sortColors(int[] nums) {
        //Counting sort
        //Time : O(n + k) Space: O(1) as there are only 3 colors.
        int[] freq = new int[3];
        
        for(int i = 0; i < nums.length; i++){
            freq[nums[i]]++;
        }
        int index = 0;
        for(int i = 0; i < 3; i++){
            for(int count = 0; count < freq[i]; count++){
                nums[index++] = i;
            }
        }
        /*
        //one-pass
        //Time : O(n) Space:O(1)
        int left = 0;
        int right = nums.length - 1;
        
        for(int i = 0; i <= right;){
            //if curr number is 2 put it at the end.
            if(nums[i] == 2){
                swap(nums, i, right);
                right--;
            }
            //if number is 1 do nothing, to keep it in the middle.
            else if(nums[i] == 1){
                i++;
            }
            //if number is 0 put it in the beginning.
            else if(nums[i] == 0){
                swap(nums, i, left);
                left++;
                i++;
            }
        }
        */
    }
    /*public void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }*/
}
