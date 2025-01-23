import grid.Grid;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static byte choice;
    public static Grid grid = new Grid();
    public static Player[] players = new Player[4];
    public static Player test;
    public static void main(String[] args)

    {

        // Importation de la liste des joueurs depuis PlayerData
        List<String[]> players_ = Scores.getScores();


        test = (Player) Serialization.deserialize("infoUser.ser");
        System.out.println(test.name);
        if (Menu.tape) {
            Menu.createMenu();
        }
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
                    try
                    {
                        System.out.println("Enter player count from 2 to 4: ");
                        choice = sc.nextByte();

                    }
                    catch (Exception e)
                    {
                    }
                    System.out.println("Wrong answer");
                }
                //choose the name of each player
                for (byte i = 0; i < choice; i++)
                {
                    System.out.println("What is the name of Player "+ i);
                    sc.nextLine();
                    String name = sc.nextLine();
                    players[i] = new Player(name);
                    Serialization.serialize("infoUser.ser",players[i]);
                    System.out.println("saved");

                }
                Game.setPlayers(choice,grid.grid);
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
        //create the grid and spawn in the players
        System.out.println();
        Game.setPlayers(choice,grid.grid);
        Grid.printGrid(grid.grid);
    }
}