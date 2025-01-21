public class Main {
    public static String[][] grid = Grid.initializeGrid();
    public static void main(String[] args)
    {
        Game.setPlayers(2,grid);
        Grid.printGrid(grid);
    }
}