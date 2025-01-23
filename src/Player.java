import java.io.*;
public class Player implements Serializable {
    public String name;
    public static int x;
    public static int y;
    public Player(String name)
    {
        this.name = name;
    }
}
