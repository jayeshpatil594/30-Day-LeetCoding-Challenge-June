class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //Time : O(n ^ 2) Space : O(n)
        int[][] res = new int[people.length][2];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }
                else{
                    return a[0] - b[0];
                }
            }
        });
    
        for(int i = 0; i < people.length; i++){
            list.add(i);
        }
        
        for(int i = 0; i < people.length; i++){ //O(n)
            int index = list.get(people[i][1]);
            res[index][0] = people[i][0];
            res[index][1] = people[i][1];
            list.remove(people[i][1]); //O(n)
        }
        return res;
    }
}
