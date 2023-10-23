package File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * <p>
 *     The class {@link FileHandle} class represents a file containing content that can be compressed or decompressed.
 *     It provides methods for reading the content of the file.
 * </p>
 * <blockquote><p>
 *  @author  <strong style="color: 'white'">Mohamed Amir</strong>
 *  @version <strong style="color: 'white'">1.0.1</strong>
 * </blockquote></p>
 */
public class FileHandle {

    /**
     * <pre>
     * This function Reads the content of the file and returns it as a string
     * {@code fileContent}.</pre>
     * <blockquote><p>
     * @param fileName <strong style="color: 'white'">It contains the file name which
     *                 will read from</strong>
     * @return <strong style="color: 'white'">The content of the file as a string.</strong>
     * </blockquote></p>
     */
    static public String read(String fileName) {
        String directory = System.getProperty("user.dir") + "/src/File/";
        if (!fileName.contains(".txt")) {
            fileName += ".txt";
        }

        File file = new File(directory + fileName);
        String fileContent = "";

        try {
            Scanner fileReader = new Scanner(file);
            if (fileReader.hasNextLine()) {
                fileContent += fileReader.nextLine() + '\n';
            }

            fileContent += fileReader.nextLine();
            fileReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("The file name is incorrect");
            throw new RuntimeException(e);
        }
        return fileContent;
    }

    /**
     * <pre>
     * This function Writes the content of the {@code content}.
     *      It creates a new file {@code output} and write into the {@code content}.
     * </pre>
     * <blockquote>
     * <p>
     *
     * @param content <strong style="color: 'white'">
     *                It contains the content which will write in the file
     *                </strong>
     * @author <strong style="color: 'white'">
     * Lee Boynton
     * </strong>
     * </p>
     * </blockquote>
     */
    static public void write(String content) {
        String directory = System.getProperty("user.dir") + "/src/File/";

        try (FileWriter outputFile = new FileWriter(directory + "output.txt")) {
            outputFile.write(content);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}