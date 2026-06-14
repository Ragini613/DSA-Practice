class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] t : times){
            graph.computeIfAbsent(t[0], v -> new ArrayList<>()).add(new int[]{t[1], t[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        Map<Integer, Integer> visited= new HashMap<>();
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int node =  curr[0], time = curr[1];
            if(visited.containsKey(node)) continue;
            visited.put(node, time);
            for(int[] neighbor : graph.getOrDefault(node, new ArrayList<>())){
                if (!visited.containsKey(neighbor[0])){
                    pq.offer(new int[]{neighbor[0], time + neighbor[1]});
                }
            }
        }
        if(visited.size() != n) return -1;
        return Collections.max(visited.values());

    }
}