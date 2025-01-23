import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Scores} class provides methods for sorting and displaying a list of players with their scores.
 * The players are represented by {@code String} arrays, the first element being the player's name, at index 0,
 * and the second is the player's score, at index 1.
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
     * Sorts a list of players by their scores in ascending order using the sort by insertion.
     * @param players_ a list of players, where the player's name is at index 0 and their score is at index 1.
     */

    // Sort by insertion in ascending order
    public static void ascendingSort(List<String[]> players_) {
        // Browse the list starting from the second element
        for (short i = 1; i < players_.size(); i++) {
            // Retrieves the current element
            String[] current = players_.get(i);
            int j = i - 1;

            // Moves the element bigger than the current element to the right by comparing them
            while (j >= 0 && Integer.parseInt(players_.get(j)[1]) > Integer.parseInt(current[1])) {
                // Shifts the element at position j to position j + 1
                players_.set(j + 1, players_.get(j));
                // Decrement j
                j--;
            }
            // Places the current element at the correct position
            players_.set(j + 1, current);
        }
    }

    /**
     * Sorts a list of players by their scores in descending order using the sort by insertion.
     * @param players_ a list of players, where the player's name is at index 0 and their score is at index 1.
     */

    // Sort by insertion in descending order
    public static void descendingSort(List<String[]> players_) {
        // Browse the list starting from the second element
        for (short i = 1; i < players_.size(); i++) {
            // Retrieves the current element
            String[] current = players_.get(i);
            int j = i - 1;

            // Moves elements smaller than the current element to the right by comparing them
            while (j >= 0 && Integer.parseInt(players_.get(j)[1]) < Integer.parseInt(current[1])) {
                // Shifts the element at position j to position j + 1
                players_.set(j + 1, players_.get(j));
                // Decrement j
                j--;
            }
            // Places the current element at the correct position
            players_.set(j + 1, current);
        }
    }

    /**
     * Displays the top 10 players sorted by score.
     * If the list contains less than 10 players, all players are displayed.
     * Otherwise, only the top 10 scores are displayed.
     * @param players_ a list of players, where the player's name is at index 0 and their score is at index 1.
     */

    // Displays the top 10 sorted by score
    public static void displayTop10(List<String[]> players_) {
        // Display a title for the list of top players
        System.out.println("\nTop 10 Players:");

        // Display the players by limiting the display to 10 players or less if it's smaller
        for (short i = 0; i < Math.min(10, players_.size()); i++) {
            // Displays the ranking, the player name and the score
            System.out.println((i + 1) + ". " + players_.get(i)[0] + " - " + players_.get(i)[1]);
        }
    }
}