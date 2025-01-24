import java.util.Scanner;

/**
 * The PlayerMovement class handles the movement of the player on the game grid.
 * It provides methods to move the player in different directions and checks if the destination is valid.
 */
public class PlayerMovement {

    /**
     * Scanner object to capture user input for movement direction.
     */
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Checks if a specific cell in the grid is empty.
     * <p>
     * This method verifies if the given coordinates are within the grid's bounds
     * and checks whether the specified cell contains an empty case.
     * </p>
     *
     * @param grid The game grid represented as a 2D array of strings.
     * @param y    The vertical position of the cell.
     * @param x    The horizontal position of the cell.
     * @return True if the cell is empty, false otherwise.
     */
    private static boolean isEmptyCase(String[][] grid, int y, int x) {
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
            return false; // Out of bounds, considered not empty
        }
        return grid[y][x].equals(Grid.emptyCase);
    }

    /**
     * Moves the player upwards if the cell above is empty and within bounds.
     * <p>
     * If the cell above is not empty or if the player is already at the top row,
     * a message will be displayed indicating the movement is not possible.
     * </p>
     *
     * @param grid   The game grid.
     * @param player The player object containing the current position of the player.
     */
    public static void moveUp(String[][] grid, Player player) {
        if (player.y == 0) {
            System.out.println("You cannot move outside the grid.");
            Security.antiSpam();
            move(grid, player);
        } else if (!isEmptyCase(grid, player.y - 1, player.x)) {
            System.out.println("The cell above is not empty.");
            Security.antiSpam();
            move(grid, player);
        } else {
            String temp = grid[player.y][player.x];
            grid[player.y][player.x] = Grid.emptyCase;
            player.y -= 1;
            grid[player.y][player.x] = temp;
        }
    }

    /**
     * Moves the player downwards if the cell below is empty and within bounds.
     * <p>
     * If the cell below is not empty or if the player is already at the bottom row,
     * a message will be displayed indicating the movement is not possible.
     * </p>
     *
     * @param grid   The game grid.
     * @param player The player object containing the current position of the player.
     */
    public static void moveDown(String[][] grid, Player player) {
        if (player.y == grid.length - 1) {
            System.out.println("You cannot move outside the grid.");
            Security.antiSpam();
            move(grid, player);
        } else if (!isEmptyCase(grid, player.y + 1, player.x)) {
            System.out.println("The cell below is not empty.");
            Security.antiSpam();
            move(grid, player);
        } else {
            String temp = grid[player.y][player.x];
            grid[player.y][player.x] = Grid.emptyCase;
            player.y += 1;
            grid[player.y][player.x] = temp;
        }
    }

    /**
     * Moves the player to the left if the cell to the left is empty and within bounds.
     * <p>
     * If the cell to the left is not empty or if the player is already at the leftmost column,
     * a message will be displayed indicating the movement is not possible.
     * </p>
     *
     * @param grid   The game grid.
     * @param player The player object containing the current position of the player.
     */
    public static void moveLeft(String[][] grid, Player player) {
        if (player.x == 0) {
            System.out.println("You cannot move outside the grid.");
            Security.antiSpam();
            move(grid, player);
        } else if (!isEmptyCase(grid, player.y, player.x - 1)) {
            System.out.println("The cell to the left is not empty.");
            Security.antiSpam();
            move(grid, player);
        } else {
            String temp = grid[player.y][player.x];
            grid[player.y][player.x] = Grid.emptyCase;
            player.x -= 1;
            grid[player.y][player.x] = temp;
        }
    }

    /**
     * Moves the player to the right if the cell to the right is empty and within bounds.
     * <p>
     * If the cell to the right is not empty or if the player is already at the rightmost column,
     * a message will be displayed indicating the movement is not possible.
     * </p>
     *
     * @param grid   The game grid.
     * @param player The player object containing the current position of the player.
     */
    public static void moveRight(String[][] grid, Player player) {
        if (player.x == grid[0].length - 1) {
            System.out.println("You cannot move outside the grid.");
            Security.antiSpam();
            move(grid, player);
        } else if (!isEmptyCase(grid, player.y, player.x + 1)) {
            System.out.println("The cell to the right is not empty.");
            Security.antiSpam();
            move(grid, player);
        } else {
            String temp = grid[player.y][player.x];
            grid[player.y][player.x] = Grid.emptyCase;
            player.x += 1;
            grid[player.y][player.x] = temp;
        }
    }

    /**
     * Prompts the user to enter a movement direction and updates the player's position accordingly.
     * <p>
     * The method accepts input in the form of arrow keys or the letters Z, Q, S, D for movement.
     * If the input is invalid, the method will ask the user for a valid direction again.
     * </p>
     *
     * @param grid   The game grid.
     * @param player The player object containing the current position of the player.
     */
    public static void move(String[][] grid, Player player) {
        System.out.println("Please move using the arrow keys or the Z, Q, S, D keys:");
        //  MUSIQUE A METTRE ICI !!!!!!!!!!
        String direction = scanner.nextLine();

        // Check if the direction is empty
        if (direction == null || direction.isEmpty()) {
            System.out.println("No input provided, please enter a valid direction.");
            //  MUSIQUE A METTRE ICI !!!!!!!!!!
            Security.antiSpam();
            move(grid, player); // Recurse to ask for a new input
            return; // End the current iteration
        }

        // Analyze the first character of the direction input
        switch (direction.charAt(0)) {
            case 'z':
            case 'Z':
                Security.antiSpam();
                moveUp(grid, player);
                //  MUSIQUE A METTRE ICI !!!!!!!!!!
                break;
            case 's':
            case 'S':
                Security.antiSpam();
                moveDown(grid, player);
                //  MUSIQUE A METTRE ICI !!!!!!!!!!
                break;
            case 'q':
            case 'Q':
                Security.antiSpam();
                moveLeft(grid, player);
                //  MUSIQUE A METTRE ICI !!!!!!!!!!
                break;
            case 'd':
            case 'D':
                Security.antiSpam();
                moveRight(grid, player);
                //  MUSIQUE A METTRE ICI !!!!!!!!!!
                break;
            default:
                System.out.println("The selected key is not valid for movement.");
                Security.antiSpam();
                //  MUSIQUE A METTRE ICI !!!!!!!!!!
                move(grid, player); // Prompt the user again for valid input
        }
    }
}
