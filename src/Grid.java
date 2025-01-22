public class Grid {
    public String[][] grid;
    public Grid()
    {
        this.grid = initializeGrid();
    }
    /**
    initialize a new grid by placing a " " everywere in the matrix
    @return the initialized matrix
     */
    public static String[][] initializeGrid()
    {
        String[][] matrix = new String[10][11];
        for(byte i = 0; i < matrix.length; i++)
        {
            for(short j = 0; j < matrix[i].length; j++)
            {
                matrix[i][j] = " ";
            }
        }
        return matrix;
    }
    /**
    print a previously initialized grid on the console

    @param grid the grid previously initialized
     */
    public static void printGrid(String[][] grid)
    {
        for(byte i = 0; i < grid.length; i++)
        {
            System.out.println("\n");
            for(byte j = 0; j < grid[i].length; j++)
            {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}
