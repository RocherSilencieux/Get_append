import java.util.Scanner;
public class Game
{
    /**
    spawn in the players in the grid depending on their number

    @param nb number of players
    @param grid the grid used by the current game
    @return void
     */
    public static void setPlayers(byte nb, String[][] grid)
    {
        switch(nb)
        {
            case 1:
                grid[4][5] = "J";
                break;
            case 2:
                grid[4][5] = "J1";
                grid[4][6] = "J2";
                break;
        }

    }

    /**
     * Destroys a specific cell in the given grid.
     * <p>
     * This method prompts the user to input coordinates in the format "row,column".
     * If the input is valid and the selected cell is empty, the cell is marked as destroyed ("❌").
     * Otherwise, appropriate error messages are displayed, and the method is called recursively to retry.
     * </p>
     *
     * @param grid a 2D array representing the game grid, where cells can be modified.
     * @throws NumberFormatException if the user provides non-numeric coordinates.
     */
    public static void destroyer(String[][] grid) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to select a cell to destroy
        System.out.println("Please select a cell to destroy (format: row,column):");
        String targetCell = scanner.nextLine(); // Read the user's input

        try {
            // Split the input string to extract row and column coordinates
            String[] coordinates = targetCell.split(",");

            // Validate that the input contains exactly two parts
            if (coordinates.length != 2) {
                System.out.println("Invalid input. Please enter in the format row,column.");
                destroyer(grid); // Recursively prompt the user again
                return; // Exit the current method call
            }

            // Convert the string coordinates to integers
            int y = Integer.parseInt(coordinates[0].trim()); // Extract and parse the row index
            int x = Integer.parseInt(coordinates[1].trim()); // Extract and parse the column index

            // Check if the provided coordinates are within the grid's bounds
            if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
                System.out.println("Coordinates are out of bounds.");
                destroyer(grid); // Recursively prompt the user again
                return; // Exit the current method call
            }

            // Check if the selected cell is already occupied or not empty
            if (!grid[y][x].equals("⚪")) {
                System.out.println("This cell is not empty.");
                destroyer(grid); // Recursively prompt the user again
                return; // Exit the current method call
            }

            // Mark the selected cell as destroyed
            grid[y][x] = "❌";
            System.out.println("Cell (" + y + "," + x + ") has been destroyed."); // Notify the user

        } catch (NumberFormatException e) {
            // Handle the case where the user inputs non-numeric values
            System.out.println("Error: Please enter numbers for the coordinates.");
        }

        // Close the scanner to release resources
        scanner.close();
    }
}

