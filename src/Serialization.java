import java.io.*;
public class Serialization
{
    public static void serialize(String path, Object object)
    {
        try {
            System.out.println("test");
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            in.close();
            fileIn.close();
            FileOutputStream fileOut = new FileOutputStream("infoUser.ser",true);
            ObjectOutputStream os2 = new ObjectOutputStream(fileOut) {
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };

            os2.writeObject(object);
            os2.close();

        }catch(Exception e) {
            System.out.println("test");
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

    }
    public static Object deserialize(String path)
    {

        Object object;
        Object[] test;
        try
        {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            object = in.readObject();
            in.close();
            fileIn.close();
            return object;
        }catch(Exception e)
        {
        }
        return null;
    }
}
