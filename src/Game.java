public class Game
{
    /**
    spawn in the players in the grid depending on their number

    @param nb number of players
    @param grid the grid used by the current game
    @return void
     */
    public static void setPlayers(byte nb, String[][] grid)
    {
        switch(nb)
        {
            case 1:
                grid[4][5] = "J";
                break;
            case 2:
                grid[4][5] = "J1";
                grid[4][6] = "J2";
                break;
        }

    }
}
