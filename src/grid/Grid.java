package grid;

public class Grid {
    public String[][] grid;

    public static void main(String[] args)
    {

    }
    public static int tata = 0;
    public static String[][] initializeGrid()
    {
        String[][] matrix = new String[10][11];
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                matrix[i][j] = "⚪";
            }
        }
        return matrix;
    }
    public static void printGrid(String[][] grid)
    {
        for(int i = 0; i < grid.length; i++)
        {
            System.out.print("\n");
            for(int j = 0; j < grid[i].length; j++)
            {
                System.out.print(grid[i][j] + "|");
            }
        }
    }
    public void newGame()
    {
    }
}
