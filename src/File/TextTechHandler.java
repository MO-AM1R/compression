package File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextTechHandler extends FileHandle{

    public TextTechHandler(String fileName){
        String directory = System.getProperty("user.dir") + "\\src\\File\\";
        file = new File(directory + fileName) ;
    }

    /**
     * <pre>
     * This function Reads the content of the file and returns it as a string
     * {@code fileContent}.</pre>
     * <blockquote><p>
     *
     * @return <strong style="color: 'white'">The content of the file as a string.</strong>
     * </blockquote></p>
     */
    @Override
    public String read() {
        StringBuilder fileContent = new StringBuilder();
        try {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                fileContent.append(fileReader.nextLine()).append('\n');
            }
            fileContent.deleteCharAt(fileContent.length() - 1) ;
            fileReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("The file name is incorrect");
            throw new RuntimeException(e);
        }

        return fileContent.toString();
    }

    /**
     * <pre>
     * This function Writes the content of the {@code content}.
     *      It creates a new file {@code output} and write into the {@code content}.
     * </pre>
     * <blockquote>
     * <p>
     *
     * @param content
     *         <strong style="color: 'white'">
     *         It contains the content which will write in the file
     *         </strong>
     *
     * @author <strong style="color: 'white'"> Lee Boynton
     * </strong>
     * </p>
     * </blockquote>
     */
    @Override
    public void write(String content) {
        String directory = System.getProperty("user.dir") + "/src/File/";

        try (FileWriter outputFile = new FileWriter(directory + "output.txt")) {
            outputFile.write(content);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
