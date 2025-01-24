import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * The {@code Music} class plays audio files in WAV format.
 * The main method of this class is {@link #playMusic(String)}, which plays a given audio file.
 */

public class Music {

    /**
     * Main method that executes the program.
     * Calls the {@link #playMusic(String)} method with a specified audio file path.
     */

    public static void main(String args) {

        // Calls the playMusic method with the audio file path
        playMusic("src\\music\\retro_8bit_happy_adventure(wav).wav");
    }

    /**
     * Plays an audio file specified by its path.
     * This method opens the audio file, creates an audio stream, loads it into a clip, then plays the sound.
     *
     * @param filePath the path of the audio file to be played.
     * @throws UnsupportedAudioFileException if the audio file format is not supported.
     * @throws IOException if an error occurs while reading the file.
     * @throws LineUnavailableException if the necessary audio resources are not available.
     */

    public static void playMusic(String filePath) {
        try {
            // Create a File object representing the audio file
            File audioFile = new File(filePath);
            // Get audio from file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            // Create a Clip object to manipulate the sound
            Clip clip = AudioSystem.getClip();
            // Open audio into clip
            clip.open(audioStream);
            // Play the clip
            clip.start();

        }
        catch (UnsupportedAudioFileException e) {
            // Error handling if audio file format is not supported
            System.err.println("Format de fichier audio non supporté : " + e.getMessage());
        }
        catch (IOException e) {
            // Error handling related to audio file play
            System.err.println("Erreur lors de la lecture du fichier audio : " + e.getMessage());
        }
        catch (LineUnavailableException e) {
            // Error handling if audio resources not available
            System.err.println("Ressources audio non disponibles : " + e.getMessage());
        }
    }
}
