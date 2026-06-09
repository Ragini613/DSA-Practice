class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i =0; i<grid.length; i++)
        for(int j = 0; j<grid[0].length; j++){
            if(grid[i][j] ==2) queue.offer(new int[]{i,j});
            if(grid[i][j] == 1) fresh++;
        }
        if(fresh == 0) return 0;
        int[][] dirs = {{1, 0}, {-1, 0},{0,1}, {0,-1}};
        int minutes =0;
        while(!queue.isEmpty()){
            minutes++;
            int size = queue.size();
            for(int k =0; k < size; k++){
                int[] curr = queue.poll();
                for(int[] dir : dirs){
                    int ni = curr[0] + dir[0];
                    int nj = curr[1] + dir[1];
                    if(ni>= 0 && ni <grid.length && nj >= 0 && nj<grid[0].length&& grid[ni][nj] == 1){
                        grid[ni][nj]=2;
                        fresh--;
                        queue.offer(new int[]{ni,nj});
                    }
                }
            }
        }
        return fresh ==0 ? minutes - 1 : -1;
        

    }
}