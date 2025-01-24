import java.io.*;

/**
 * The Player class represents a player in the game.
 * It stores the player's name, position, alive status, and skin (representation).
 * The class implements Serializable to allow saving and loading player data.
 */
public class Player implements Serializable {

    /**
     * The player's name.
     */
    public String name;

    /**
     * The horizontal position of the player on the game grid.
     */
    public int x;

    /**
     * The vertical position of the player on the game grid.
     */
    public int y;

    /**
     * The player's alive status.
     * If true, the player is alive; if false, the player is dead.
     */
    public boolean isalive = true;

    public int score;

    /**
     * Constructs a new Player with the given name.
     * Initializes the player's name and sets the initial values for the position and alive status.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
    }
}
