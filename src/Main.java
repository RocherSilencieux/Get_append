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
    public static byte choice;
    public static Grid grid = new Grid();
    public static Player[] players = new Player[4];
    public static Player[] allPlayers;
    public static boolean endCondition = true;
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

        allPlayers = (Player[]) Serialization.deserialize("infoUser.ser");


        // Display the menu if tape flag is set
        if (Menu.tape) {
            Menu.createMenu();
        }

        // Handle menu choices
        switch (Menu.choice) {
            case 1:
                System.out.println("Play 🕹️");
                Menu.tape = false;
                try
                {
                    System.out.println("Enter player count from 2 to 4: ");
                    choice = sc.nextByte();

                }
                catch (Exception e)
                {
                }
                while(choice != 2 && choice != 4 && choice != 3)
                {
                    //choose a number of player that supports wrong answers
                        System.out.println("Enter player count from 2 to 4: ");
                        choice = sc.nextByte();
                }
                sc.nextLine();
                //choose the name of each player
                for (byte i = 0; i < choice; i++)
                {
                    String name = "";
                    while(name == "")
                    {
                        System.out.println("What is the name of Player "+ i);
                        name = sc.nextLine();
                        players[i] = new Player(name);
                        System.out.println("saved");
                    }
                }
                Serialization.serialize("infoUser.ser",players);
                Game.setPlayers(choice,grid.grid,players);
                Grid.printGrid(grid.grid);

                while(endCondition)
                {
                    for(Player p : players)
                    {
                        for(Player ps : players){
                            if(!(ps == null))
                            {
                                Game.death(grid.grid, ps);
                                endCondition = Game.checkVictory(grid.grid, ps);
                            }
                        }


                        if(!(p == null)) {
                            if (p.isalive) {

                                PlayerMovement.move(grid.grid, p);
                                Grid.printGrid(grid.grid);
                                Game.destroyer(grid.grid);
                                Grid.printGrid(grid.grid);
                            }
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Rules 📜");
                Menu.tape = false;
                // Create a File object pointing to the file
                File files = new File("src/Rules");

                // Try to open the file to read it
                try {
                    // Create a Scanner object to read the file contents
                    Scanner fileScanner = new Scanner(files);
                    // As long as there are still lines to read in the file...
                    while (fileScanner.hasNextLine()) {
                        // Display each line of the file
                        System.out.println(fileScanner.nextLine());
                    }

                    // If the specified file is not found, the program catches the 'FileNotFoundException' exception.
                } catch (FileNotFoundException e) {
                    // Displays an error message
                    System.out.println("Fichier Rules introuvable !");
                }
                break;
            case 3:
                System.out.println("Option ⚙️");
                Menu.tape = false;
                break;
            case 4 :
                System.out.println("Score 🏆");
                System.out.print("Order Descending : 1 Order Ascending : 2 ➡ ");
                Menu.tape = false;
                // Read the variable tape by the user
                sc.nextLine();
                int sort = sc.nextInt();
                switch (sort) {
                    case 1:
                        // Call the descending sorting method
                        Scores.descendingSort(players_);
                        // Displays the top 10 players after the sort
                        Scores.displayTop10(players_);
                        break;
                    case 2:
                        // Call the ascending sorting method
                        Scores.ascendingSort(players_);
                        // Displays the top 10 players after the sort
                        Scores.displayTop10(players_);
                        break;
                    default: // if no specific cases are found
                        // Call the descending sorting method
                        Scores.descendingSort(players_);
                        // Displays the top 10 players after the sort
                        Scores.displayTop10(players_);
                        break;
                }
                break;
            case 5:
                System.out.println("❌ Quitter");
                break;
            default: // if no specific cases are found  //
                Menu.tape = false;
                System.out.println("❌ Invalid choice, try again please.");
        }
        System.out.println();
    }
}