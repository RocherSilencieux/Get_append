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


        test = (Player) Serialization.deserialize("infoUser.ser");
        System.out.println(test.name);
        if (Menu.tape) {
            Menu.createMenu();
        }
        switch (Menu.choice) {
            case 1:
                System.out.println("Play 🕹️");
                Menu.tape = false;
                Game.setPlayers(Menu.choice,grid.grid); // Call of setPlayers methode to generate grid //
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
        //create the grid and spawn in the players
        System.out.println();
        Game.setPlayers(choice,grid.grid);
        Grid.printGrid(grid.grid);
    }
}