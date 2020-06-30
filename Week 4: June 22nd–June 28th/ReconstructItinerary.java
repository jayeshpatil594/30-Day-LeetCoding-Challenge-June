class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        if (tickets == null || tickets.size() == 0){
            return new LinkedList<>();
        }   
        for(List<String> ticket : tickets){
            map.putIfAbsent(ticket.get(0), new PriorityQueue<String>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK", res, map);
        return res;
    }
    public void dfs(String s, LinkedList<String> res, Map<String, PriorityQueue<String>> map){
        PriorityQueue<String> pq = map.get(s);
        while(pq != null && !pq.isEmpty()){
            String adj = pq.poll();
            dfs(adj , res, map);
        }
        res.addFirst(s);
    }
}


