import java.io.*;
public class Player implements Serializable {
    public String name;
    public int x;
    public int y;
    public Player(String name)
    {
        this.name = name;
    }
}
