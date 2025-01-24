import java.util.Scanner;

/**
 * The Menu class provides an interactive menu system for the user to interact with.
 * It includes methods to display the menu and retrieve user input.
 */
public class Menu {

    /**
     * A control variable used to determine whether to continue prompting the user.
     */
    public static boolean tape = true;

    /**
     * Stores the user's menu choice as an integer.
     */
    public static int choice;

    /**
     * Displays the main menu with the available options to the user.
     * The menu includes the following options:
     * <ul>
     *     <li>1️⃣ Play</li>
     *     <li>2️⃣ Rules</li>
     *     <li>3️⃣ Party loader</li>
     *     <li>4️⃣ Score</li>
     *     <li>5️⃣ Quit</li>
     * </ul>
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
     * Displays the menu and manages user input until a valid choice (1-5) is entered.
     * <p>
     * This method uses a {@link Scanner} to read input from the user and ensures the input is valid.
     * If the input is not a valid integer, the user is prompted again with an error message.
     * </p>
     */
    public static void createMenu() {

        Scanner scanner = new Scanner(System.in); // Scanner to get user input from the keyboard

        do {
            if (tape) {
                printMenu();
                System.out.print("➡ Enter your choice: ");
            }

            /**
             * Ensures the user enters a valid integer.
             * If the input is invalid (not an integer), the user is prompted to try again.
             */
            while (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid input. Please enter a number.");
                System.out.print("➡ Enter your choice: ");
                scanner.next(); // Clears the invalid input
            }

            choice = scanner.nextInt(); // Retrieves the user's choice
            if (choice <= 5) {
                tape = false; // Exit the loop when a valid choice is made
            }

        } while (tape);
        System.out.println("✅ Program completed.");
    }



}
