import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

    }

    public static void setPlayers(int nb, String[][] grid, Player[] players) {
        switch (nb) {
            case 1:
                grid[4][5] = "J";
                break;
            case 2:
                grid[4][5] = "🧑‍🏭";
                players[0].x = 5;
                players[0].y = 4;
                grid[4][6] = "🧞";
                players[1].x = 6;
                players[1].y = 4;
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
            }

            // Convert the string coordinates to integers
            int y = Integer.parseInt(coordinates[0].trim()); // Extract and parse the row index
            int x = Integer.parseInt(coordinates[1].trim()); // Extract and parse the column index

            // Check if the provided coordinates are within the grid's bounds
            if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
                System.out.println("Coordinates are out of bounds.");
                destroyer(grid);
                return;// Recursively prompt the user again
            }

            // Check if the selected cell is already occupied or not empty
            if (!grid[y][x].equals(Grid.emptyCase)) {
                System.out.println("This cell is not empty.");
                destroyer(grid); // Recursively prompt the user again
            }

            // Mark the selected cell as destroyed
            grid[y][x] = Grid.destroyCase;
            System.out.println("Cell (" + y + "," + x + ") has been destroyed."); // Notify the user
            return;

        } catch (NumberFormatException e) {
            // Handle the case where the user inputs non-numeric values
            System.out.println("Error: Please enter numbers for the coordinates.");
        }
    }

    public static void doublecase(String[][] grid) {
        System.out.println("You can destroy two cases");
        destroyer(grid);
    }



    /**
     * Checks whether the player is surrounded by obstacles or enemies and updates their alive status.
     *
     * @param grid   The array representing the game grid (visual representation).
     *               Each cell in the grid may contain Grid.destroyCase (obstacle),
     *               "🧞" (enemy), or other values.
     * @param player The Player object representing the player's state and position.
     */
    public static void death(String[][] grid, Player player) {
        int x = player.x; // Position horizontale du joueur
        int y = player.y; // Position verticale du joueur

        // Vérifie si chaque direction immédiate est bloquée
        boolean top = isBlocked(grid, y - 1, x);
        boolean bottom = isBlocked(grid, y + 1, x);
        boolean left = isBlocked(grid, y, x - 1);
        boolean right = isBlocked(grid, y, x + 1);

        // Vérifie les coins uniquement si le joueur est dans un angle
        boolean topLeft = (y > 0 && x > 0) && isBlocked(grid, y - 1, x - 1);
        boolean topRight = (y > 0 && x < grid[0].length - 1) && isBlocked(grid, y - 1, x + 1);
        boolean bottomLeft = (y < grid.length - 1 && x > 0) && isBlocked(grid, y + 1, x - 1);
        boolean bottomRight = (y < grid.length - 1 && x < grid[0].length - 1) && isBlocked(grid, y + 1, x + 1);

        // Si le joueur est dans un coin, vérifie les cases autour uniquement dans les limites applicables
        if (y == 0 && x == 0) { // Coin haut-gauche
            if (bottom && right && bottomRight) {
                player.isalive = false;
                return;
            }
        } else if (y == 0 && x == grid[0].length - 1) { // Coin haut-droit
            if (bottom && left && bottomLeft) {
                player.isalive = false;
                return;
            }
        } else if (y == grid.length - 1 && x == 0) { // Coin bas-gauche
            if (top && right && topRight) {
                player.isalive = false;
                return;
            }
        } else if (y == grid.length - 1 && x == grid[0].length - 1) { // Coin bas-droit
            if (top && left && topLeft) {
                player.isalive = false;
                return;
            }
        } else if (y == 0) { // Bord supérieur (non-angle)
            if (bottom && left && right) {
                player.isalive = false;
                return;
            }
        } else if (y == grid.length - 1) { // Bord inférieur (non-angle)
            if (top && left && right) {
                player.isalive = false;
                return;
            }
        } else if (x == 0) { // Bord gauche (non-angle)
            if (top && bottom && right) {
                player.isalive = false;
                return;
            }
        } else if (x == grid[0].length - 1) { // Bord droit (non-angle)
            if (top && bottom && left) {
                player.isalive = false;
                return;
            }
        } else { // Cas général (au centre)
            if (top && bottom && left && right) {
                player.isalive = false;
                return;
            }
        }

        // Si aucune condition de mort n'est remplie, le joueur reste en vie
        player.isalive = true;
    }

    /**
     * Vérifie si une case spécifique est bloquée.
     *
     * @param grid Le tableau représentant la grille de jeu.
     * @param y    La position verticale de la case.
     * @param x    La position horizontale de la case.
     * @return True si la case est bloquée (obstacle ou ennemi), false sinon.
     */
    private static boolean isBlocked(String[][] grid, int y, int x) {
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
            return true; // Considéré comme bloqué si hors limites
        }
        return !grid[y][x].equals(Grid.emptyCase);
    }
}

