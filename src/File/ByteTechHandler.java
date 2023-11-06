package File;
import java.io.File;

public abstract class ByteTechHandler extends FileHandle{

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
    public abstract String read() ;

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
    public abstract void write(String content);
}
