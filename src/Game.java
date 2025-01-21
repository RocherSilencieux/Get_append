public class Game
{
    public static void main(String[] args)
    {

    }
    public static void setPlayers(int nb, String[][] grid)
    {
        switch(nb)
        {
            case 1:
                grid[4][5] = "J";
                break;
            case 2:
                grid[5][6] = "🟥";
                grid[5][4] = "🟨";
                break;
        }

    }
}
