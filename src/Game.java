import java.util.Scanner;

/**
 * The Game class contains methods to manage a grid-based game, including setting players,
 * managing game actions, and checking player status.
 */
public class Game {

    /**
     * The main method serves as the entry point for the game.
     *
     * @param args Command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        // Game entry point
    }

    /**
     * Places players on the game grid based on the number of players.
     *
     * @param nb      The number of players.
     * @param grid    The 2D array representing the game grid.
     * @param players An array of Player objects representing the players.
     */
    public static void setPlayers(int nb, String[][] grid, Player[] players) {
        switch (nb) {
            case 1:
                grid[4][5] = "J"; // Places the first player in a predefined position
                break;
            case 2:
                grid[4][5] = "🧑‍🏭"; // Places the first player
                players[0].x = 5;
                players[0].y = 4;

                grid[4][6] = "🧞"; // Places the second player
                players[1].x = 6;
                players[1].y = 4;
                break;
        }
    }

    /**
     * Prompts the user to select a cell to destroy and updates the game grid.
     * <p>
     * If the input is valid and the cell is empty, it is marked as destroyed ("❌").
     * The method handles errors such as invalid input or out-of-bounds coordinates.
     * </p>
     *
     * @param grid The 2D array representing the game grid.
     */
    public static void destroyer(String[][] grid) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a cell to destroy (format: row,column):");
        String targetCell = scanner.nextLine();

        try {
            String[] coordinates = targetCell.split(",");
            if (coordinates.length != 2) {
                System.out.println("Invalid input. Please enter in the format row,column.");
                Security.antiSpam();
                destroyer(grid);
                return;
            }

            int y = Integer.parseInt(coordinates[0].trim());
            int x = Integer.parseInt(coordinates[1].trim());

            if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
                System.out.println("Coordinates are out of bounds.");
                Security.antiSpam();
                destroyer(grid);
                return;
            }

            if (!grid[y][x].equals(Grid.emptyCase)) {
                System.out.println("This cell is not empty.");
                Security.antiSpam();
                destroyer(grid);
                return;
            }

            grid[y][x] = Grid.destroyCase;
            System.out.println("Cell (" + y + "," + x + ") has been destroyed.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter numbers for the coordinates.");
            Security.antiSpam();
            destroyer(grid);
            return;
        }
    }

    /**
     * Allows the user to destroy two cells on the game grid.
     *
     * @param grid The 2D array representing the game grid.
     */
    public static void doublecase(String[][] grid) {
        System.out.println("You can destroy two cells.");
        destroyer(grid);
        destroyer(grid);
    }

    /**
     * Checks whether the player is surrounded by obstacles or enemies and updates their alive status.
     *
     * @param grid   The 2D array representing the game grid.
     * @param player The Player object representing the player's state and position.
     */
    public static void death(String[][] grid, Player player) {
        int x = player.x;
        int y = player.y;

        boolean top = isBlocked(grid, y - 1, x);
        boolean bottom = isBlocked(grid, y + 1, x);
        boolean left = isBlocked(grid, y, x - 1);
        boolean right = isBlocked(grid, y, x + 1);

        // Si le joueur est entouré de blocages, il meurt
        if (top && bottom && left && right) {
            player.isalive = false;
            System.out.println(player.name + " is dead.");
            checkVictory(grid, player);
        } else {
            player.isalive = true;  // Le joueur est encore en vie
        }
    }


    /**
     * Checks if a specific cell is blocked by an obstacle or enemy.
     *
     * @param grid The 2D array representing the game grid.
     * @param y    The vertical position of the cell.
     * @param x    The horizontal position of the cell.
     * @return True if the cell is blocked; false otherwise.
     */
    private static boolean isBlocked(String[][] grid, int y, int x) {
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
            return true;
        }
        return !grid[y][x].equals(Grid.emptyCase);
    }

    public static void checkVictory(String[][] grid, Player player) {
        // Compte les joueurs vivants
        int aliveCount = 0;
        Player winner = null;

        for (Player p : Main.players) {
            if ( p != null && p.isalive) {
                aliveCount++;
                winner = p;  // Si un joueur est vivant, c'est potentiellement le gagnant
            }
        }

        // Vérifie le nombre de joueurs vivants
        switch (aliveCount) {
            case 1:
                System.out.println("The winner is " + winner.name + "!");
                Banner.printEndGame();
                System.exit(0); // Closes program with output status 0 (successful)
                break;
            case 0:
                System.out.println("Equality, Looser!");
                Banner.printEndGame();
                System.exit(0); // Closes program with output status 0 (successful)
                break;
            default:
                // More than one player left alive, so no victory yet
                break;
        }
    }

}
