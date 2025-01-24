import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class for managing the game flow, including menu navigation, player setup, and game execution.
 */
public class Main {

    // Scanner for user input
    public static Scanner sc = new Scanner(System.in);
    public static byte choice; // Player count choice
    public static Grid grid = new Grid(); // Game grid
    public static Player[] players = new Player[4]; // Array of players
    public static boolean endCondition = true; // Condition to terminate the game loop

    /**
     * Main method that initiates the game and handles menu options.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {

        Banner.printBanner();

        // List to store players' names and scores
        List<String[]> players_ = new ArrayList<>();

        // Add players and their scores to the list
        players_.add(new String[] { "Alice", "120" });
        players_.add(new String[] { "Bob", "150" });
        players_.add(new String[] { "Charlie", "90" });
        players_.add(new String[] { "Diana", "110" });
        players_.add(new String[] { "Eden", "145" });
        players_.add(new String[] { "Frank", "140" });
        players_.add(new String[] { "Grace", "95" });
        players_.add(new String[] { "Hank", "130" });
        players_.add(new String[] { "Ivy", "165" });
        players_.add(new String[] { "Jack", "155" });
        players_.add(new String[] { "Kevin", "80" });
        players_.add(new String[] { "Eve", "115" });

        // Display the menu if tape flag is set
        if (Menu.tape) {
            Menu.createMenu();
        }

        // Handle menu choices
        switch (Menu.choice) {
            case 1:
                System.out.println("Play 🕹️");
                Menu.tape = false;
                try {
                    System.out.println("Enter player count from 2 to 4: ");
                    choice = sc.nextByte();
                } catch (Exception e) {
                    // Handle invalid input
                }
                while (choice != 2 && choice != 3 && choice != 4) {
                    System.out.println("Enter player count from 2 to 4: ");
                    choice = sc.nextByte();
                }
                for (byte i = 0; i < choice; i++) {
                    System.out.println("What is the name of Player " + i + "?");
                    sc.nextLine(); // Clear buffer
                    String name = sc.nextLine();
                    players[i] = new Player(name);
                    System.out.println("Saved");
                }
                Serialization.serialize("infoUser.ser", players);
                Game.setPlayers(choice, grid.grid, players);
                Grid.printGrid(grid.grid);

                // Main game loop
                while (endCondition) {
                    for (Player p : players) {
                        for (Player ps : players) {
                            if (ps != null) {
                                Game.death(grid.grid, ps);
                            }
                        }
                        if (p != null && p.isalive) {
                            System.out.println("\nIt's " + p.name + "'s turn to play!");
                            PlayerMovement.move(grid.grid, p);
                            Grid.printGrid(grid.grid);
                            System.out.println();
                            Game.destroyer(grid.grid);
                            Grid.printGrid(grid.grid);
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Rules 📜");
                Menu.tape = false;
                File files = new File("src/Rules");
                try (Scanner fileScanner = new Scanner(files)) {
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    Security.antiSpam();
                    System.out.println("Rules file not found!");
                }
                break;
            case 3:
                System.out.println("Option ⚙️");
                Menu.tape = false;
                break;
            case 4:
                System.out.println("Score 🏆");
                System.out.print("Order Descending: 1, Order Ascending: 2 ➡ ");
                Menu.tape = false;
                sc.nextLine();
                int sort = sc.nextInt();
                switch (sort) {
                    case 1:
                        Scores.descendingSort(players_);
                        Scores.displayTop10(players_);
                        break;
                    case 2:
                        Scores.ascendingSort(players_);
                        Scores.displayTop10(players_);
                        break;
                    default:
                        Scores.descendingSort(players_);
                        Scores.displayTop10(players_);
                        break;
                }
                break;
            case 5:
                System.out.println("❌ Quit");
                break;
            default:
                Menu.tape = false;
                Security.antiSpam();
                System.out.println("❌ Invalid choice, please try again.");
        }
        System.out.println();
    }
}
