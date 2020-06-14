class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //Dijktra modified
        //Time : O(ElogV) 
        int[][] adj = new int[n][n];
        for(int[] flight: flights){
            adj[flight[0]][flight[1]] = flight[2];
        }
        int[] dist = new int[n];
        int[] stops = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        dist[src] = 0;
        stops[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0 , 0});
        while(!pq.isEmpty()){
            int[] curNode = pq.poll();
            int u = curNode[0];
            int dist_u = curNode[1];
            int stops_u = curNode[2];
            if(u == dst){
                return dist_u;
            }
            if(stops_u == K + 1){
                continue;
            }
            for(int v = 0; v < n; v++){
                if(adj[u][v] > 0){
                    if(dist_u + adj[u][v] < dist[v]){
                    dist[v] = dist_u + adj[u][v];
                    pq.offer(new int[]{v, dist[v], stops_u + 1});
                    }
                    else if(stops_u + 1 < stops[v]){
                        stops[v] = stops_u + 1;
                        pq.offer(new int[]{v, dist_u + adj[u][v], stops_u + 1});
                    }
                }
            }
        }
        return -1;
    }
}
