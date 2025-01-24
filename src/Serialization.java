import java.io.*;
public class Serialization
{
    public static void serialize(String path, Object[] object)
    {
            try {
                FileOutputStream fileOut = new FileOutputStream("infoUser.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(object);
                out.close();
                fileOut.close();
            } catch (Exception a) {
                System.out.println("Error");
            }

    }
    public static Object deserialize(String path)
    {
        Object[] object;
        try
        {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            object = (Object[]) in.readObject();
            in.close();
            fileIn.close();
            return object;
        }catch(Exception e)
        {
        }
        return null;
    }
}
