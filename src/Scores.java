import java.util.List;

public class Scores {

    // Sort by insertion in ascending order
    public static void ascendingSort(List<String[]> players) {
        // Browse the list starting from the second element
        for (int i = 1; i < players.size(); i++) {
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

    // Sort by insertion in descending order
    public static void descendingSort(List<String[]> players) {
        // Browse the list starting from the second element
        for (int i = 1; i < players.size(); i++) {
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

    // Displays the top 10 sorted by score
    public static void displayTop10(List<String[]> players) {
        // Display a title for the list of top players
        System.out.println("\nTop 10 Players:");
        // Display the players by limiting the display to 10 players or less if it's smaller
        for (int i = 0; i < Math.min(10, players.size()); i++) {
            // Displays the ranking, the player name and the score
            System.out.println((i + 1) + ". " + players.get(i)[0] + " - " + players.get(i)[1]);
        }
    }
}
