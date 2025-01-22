import java.util.Scanner;

public class Game {
    public static void setPlayers(int nb, String[][] grid)
    {
        switch(nb)
        {
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
