public class Main {
    public static String[][] grid = new String[10][11];
    public static void main(String[] args)
    {
        grid = Grid.initializeGrid();
        Game.setPlayers(2,grid);
        Grid.printGrid(grid);
    }
}