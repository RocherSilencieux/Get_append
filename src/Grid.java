/**
 * The Grid class represents a 2D game grid and provides methods to initialize and display it.
 * The grid is populated with empty cells by default and can be updated during gameplay.
 */
public class Grid {

    /**
     * A 2D array representing the grid.
     */
    public String[][] grid;

    /**
     * The symbol representing an empty cell in the grid.
     */
    public static String emptyCase = "🟦";

    /**
     * The symbol representing a destroyed cell in the grid.
     */
    public static String destroyCase = "❌";

    /**
     * Constructs a new Grid object and initializes the grid with empty cells.
     */
    public Grid() {
        grid = initializeGrid();
    }

    /**
     * Initializes the grid with default dimensions and populates it with empty cells.
     *
     * @return A 2D array representing the initialized grid with empty cells.
     */
    public static String[][] initializeGrid() {
        String[][] matrix = new String[10][11]; // A grid with 10 rows and 11 columns
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = emptyCase; // Assign the empty case symbol to each cell
            }
        }
        return matrix;
    }

    /**
     * Displays the grid in the console.
     * <p>
     * Each cell is separated by a pipe symbol ("|"), and rows are printed on new lines.
     * </p>
     *
     * @param grid A 2D array representing the grid to be displayed.
     */
    public static void printGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.print("\n"); // Move to the next line for each row
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "|"); // Print each cell followed by a separator
            }
        }
    }
}
