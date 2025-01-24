import java.io.*;

/**
 * The {@code Serialization} class provides methods for serializing and deserializing objects to and from files.
 * This class allows saving and loading objects in a binary format to preserve their state between executions.
 */
public class Serialization {

    /**
     * Serializes an array of objects and saves it to the specified file path.
     * <p>
     * This method writes the provided objects to a file. If the file already exists, it appends the objects to it.
     * </p>
     *
     * @param path   the file path where the objects should be serialized.
     * @param object the array of objects to be serialized.
     */
    public static void serialize(String path, Object[] object) {
        try {
            // Attempt to read from an existing file (for appending data)
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            in.close();
            fileIn.close();

            // Appends data to the existing file
            FileOutputStream fileOut = new FileOutputStream("infoUser.ser", true);
            ObjectOutputStream os2 = new ObjectOutputStream(fileOut) {
                // Override method to avoid adding a stream header for each object
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };

            os2.writeObject(object);
            os2.close();

        } catch (Exception e) {
            // Fallback in case of an error during the appending process
            try {
                // If the file doesn't exist or an error occurs, create a new one
                FileOutputStream fileOut = new FileOutputStream("infoUser.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(object);
                out.close();
                fileOut.close();
            } catch (Exception a) {
                // Handle any exceptions during the creation of the new file
                System.out.println("Error");
            }
        }
    }

    /**
     * Deserializes an object from the specified file path.
     * <p>
     * This method reads an object from a file, restoring its state from a previously serialized file.
     * </p>
     *
     * @param path the file path from which the object should be deserialized.
     * @return the deserialized object, or {@code null} if an error occurred during deserialization.
     */
    public static Object deserialize(String path) {
        Object object;
        try {
            // Open the file and read the serialized object
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            object = in.readObject();
            in.close();
            fileIn.close();
            return object;
        } catch (Exception e) {
            // Handle any exceptions during deserialization
        }
        return null;
    }
}
