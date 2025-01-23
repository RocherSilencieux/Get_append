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
                Music.main("src\\music\\retro_8bit_happy_adventure(wav).wav");
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