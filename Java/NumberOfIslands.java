class NumberOfIslands
{
    public int numIslands(char[][] grid)
    {
        if(grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length, count = 0;

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == '1')
                {
                    visit(grid, i, j);
                    count++;
                }

        return count;
    }

    void visit(char[][] grid, int i, int j)
    {
        int m = grid.length, n = grid[0].length;

        if(i < 0 || j < 0 || i > m - 1 || j > n -1 || grid[i][j] == '0') return;

        grid[i][j] = '0';
        
        visit(grid, i - 1, j);
        visit(grid, i + 1, j);
        visit(grid, i, j - 1);
        visit(grid, i, j + 1);
    }
}