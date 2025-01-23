import java.util.Scanner;

public class PlayerMovement {

    /**
     * Moves the player upwards in the grid.
     *
     * @param grid   The array representing the game grid (visual representation).
     * @param player The Player object containing the player's current position.
     */
    public static void up(String[][] grid, Player player) {
        if (player.y == 0) {
            System.out.println("You cannot move outside the grid.");
        } else {
            grid[player.y][player.x] = "emptyCase"; // Reset the previous position
            player.y -= 1; // Move the player upwards
        }
    }

    /**
     * Moves the player downwards in the grid.
     *
     * @param grid   The array representing the game grid (visual representation).
     * @param player The Player object containing the player's current position.
     */
    public static void down(String[][] grid, Player player) {
        if (player.y == grid.length - 1) {
            System.out.println("You cannot move outside the grid.");
        } else {
            grid[player.y][player.x] = "emptyCase"; // Reset the previous position
            player.y += 1; // Move the player downwards
        }
    }

    /**
     * Moves the player to the left in the grid.
     *
     * @param grid   The array representing the game grid (visual representation).
     * @param player The Player object containing the player's current position.
     */
    public static void left(String[][] grid, Player player) {
        if (player.x == 0) {
            System.out.println("You cannot move outside the grid.");
        } else {
            grid[player.y][player.x] = "emptyCase"; // Reset the previous position
            player.x -= 1; // Move the player to the left
        }
    }

    /**
     * Moves the player to the right in the grid.
     *
     * @param grid   The array representing the game grid (visual representation).
     * @param player The Player object containing the player's current position.
     */
    public static void right(String[][] grid, Player player) {
        if (player.x == grid[0].length - 1) {
            System.out.println("You cannot move outside the grid.");
        } else {
            grid[player.y][player.x] = "emptyCase"; // Reset the previous position
            player.x += 1; // Move the player to the right
        }
    }

    /**
     * Handles player movement based on user input.
     *
     * @param grid   The array representing the game grid (visual representation).
     * @param player The Player object containing the player's current position.
     */
    public static void move(String[][] grid, Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please move using the arrow keys or the Z, Q, S, D keys:");

        String direction = scanner.nextLine();

        if (direction.isEmpty()) {
            System.out.println("No input provided, please enter a valid direction.");
            move(grid, player);
            return;
        }

        switch (direction.charAt(0)) {
            case 'z':
            case 'Z':
                up(grid, player);
                break;
            case 's':
            case 'S':
                down(grid, player);
                break;
            case 'q':
            case 'Q':
                left(grid, player);
                break;
            case 'd':
            case 'D':
                right(grid, player);
                break;
            default:
                System.out.println("The selected key is not valid for movement.");
                move(grid, player);
        }
    }
}
