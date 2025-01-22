import java.util.List;

/**
 * The {@code Scores} class provides methods for sorting and displaying a list of players with their scores.
 * The players are represented by {@code String} arrays, the first element being the player's name, at index 0,
 * and the second is the player's score, at index 1.
 */

public class Scores {

    /**
     * Sorts a list of players by their scores in ascending order using the sort by insertion.
     * @param players a list of players, where the player's name is at index 0 and their score is at index 1.
     */

    // Sort by insertion in ascending order
    public static void ascendingSort(List<String[]> players) {
        // Browse the list starting from the second element
        for (short i = 1; i < players.size(); i++) {
            // Retrieves the current element
            String[] current = players.get(i);
            int j = i - 1;

            // Moves the element bigger than the current element to the right by comparing them
            while (j >= 0 && Integer.parseInt(players.get(j)[1]) > Integer.parseInt(current[1])) {
                // Shifts the element at position j to position j + 1
                players.set(j + 1, players.get(j));
                // Decrement j
                j--;
            }
            // Places the current element at the correct position
            players.set(j + 1, current);
        }
    }

    /**
     * Sorts a list of players by their scores in descending order using the sort by insertion.
     * @param players a list of players, where the player's name is at index 0 and their score is at index 1.
     */

    // Sort by insertion in descending order
    public static void descendingSort(List<String[]> players) {
        // Browse the list starting from the second element
        for (short i = 1; i < players.size(); i++) {
            // Retrieves the current element
            String[] current = players.get(i);
            int j = i - 1;

            // Moves elements smaller than the current element to the right by comparing them
            while (j >= 0 && Integer.parseInt(players.get(j)[1]) < Integer.parseInt(current[1])) {
                // Shifts the element at position j to position j + 1
                players.set(j + 1, players.get(j));
                // Decrement j
                j--;
            }
            // Places the current element at the correct position
            players.set(j + 1, current);
        }
    }

    /**
     * Displays the top 10 players sorted by score.
     * If the list contains less than 10 players, all players are displayed.
     * Otherwise, only the top 10 scores are displayed.
     * @param players a list of players, where the player's name is at index 0 and their score is at index 1.
     */

    // Displays the top 10 sorted by score
    public static void displayTop10(List<String[]> players) {
        // Display a title for the list of top players
        System.out.println("\nTop 10 Players:");

        // Display the players by limiting the display to 10 players or less if it's smaller
        for (short i = 0; i < Math.min(10, players.size()); i++) {
            // Displays the ranking, the player name and the score
            System.out.println((i + 1) + ". " + players.get(i)[0] + " - " + players.get(i)[1]);
        }
    }
}
