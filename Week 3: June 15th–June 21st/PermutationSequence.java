class Solution {
    public String getPermutation(int n, int k) {
        //Time : O(n)
        List<Integer> list = new ArrayList<>();
        int[] fact = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        fact[0] = 1;
        for(int i = 1; i <= n; i++){
            fact[i] = fact[i - 1] * i;
        }
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        k--; //since index start at 0.
        
        for(int i = 1; i <= n; i++){
            int index = k / fact[n - i];
            sb.append(list.get(index));
            list.remove(index);
            k = k - index * fact[n - i];
        }
        return sb.toString();
    }
}

/*
Brute Force : Time : O(n!)
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        List<String> result = new ArrayList<>();
        permute("", sb.toString(), result);
        return result.get(k - 1);
    }

    private void permute(String prefix, String s, List<String> result) {
        if (s.isEmpty()) {
            result.add(prefix);
        } else {
            for (int i = 0; i < s.length(); i++) {
                permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1), result);
            }
        }
    }
}*/
