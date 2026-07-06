class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int effort = cur[2];
            if (x == m - 1 && y == n - 1)
                return effort;
            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;
                int newEffort = Math.max(effort,
                        Math.abs(heights[x][y] - heights[nx][ny]));
                if (newEffort < dist[nx][ny]){
                    dist[nx][ny] = newEffort;
                    pq.offer(new int[]{nx, ny, newEffort});
                }
            }
        }
        return 0;
    }
}