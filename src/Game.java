import java.util.Scanner;

public class Game {
    public static void setPlayers(int nb, String[][] grid)
    {
        switch(nb)
        {
            case 2:
                grid[5][6] = "🟥";
                grid[5][4] = "🟨";
                break;
            case 3:
                grid[4][5] = "🟩";
                grid[5][6] = "🟥";
                grid[5][4] = "🟨";
                break;
            case 4:
                grid[4][6] = "🟧";
                grid[4][4] = "🟩";
                grid[5][6] = "🟥";
                grid[5][4] = "🟨";
                break;
        }

    }

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

