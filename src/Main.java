import grid.Grid;

import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static byte choice;
    public static Grid grid = new Grid();
    public static Player[] players = new Player[4];
    public static Player test;
    public static void main(String[] args)
    {
        try
    {
        System.out.println("Enter player count from 2 to 4: ");
        choice = sc.nextByte();

    }
    catch (Exception e)
    {
    }
        while(choice != 2 && choice != 4 && choice != 3)
        {
            //choose a number of player that supports wrong answers
            try
            {
                System.out.println("Enter player count from 2 to 4: ");
                choice = sc.nextByte();

            }
            catch (Exception e)
            {
            }
            System.out.println("Wrong answer");
        }
        //choose the name of each player
        for (byte i = 0; i < choice; i++)
        {
            System.out.println("What is the name of Player "+ i);
            sc.nextLine();
            String name = sc.nextLine();
            players[i] = new Player(name);
            Serialization.serialize("infoUser.ser",players[i]);
            System.out.println("saved");

        }
        //create the grid and spawn in the players
        System.out.println();
        Game.setPlayers(choice,grid.grid);
        Grid.printGrid(grid.grid);

        test = (Player) Serialization.deserialize("infoUser.ser");
        System.out.println(test.name);
    }
}