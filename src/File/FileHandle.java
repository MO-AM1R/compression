package File;
import java.io.File;

/**
 * <p>
 *     The class {@link FileHandle} class represents a file containing content that can be compressed or decompressed.
 *     It provides methods for reading the content of the file.
 * </p>
 * <blockquote><p>
 *  @author  <strong style="color: 'white'">Mohamed Amir</strong>
 *  @version <strong style="color: 'white'">1.0.2</strong>
 * </blockquote></p>
 */
public abstract class FileHandle {
    protected File file ;

    /**
     * <pre>
     * This function Reads the content of the file and returns it as a string
     * {@code fileContent}.</pre>
     * <blockquote><p>
     * @return <strong style="color: 'white'">The content of the file as a string.</strong>
     * </blockquote></p>
     */
    abstract public String read() ;

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
    public abstract void write(String content) ;
}