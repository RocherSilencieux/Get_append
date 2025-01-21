package player;

import java.util.Scanner;

/**
 * The PlayerMovement class simulates the movement of a player within a grid using directional keys.
 * It provides methods to move the player in four directions: up, down, left, right.
 */
class PlayerMovement {

    /**
     * The main method executed at the start of the program.
     * It initializes a grid representing the game and starts the player's movement method.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        short[][] player = new short[10][11];  // Grid representation (10 rows and 11 columns)
        move(player, (short) 0, (short) 2); // Example of the player's initial position at coordinates (2, 2)
    }

    /**
     * Moves the player upwards in the grid. The method checks if the player is already at the top
     * and prevents any movement out of the grid.
     *
     * @param player The array representing the game grid.
     * @param y The current vertical position of the player.
     * @param x The current horizontal position of the player.
     * @return The new coordinates of the player after the move.
     */
    public static short[] up(short[][] player, short y, short x) {
        // Checks if the player is already at the top row
        if (y == 0) {
            System.out.println("You cannot move outside the grid ❌");
        } else {
            y -= 1;  // Move the player upwards
        }
        return new short[] {y, x};  // Return the new coordinates
    }

    /**
     * Moves the player downwards in the grid. The method checks if the player is already at the bottom
     * and prevents any movement out of the grid.
     *
     * @param player The array representing the game grid.
     * @param y The current vertical position of the player.
     * @param x The current horizontal position of the player.
     * @return The new coordinates of the player after the move.
     */
    public static short[] down(short[][] player, short y, short x) {
        // Checks if the player is already at the last row
        if (y == 9) {
            System.out.println("You cannot move outside the grid ❌");
        } else {
            y += 1;  // Move the player downwards
        }
        return new short[] {y, x};  // Return the new coordinates
    }

    /**
     * Moves the player to the left in the grid. The method checks if the player is already at the first column
     * and prevents any movement out of the grid.
     *
     * @param player The array representing the game grid.
     * @param y The current vertical position of the player.
     * @param x The current horizontal position of the player.
     * @return The new coordinates of the player after the move.
     */
    public static short[] left(short[][] player, short y, short x) {
        // Checks if the player is already at the first column
        if (x == 0) {
            System.out.println("You cannot move outside the grid ❌");
        } else {
            x -= 1;  // Move the player to the left
        }
        return new short[] {y, x};  // Return the new coordinates
    }

    /**
     * Moves the player to the right in the grid. The method checks if the player is already at the last column
     * and prevents any movement out of the grid.
     *
     * @param player The array representing the game grid.
     * @param y The current vertical position of the player.
     * @param x The current horizontal position of the player.
     * @return The new coordinates of the player after the move.
     */
    public static short[] right(short[][] player, short y, short x) {
        // Checks if the player is already at the last column
        if (x == 10) {
            System.out.println("You cannot move outside the grid ❌");
        } else {
            x += 1;  // Move the player to the right
        }
        return new short[] {y, x};  // Return the new coordinates
    }

    /**
     * Allows the player to move based on keyboard input. The player can choose to move
     * in a direction by pressing the Z, S, Q, or D keys. If an invalid key is pressed, the method
     * asks for a valid input.
     *
     * @param player The array representing the game grid.
     * @param y The current vertical position of the player.
     * @param x The current horizontal position of the player.
     */
    public static void move(short[][] player, short y, short x) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please move using the arrow keys or the Z, Q, S, D keys:");

        // Read the direction entered by the user
        String direction = scanner.nextLine();

        // Check if the direction is not empty
        if (direction.isEmpty()) {
            System.out.println("No input provided, please enter a valid direction.");
            move(player, y, x);  // Recursive call to ask for a valid direction again
        }

        // Handle the movement based on the key pressed
        switch (direction.charAt(0)) {
            case 'z':
            case 'Z':
                short[] newPosZ = up(player, y, x);
                y = newPosZ[0];
                x = newPosZ[1];
//                move(player, y, x);  // Recursive call to ask for a valid direction again
            case 's':
            case 'S':
                short[] newPosS = down(player, y, x);
                y = newPosS[0];
                x = newPosS[1];
//                move(player, y, x);  // Recursive call to ask for a valid direction again
            case 'q':
            case 'Q':
                short[] newPosQ = left(player, y, x);
                y = newPosQ[0];
                x = newPosQ[1];
//                move(player, y, x);  // Recursive call to ask for a valid direction again
            case 'd':
            case 'D':
                short[] newPosD = right(player, y, x);
                y = newPosD[0];
                x = newPosD[1];
//                move(player, y, x);  // Recursive call to ask for a valid direction again
            default:
                System.out.println("The selected key is not valid for movement.");
                move(player, y, x);  // Recursive call to ask for a valid direction again
        }
    }
}
