import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Scores} class provides methods for sorting and displaying a list of players with their scores.
 * The players are represented by {@code String} arrays, where the first element is the player's name (index 0)
 * and the second element is the player's score (index 1).
 */
public class Scores {

    /**
     * Each player is represented by an array of strings, where :
     * - The first cell contains the player's name.
     * - The second box contains the player's score.
     *
     * @return a list of string arrays representing players and their scores.
     */

    public static List<String[]> getScores() {
        // Création d'une liste de joueurs avec leur nom et score
        List<String[]> players_ = new ArrayList<>();
        // Add players and their scores to the list
        players_.add(new String[]{"Alice", "120"});
        players_.add(new String[]{"Bob", "150"});
        players_.add(new String[]{"Charlie", "90"});
        players_.add(new String[]{"Diana", "110"});
        players_.add(new String[]{"Eden", "145"});
        players_.add(new String[]{"Frank", "140"});
        players_.add(new String[]{"Grace", "95"});
        players_.add(new String[]{"Hank", "130"});
        players_.add(new String[]{"Ivy", "165"});
        players_.add(new String[]{"Jack", "155"});
        players_.add(new String[]{"Kevin", "80"});
        players_.add(new String[]{"Eve", "115"});

        // Returns the list of players and their scores
        return players_;
    }

    /**
     * Sorts a list of players by their scores in ascending order using insertion sort.
     * <p>
     * This method sorts the list of players by their score in ascending order,
     * where the player with the lowest score appears first.
     * </p>
     *
     * @param players a list of players, where each player is represented by a {@code String[]} array,
     *                where index 0 is the player's name and index 1 is the player's score.
     */
    public static void ascendingSort(List<String[]> players) {
        // Traverse the list starting from the second element
        for (short i = 1; i < players.size(); i++) {
            // Retrieve the current player
            String[] current = players.get(i);
            int j = i - 1;

            // Move the elements bigger than the current player to the right
            while (j >= 0 && Integer.parseInt(players.get(j)[1]) > Integer.parseInt(current[1])) {
                // Shift the element at position j to position j + 1
                players.set(j + 1, players.get(j));
                // Decrement j
                j--;
            }
            // Place the current player at the correct position
            players.set(j + 1, current);
        }
    }

    /**
     * Sorts a list of players by their scores in descending order using insertion sort.
     * <p>
     * This method sorts the list of players by their score in descending order,
     * where the player with the highest score appears first.
     * </p>
     *
     * @param players a list of players, where each player is represented by a {@code String[]} array,
     *                where index 0 is the player's name and index 1 is the player's score.
     */
    public static void descendingSort(List<String[]> players) {
        // Traverse the list starting from the second element
        for (short i = 1; i < players.size(); i++) {
            // Retrieve the current player
            String[] current = players.get(i);
            int j = i - 1;

            // Move elements smaller than the current player to the right
            while (j >= 0 && Integer.parseInt(players.get(j)[1]) < Integer.parseInt(current[1])) {
                // Shift the element at position j to position j + 1
                players.set(j + 1, players.get(j));
                // Decrement j
                j--;
            }
            // Place the current player at the correct position
            players.set(j + 1, current);
        }
    }

    /**
     * Displays the top 10 players sorted by their score.
     * <p>
     * If the list contains fewer than 10 players, all players are displayed.
     * Otherwise, only the top 10 players based on their scores are displayed.
     * </p>
     *
     * @param players a list of players, where each player is represented by a {@code String[]} array,
     *                where index 0 is the player's name and index 1 is the player's score.
     */
    public static void displayTop10(List<String[]> players) {
        // Display the title for the top players list
        System.out.println("\nTop 10 Players:");

        // Display the top 10 players or fewer if there are less than 10
        for (short i = 0; i < Math.min(10, players.size()); i++) {
            // Display the rank, player's name, and score
            System.out.println((i + 1) + ". " + players.get(i)[0] + " - " + players.get(i)[1]);
        }
    }
}