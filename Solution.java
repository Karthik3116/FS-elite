import java.util.*;

class Solution {
    public static int countPaths(int[][] grid, int m, int n) {
        // If start or exit is blocked, no path exists.
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return 0;
        
        int[][] paths = new int[m][n];  // DP table: number of ways to reach each cell.
        paths[0][0] = 1;  // Starting position
        
        // To avoid enqueuing a cell multiple times,
        // we keep track if the cell is currently in the queue.
        boolean[][] inQueue = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        inQueue[0][0] = true;
        
        int[] rowDir = {0, 1}; // right, down
        int[] colDir = {1, 0};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            inQueue[r][c] = false; // Mark as removed from queue
            
            // Try both directions.
            for (int k = 0; k < 2; k++) {
                int nr = r + rowDir[k];
                int nc = c + colDir[k];
                
                if (nr < m && nc < n && grid[nr][nc] == 0) {
                    // If reaching (nr, nc) from (r, c) increases the path count...
                    int oldVal = paths[nr][nc];
                    int newVal = oldVal + paths[r][c];
                    if (newVal != oldVal) {
                        paths[nr][nc] = newVal;
                        // Only enqueue if not already enqueued.
                        if (!inQueue[nr][nc]) {
                            queue.add(new int[]{nr, nc});
                            inQueue[nr][nc] = true;
                        }
                    }
                }
            }
        }
        
        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(countPaths(grid, m, n));
    }
}
