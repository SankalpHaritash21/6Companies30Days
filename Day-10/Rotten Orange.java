class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int minMinutes = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            int currMinutes = q.peek()[2];
            q.poll();
            minMinutes = Math.max(minMinutes, currMinutes);
            for(int i=-1; i<=1; i++){
                if(i==0)continue;
                if(row+i<grid.length && row+i>=0 && grid[row+i][col]==1){
                    grid[row+i][col] = 2;
                    q.add(new int[]{row+i, col, currMinutes+1});
                }
                if(col+i<grid[0].length && col+i>=0 && grid[row][col+i]==1){
                    grid[row][col+i]=2;
                    q.add(new int[]{row, col+i, currMinutes+1});
                }
            }
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1)return -1;
            }
        }
        return minMinutes;
    }
}