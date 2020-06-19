class Solution {
    int a = 26;
    int mod = 1<<30;
    //Binary Search + Rabin-Karp
    public String longestDupSubstring(String S) {
        //Time: O(NlogN)
        int start = 1;
        int end = S.length() - 1;
        while(start <= end){
            int len = start + (end - start) / 2;
            int startIndex = search(S, len);
            if(startIndex == -1){
                end = len  - 1;
            } else{
                start = len + 1;
            }
        }
        int startIndex = search(S, end);
        return startIndex == -1 ? "" : S.substring(startIndex, startIndex + end);
    }
    public int search(String S, int len){
        long hash = 0;   //hash code
        long aL = 1;     // a^base % modulus
        for(int i = 0; i < len; i++){
            hash = (hash * a % mod + S.charAt(i)) % mod;
            aL = (aL * a) % mod;
        }
        Map<Long, List<Integer>> map = new HashMap<>();
        map.put(hash, new ArrayList<Integer>());
        map.get(hash).add(0);
        for(int i = 1; i < S.length() - len + 1; i++){
            hash = ((hash* a % mod - S.charAt(i - 1) * aL % mod + mod)% mod + S.charAt(i + len -1))% mod;
            if(map.containsKey(hash)){
                for(int start : map.get(hash)){
                    if(S.substring(start, start + len).equals(S.substring(i, i + len))){
                        return i;
                    }
                }
            } else {
                map.put(hash, new ArrayList<Integer>());
            }
            map.get(hash).add(i);
        }
        return -1;
    } 
}

/*class Solution {
    public String longestDupSubstring(String S) {
        
        //Brute force
        //Time: O(n ^ 3) 
        //int n = S.length();
        //String lrs = "";
        //for(int i = 0; i < n; i++){
        //    for(int j = i + 1; j < n; j++){
        //        String x = lcp(S.substring(i, n), S.substring(j, n));
        //        if(x.length() > lrs.length()){
        //            lrs = x;
        //       }
        //    }
        //}
        //return lrs;
        
        
        Suffix Array
        Time : O(n ^ 2)
        int n = S.length();
        String[] suffixes = new String[n];
        for(int i = 0; i < n ; i++){
            suffixes[i] = S.substring(i, n);
        }
        Arrays.sort(suffixes);
        StringBuilder lrs = new StringBuilder();
        for(int i = 0; i < n - 1; i++){
            String x = lcp(suffixes[i], suffixes[i + 1]);
            if(x.length() > lrs.length()){
                lrs.delete(0,  lrs.length());
                lrs.append(x);
            }
        }
        return lrs.toString();
    }
    
    //fuction for longest common prefix
    public String lcp(String s, String t){
        int n = Math.min(s.length(), t.length());
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                return s.substring(0, i);
            }
        }
        return s.substring(0, n);
    }
    
}*/
