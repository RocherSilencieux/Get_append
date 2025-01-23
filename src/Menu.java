import java.util.Scanner;
/**
 * The Menu class displays an interactive menu and retrieves user choices.
 */
public class Menu {

    /**
     * Control variable for user input.
     */
    public static boolean tape = true;

    /**
     * Stores the user's choice.
     */
    public static int choice;

    /**
     * Displays the main menu with the available options.
     */
    public static void printMenu() {
        System.out.println("╔═══════════════════════╗");
        System.out.println("║         MENU          ║");
        System.out.println("╠═══════════════════════╣");
        System.out.println("║ 1️⃣      Play          ║");
        System.out.println("║ 2️⃣      Rules         ║");
        System.out.println("║ 3️⃣   Party loader     ║");
        System.out.println("║ 4️⃣      Score         ║");
        System.out.println("║ 5️⃣      Quit          ║");
        System.out.println("╚═══════════════════════╝");
    }

    /**
     * Manages menu display and user input.
     * Ensures the user enters a valid number between 1 and 5.
     */
    public static void createMenu() {

        Scanner scanner = new Scanner(System.in); // Scanner to get user input from the keyboard

        do {
            if (tape) {
                printMenu();
                System.out.print("➡ Enter your choice: ");
            }

            /**
             * Checks if the user has entered a valid number.
             * If the input is invalid, an error message is displayed.
             */
            while (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid input. Please enter a number.");
                System.out.print("➡ Enter your choice: ");
                scanner.next(); // Clears the invalid input
            }

            choice = scanner.nextInt(); // Retrieves the user's choice
            if (choice <= 5) {
                tape = false;
            }

        } while (tape);

        System.out.println("✅ Program completed.");
    }
}
//
//public class menu {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in); // To link the user command from the keyboard //
//        int choice; // Initialisation of the variable choice //
//        boolean tape = true;
//
//        // Création d'une liste de joueurs avec leur nom et score
//        List<String[]> players = new ArrayList<>();
//        // Add players and their scores to the list
//        players.add(new String[]{"Alice", "120"});
//        players.add(new String[]{"Bob", "150"});
//        players.add(new String[]{"Charlie", "90"});
//        players.add(new String[]{"Diana", "110"});
//        players.add(new String[]{"Eden", "145"});
//        players.add(new String[]{"Frank", "140"});
//        players.add(new String[]{"Grace", "95"});
//        players.add(new String[]{"Hank", "130"});
//        players.add(new String[]{"Ivy", "165"});
//        players.add(new String[]{"Jack", "155"});
//        players.add(new String[]{"Kevin", "80"});
//        players.add(new String[]{"Eve", "115"});
//
//        do {
//            if (tape) {
//                printMenu();
//                System.out.print("➡ Entrez votre choix : ");
//            }
//
//            // This loop is used to verify if the user has typed in a number //
//            while (!scanner.hasNextInt()) { // Execute while the user does not enter a valid character //
//                System.out.println("❌ Invalid input. Please Enter a number.");
//                System.out.print("➡ Enter your choice : ");
//                scanner.next(); // Cleaning of the invalid enter //
//            }
//
//            choice = scanner.nextInt(); // Read the variable tape by the user //
//
//            switch (choice) {
//                case 1:
//                    System.out.println("Play 🕹️");
//                    tape = false;
//                    break;
//                case 2:
//                    System.out.println("Rules 📜"+"\n");
//                    tape = false;
//                    // Create a `File` object pointing to the file
//                    File files = new File("src/Rules");
//
//                    // Try to open the file to read it
//                    try {
//                        // Create a `Scanner` object to read the file contents
//                        Scanner fileScanner = new Scanner(files);
//                        // As long as there are still lines to read in the file...
//                        while (fileScanner.hasNextLine()) {
//                            // Display each line of the file
//                            System.out.println(fileScanner.nextLine());
//                        }
//
//                        // If the specified file is not found, the program catches the 'FileNotFoundException' exception.
//                    } catch (FileNotFoundException e) {
//                        // Displays an error message
//                        System.out.println("Fichier Rules introuvable !");
//                    }
//                    break;
//                case 3:
//                    System.out.println("Option ⚙️");
//                    tape = false;
//                    break;
//                case 4 :
//                    System.out.println("Score 🏆");
//                    System.out.print("Order Descending : 1 Order Ascending : 2 ➡ ");
//                    tape = false;
//                    // Read the variable tape by the user
//                    int sort = scanner.nextInt();
//
//                    switch (sort) {
//                        case 1:
//                            // Call the descending sorting method
//                            Scores.descendingSort(players);
//                            // Displays the top 10 players after the sort
//                            Scores.displayTop10(players);
//                            break;
//                        case 2:
//                            // Call the ascending sorting method
//                            Scores.ascendingSort(players);
//                            // Displays the top 10 players after the sort
//                            Scores.displayTop10(players);
//                            break;
//                        default: // if no specific cases are found
//                            // Call the descending sorting method
//                            Scores.descendingSort(players);
//                            // Displays the top 10 players after the sort
//                            Scores.displayTop10(players);
//                            break;
//                    }
//                    break;
//                case 5:
//                    System.out.println("❌ Quitter");
//                    break;
//                default: // if no specific cases are found  //
//                    tape = false;
//                    System.out.println("❌ Invalid choice, try again please.");
//            }
//
//        } while (choice != 4);
//
//        scanner.close();
//        System.out.println("✅ programme completed.");
//    }
//
//    public static void printMenu() {
//        System.out.println("╔═══════════════════════╗");
//        System.out.println("║         MENU          ║");
//        System.out.println("╠═══════════════════════╣");
//        System.out.println("║ 1️⃣      Play          ║");
//        System.out.println("║ 2️⃣      Rules         ║");
//        System.out.println("║ 3️⃣   Party loader     ║");
//        System.out.println("║ 4️⃣      Score         ║");
//        System.out.println("║ 5️⃣      Quit          ║");
//        System.out.println("╚═══════════════════════╝");
//    }
//}
