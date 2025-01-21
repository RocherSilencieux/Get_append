package grid;

public class Grid {
    public static void main(String[] args)
    {

    }
    public static String[][] initializeGrid()
    {
        String[][] matrix = new String[10][11];
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                matrix[i][j] = " ";
            }
        }
        return matrix;
    }
    public static void printGrid(String[][] grid)
    {
        for(int i = 0; i < grid.length; i++)
        {
            System.out.println("\n");
            for(int j = 0; j < grid[i].length; j++)
            {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
    public void newGame()
    {
    }
}
