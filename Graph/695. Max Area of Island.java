// Link: https://leetcode.com/problems/max-area-of-island/

// Solutions: 

//////////////////////////////// DFS

//with vis[]
class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        
        int maxArea = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    maxArea = Math.max(maxArea, areaDFS(grid, vis, i, j, m, n));
                }
            }
        }
        
        return maxArea;
    }
    
    private int areaDFS(int[][] grid, boolean[][] vis, int i, int j, int m, int n) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0 || vis[i][j] == true) {
            return 0;
        }
        
        vis[i][j] = true;
        
        int elems = 1;
        
        for(int[] d: dir) {
            int newI = i + d[0];
            int newJ = j + d[1];
            
            elems += areaDFS(grid, vis, newI, newJ, m, n);
        }
        
        return elems;
    }
}

// without vis[] #1

class Solution {    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int maxArea = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, areaDFS(grid, i, j, m, n));
                }
            }
        }
        
        return maxArea;
    }
    
    private int areaDFS(int[][] grid, int i, int j, int m, int n) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0 || grid[i][j] == -1) {
            return 0;
        }
        
        grid[i][j] = -1;
        
        int elems = 1;
        
        elems += areaDFS(grid, i+1, j, m, n);
        elems += areaDFS(grid, i-1, j, m, n);
        elems += areaDFS(grid, i, j+1, m, n);
        elems += areaDFS(grid, i, j-1, m, n);
        
        return elems;
    }
}

// without vis[] #1

class Solution {    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int maxArea = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, areaDFS(grid, i, j, m, n));
                }
            }
        }
        
        return maxArea;
    }
    
    private int areaDFS(int[][] grid, int i, int j, int m, int n) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0 || grid[i][j] == -1) {
            return 0;
        }
        
        grid[i][j] = -1;
        
        return 1 + areaDFS(grid, i+1, j, m, n) + areaDFS(grid, i-1, j, m, n) + areaDFS(grid, i, j+1, m, n) + areaDFS(grid, i, j-1, m, n);
    }
}


////////////////////////////////////////////////// BFS

class Solution { 
    class Pair {
        int i;
        int j;
        
        Pair(int x, int y) {
            i = x;
            j = y;
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int maxArea = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, areaBFS(grid, i, j, m, n));
                }
            }
        }
        
        return maxArea;
    }
    
    private int areaBFS(int[][] grid, int i, int j, int m, int n) {
        Queue<Pair> q = new ArrayDeque<>();
        
        q.add(new Pair(i, j));
        
        int elems = 0;
        while(q.size() > 0) {
            //r m* w a*
            Pair rem = q.remove();
            
            if(grid[rem.i][rem.j] == 0 || grid[rem.i][rem.j] == -1) {
                continue;
            }
            
            grid[rem.i][rem.j] = -1;
            
            elems += 1;
            
            addN(grid, rem.i+1, rem.j, m, n, q);
            addN(grid, rem.i-1, rem.j, m, n, q);
            addN(grid, rem.i, rem.j+1, m, n, q);
            addN(grid, rem.i, rem.j-1, m, n, q);
        }
        
        return elems;
    }
    
    private void addN(int[][] grid, int i, int j, int m, int n, Queue<Pair> q) {
        if(i>=0 && i<m && j>=0 && j<n && grid[i][j] == 1) {
            q.add(new Pair(i, j));
        }
    }
}