package TypesOfCompression;
import java.util.List;

/**
 * <pre>
 *This interface represent the methods of each Compression Algorithm
 *it has two methods
 *    {@code compress}
 *    {@code decompress}
 * </pre>
 *
 * <blockquote>
 * @version <strong style="color: 'white'">1.0.1</strong>
 * @author <strong style="color: 'white'">Mohamed Amir</strong>
 * </blockquote>
 */
public interface CompressionAlgorithm {

    /**
     * <pre>
     *This method {@code compress} it compress the
     *content of {@code content} and return the tags
     *as {@code String}
     * </pre>
     *
     * <blockquote>
     * @author <strong style="color: 'white'">Mohamed Amir</strong>
     * </blockquote>
     */
    String compress(String content) ;

    /**
     * <pre>
     *This method {@code deCompress} it decompress the
     *content of {@code content} and return the text
     *as {@code String}
     * </pre>
     *
     * <blockquote>
     * @author <strong style="color: 'white'">Mohamed Amir</strong>
     * </blockquote>
     */
    String deCompress(List<String> tags) ;
}
