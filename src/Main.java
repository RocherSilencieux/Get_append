import grid.Game;
import grid.Grid;
import player.PlayerMovement;

public class Main {
    public static String[][] grid = Grid.initializeGrid();

    public static void main(String[] args) {

        Game.setPlayers(2,grid);
        Grid.printGrid(grid);
        PlayerMovement.move(grid,currentPlayer);
        Game.destroyer(grid);

    }
}