import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // To link the user command from the keyboard //
        int choice; // Initialisation of the variable choice //
        boolean tape = true;

        do {
            if (tape) {
                printMenu();
                System.out.print("➡ Entrez votre choix : ");
            }

            // This loop is used to verify if the user has typed in a number //
            while (!scanner.hasNextInt()) { // Execute while the user does not enter a valid character //
                System.out.println("❌ Invalid input. Please Enter a number.");
                System.out.print("➡ Enter your choice : ");
                scanner.next(); // Cleaning of the invalid enter //
            }

            choice = scanner.nextInt(); // Read the variable tape by the user //

            switch (choice) {
                case 1:
                    System.out.println("Play 🕹️");
                    tape = false;
                    break;
                case 2:
                    System.out.println("Rules 📜");
                    tape = false;
                    break;
                case 3:
                    System.out.println("Option ⚙️");
                    tape = false;
                    break;
                case 4 :
                    System.out.println("Score 🏆");
                    tape = false;
                    break;
                case 5:
                    System.out.println("❌ Quitter");
                    break;
                default: // if no specific cases are found  //
                    tape = false;
                    System.out.println("❌ Invalid choice, try again please.");
            }

        } while (choice != 5);

        scanner.close();
        System.out.println("✅ programme completed.");
    }

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
}
