public class Main {
    public static String[][] grid = new String[10][11];
    public static void main(String[] args)
    {
        if (Menu.tape) {
            Menu.createMenu();
        }
        switch (Menu.choice) {
            case 1:
                System.out.println("Play 🕹️");
                Menu.tape = false;
                Game.setPlayers(Menu.choice,grid); // Call of setPlayers methode to generate grid //
                //Grid.printGrid(grid);//affiche la grille
                //Grid.initializeGrid();//le premier joueur joue
                break;
            case 2:
                System.out.println("Rules 📜");
                Menu.tape = false;
                break;
            case 3:
                System.out.println("Option ⚙️");
                Menu.tape = false;
                break;
            case 4:
                System.out.println("Score 🏆");
                Menu.tape = false;
                break;
            case 5:
                System.out.println("❌ Quitter");
                break;
            default: // if no specific cases are found  //
                Menu.tape = false;
                System.out.println("❌ Invalid choice, try again please.");
        }
    }
}