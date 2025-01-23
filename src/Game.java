import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

    }

    public static void setPlayers(int nb, String[][] grid) {
        switch (nb) {
            case 1:
                grid[4][5] = "J";
                break;
            case 2:
                grid[4][5] = "🧑‍🏭";
                grid[4][6] = "🧞";
                break;
        }
    }

    //    FUNCTION destroyer(grid):
//    PRINT "Veuillez sélectionner une case à détruire (format: ligne,colonne):"
//    INPUT user_input
//
//    TRY:
//    // Étape 1 : Valider le format
//    parts ← SPLIT user_input BY ","
//    IF LENGTH(parts) ≠ 2:
//    PRINT "Entrée invalide. Veuillez entrer au format ligne,colonne."
//    RETURN
//
//    // Étape 2 : Convertir les coordonnées
//    y ← CONVERT parts[0] TO INTEGER
//    x ← CONVERT parts[1] TO INTEGER
//
//    // Étape 3 : Vérifier les limites
//    IF y < 0 OR y ≥ LENGTH(grid) OR x < 0 OR x ≥ LENGTH(grid[0]):
//    PRINT "Les coordonnées sont hors de la grille."
//    RETURN
//
//    // Étape 4 : Vérifier l'état de la case
//    IF grid[y][x] ≠ "⚪":
//    PRINT "Cette case n'est pas une case vide."
//    RETURN
//
//    // Étape 5 : Modifier la case
//    grid[y][x] ← "❌"
//    PRINT "La case (" + y + "," + x + ") a été détruite."
//
//    CATCH ERROR AS NumberFormatException:
//    PRINT "Erreur : veuillez entrer des nombres pour les coordonnées."
//
//    FINALLY:
//    CLOSE scanner IF OPEN


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

    public static void doublecase(String[][] grid) {
        System.out.println("You can destroy two cases");
        destroyer(grid);
    }
    /**
     * Checks whether the player is surrounded by obstacles or enemies and updates their alive status.
     * <p>
     * This method determines if the player is surrounded on all sides (up, down, left, right)
     * by obstacles ("❌") or enemies ("🧞"). If the player is surrounded, their alive status is set to false.
     * The edges of the grid are handled safely to avoid out-of-bounds exceptions.
     * </p>
     *
     * @param grid   The array representing the game grid (visual representation).
     *               Each cell in the grid may contain "❌" (obstacle), "🧞" (enemy), or other values.
     * @param player The array tracking the player's position within the grid.
     * @param y      The current vertical position (row) of the player in the grid.
     * @param x      The current horizontal position (column) of the player in the grid.
     */
//    public static void death(String[][] grid, short[][] player, short y, short x) {
//        // Check the top cell, if it exists, to determine if it is blocked
//        boolean top = (y > 0) && (grid[y - 1][x].equals("❌") || grid[y - 1][x].equals("🧞"));
//
//        // Check the bottom cell, if it exists, to determine if it is blocked
//        boolean bottom = (y < grid.length - 1) && (grid[y + 1][x].equals("❌") || grid[y + 1][x].equals("🧞"));
//
//        // Check the left cell, if it exists, to determine if it is blocked
//        boolean left = (x > 0) && (grid[y][x - 1].equals("❌") || grid[y][x - 1].equals("🧞"));
//
//        // Check the right cell, if it exists, to determine if it is blocked
//        boolean right = (x < grid[0].length - 1) && (grid[y][x + 1].equals("❌") || grid[y][x + 1].equals("🧞"));
//
//        // Special handling for the top and bottom rows of the grid
//        switch (y) {
//            case 9: // If the player is on the bottom row
//                if (top && left && right) {
//                    Player.Alive = false; // The player is surrounded and dies
//                    break;
//                }
//            case 0: // If the player is on the top row
//                if (bottom && left && right) {
//                    Player.Alive = false; // The player is surrounded and dies
//                    break;
//                }
//        }
//
//        // Special handling for the leftmost and rightmost columns of the grid
//        switch (x) {
//            case 0: // If the player is in the leftmost column
//                if (top && bottom && right) {
//                    Player.Alive = false; // The player is surrounded and dies
//                    break;
//                }
//            case 10: // If the player is in the rightmost column
//                if (top && bottom && left) {
//                    Player.Alive = false; // The player is surrounded and dies
//                    break;
//                }
//        }
//        // If all surrounding cells are blocked, the player is considered dead
//        if (top && bottom && left && right) {
//            Player.Alive = false; // The player is surrounded and dies
//        }
//    }
}

