package player;

import java.util.Scanner;

/**
 * The PlayerMovement class simulates the movement of a player within a grid using directional keys.
 * It provides methods to move the player in four directions: up, down, left, and right.
 * <p>
 * The class also includes a method to process user input and execute the corresponding movement.
 * </p>
 */
public class PlayerMovement {

    /**
     * The main method executed at the start of the program.
     * Currently, it does not contain any functional code but serves as an entry point for future extensions.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
    }

    /**
     * Moves the player upwards in the grid.
     * If the player is already at the top row, no movement occurs, and a message is displayed.
     *
     * @param grid   The array representing the game grid (visual representation).
     * @param player The array tracking the player's position within the grid.
     * @param y      The current vertical position of the player.
     * @param x      The current horizontal position of the player.
     * @return The new coordinates of the player after the move.
     */
    public static short[] up(String[][] grid, short[][] player, short y, short x) {
        if (y == 0) {
            System.out.println("You cannot move outside the grid ❌");
        } else {
            grid[y][x] = "⚪"; // Reset the previous position
            y -= 1;  // Move the player upwards
        }
        return new short[]{y, x};
    }

    /**
     * Moves the player downwards in the grid.
     * If the player is already at the bottom row, no movement occurs, and a message is displayed.
     *
     * @param grid   The array representing the game grid (visual representation).
     * @param player The array tracking the player's position within the grid.
     * @param y      The current vertical position of the player.
     * @param x      The current horizontal position of the player.
     * @return The new coordinates of the player after the move.
     */
    public static short[] down(String[][] grid, short[][] player, short y, short x) {
        if (y == 9) {
            System.out.println("You cannot move outside the grid ❌");
        } else {
            grid[y][x] = "⚪"; // Reset the previous position
            y += 1;  // Move the player downwards
        }
        return new short[]{y, x};
    }

    /**
     * Moves the player to the left in the grid.
     * If the player is already at the first column, no movement occurs, and a message is displayed.
     *
     * @param grid   The array representing the game grid (visual representation).
     * @param player The array tracking the player's position within the grid.
     * @param y      The current vertical position of the player.
     * @param x      The current horizontal position of the player.
     * @return The new coordinates of the player after the move.
     */
    public static short[] left(String[][] grid, short[][] player, short y, short x) {
        if (x == 0) {
            System.out.println("You cannot move outside the grid ❌");
        } else {
            grid[y][x] = "⚪"; // Reset the previous position
            x -= 1;  // Move the player to the left
        }
        return new short[]{y, x};
    }

    /**
     * Moves the player to the right in the grid.
     * If the player is already at the last column, no movement occurs, and a message is displayed.
     *
     * @param grid   The array representing the game grid (visual representation).
     * @param player The array tracking the player's position within the grid.
     * @param y      The current vertical position of the player.
     * @param x      The current horizontal position of the player.
     * @return The new coordinates of the player after the move.
     */
    public static short[] right(String[][] grid, short[][] player, short y, short x) {
        if (x == 10) {
            System.out.println("You cannot move outside the grid ❌");
        } else {
            grid[y][x] = "⚪"; // Reset the previous position
            x += 1;  // Move the player to the right
        }
        return new short[]{y, x};
    }

    /**
     * Handles player movement based on user input.
     * The user can press Z (up), S (down), Q (left), or D (right) to move the player.
     * Invalid inputs prompt the user to try again.
     *
     * @param grid   The array representing the game grid (visual representation).
     * @param player The array tracking the player's position within the grid.
     * @param y      The current vertical position of the player.
     * @param x      The current horizontal position of the player.
     */
    public static void move(String[][] grid, short[][] player, short y, short x) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please move using the arrow keys or the Z, Q, S, D keys:");

        String direction = scanner.nextLine();

        if (direction.isEmpty()) {
            System.out.println("No input provided, please enter a valid direction.");
            move(grid, player, y, x);
            return;
        }

        switch (direction.charAt(0)) {
            case 'z':
            case 'Z':
                short[] newPosZ = up(grid, player, y, x);
                y = newPosZ[0];
                x = newPosZ[1];
                break;
            case 's':
            case 'S':
                short[] newPosS = down(grid, player, y, x);
                y = newPosS[0];
                x = newPosS[1];
                break;
            case 'q':
            case 'Q':
                short[] newPosQ = left(grid, player, y, x);
                y = newPosQ[0];
                x = newPosQ[1];
                break;
            case 'd':
            case 'D':
                short[] newPosD = right(grid, player, y, x);
                y = newPosD[0];
                x = newPosD[1];
                break;
            default:
                System.out.println("The selected key is not valid for movement.");
                move(grid, player, y, x);
        }
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

