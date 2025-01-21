package grid;

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
                grid[4][5] = "J1";
                grid[4][6] = "J2";
                break;
        }

    }
}
