import java.util.Scanner;

public class Game
{
    public static void main(String[] args)
    {
    }
    public static void setPlayers(int nb, String[][] grid)
    {
        Scanner scanner = new Scanner(System.in); // To link the user command from the keyboard //
        System.out.print("➡ Input your number of players : ");
        nb = scanner.nextInt();

        switch(nb)
        {
            case 1:
                grid[4][5] = "J";
                break;
            case 2:
                grid[5][6] = "🟥";
                grid[5][4] = "🟨";
                break;
            case 3:
                grid[4][5] = "🟩";
                grid[5][6] = "🟥";
                grid[5][4] = "🟨";
                break;
            case 4:
                grid[4][6] = "🟧";
                grid[4][4] = "🟩";
                grid[5][6] = "🟥";
                grid[5][4] = "🟨";
                break;
        }

    }
}
