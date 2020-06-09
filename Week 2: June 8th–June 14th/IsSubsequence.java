class Solution {
    public boolean isSubsequence(String s, String t) {
        // Two pointers
        //Time :O(t) Space: O(1)
        if(s.length() == 0){
            return true;
        }
        int sIndex = 0;
        
        for(int tIndex = 0; tIndex < t.length(); tIndex++){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
            }
            //string s exhausted
            if (sIndex == s.length()){
                return true;
            }
        }
        return false;
    }
}
