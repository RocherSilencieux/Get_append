import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static void chooseSort(List<String[]> players) {

        Scanner scanner = new Scanner(System.in); // To link the user command from the keyboard
        int sort = scanner.nextInt(); // Read the variable tape by the user

        switch (sort){
            case 1:
                // Calls up the descending sorting method
                descendingSort(players);
                break;
            case 2:
                // Calls up the ascending sorting method
                ascendingSort(players);
                break;
            default: // if no specific cases are found
                // Calls up the descending sorting method
                descendingSort(players);
                break;
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

    public static void main(String[] args) {

        // Création d'une liste de joueurs avec leur nom et score
        List<String[]> players = new ArrayList<>();

        // Add players and their scores to the list
        players.add(new String[]{"Alice", "120"});
        players.add(new String[]{"Bob", "150"});
        players.add(new String[]{"Charlie", "90"});
        players.add(new String[]{"Diana", "110"});
        players.add(new String[]{"Eden", "145"});
        players.add(new String[]{"Frank", "140"});
        players.add(new String[]{"Grace", "95"});
        players.add(new String[]{"Hank", "130"});
        players.add(new String[]{"Ivy", "165"});
        players.add(new String[]{"Jack", "155"});
        players.add(new String[]{"Kevin", "80"});
        players.add(new String[]{"Eve", "115"});

        // Calls up the ascending sorting method
        ascendingSort(players);
        // Calls up the descending sorting method
        descendingSort(players);

        // Display the top 10 after sorting
        displayTop10(players);
    }
}