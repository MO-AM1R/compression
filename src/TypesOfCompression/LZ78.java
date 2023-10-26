package TypesOfCompression;

import java.util.List;

/**
 *<pre>
 *This class represent the LZ78 algorithm and it's method
 *it implements {@link CompressionAlgorithm} interface
 *</pre>
 *
 * <blockquote>
 * @version <strong style="color: 'white'">1.0</strong>
 * @author <strong style="color: 'white'">Mohamed Amir</strong>
 * </blockquote>
 */
public class LZ78 implements CompressionAlgorithm{
    /**
     * <pre>
     * This method {@code compress} it compress the
     * content of {@code content} and return the tags
     * as {@code String}
     * </pre>
     *
     * <blockquote>
     *
     * @param content
     *
     * @author <strong style="color: 'white'">Mohamed Amir</strong>
     * </blockquote>
     */
    @Override
    public String compress(String content) {
        return null;
    }

    /**
     * <pre>
     * This method {@code deCompress} it decompress the
     * content of {@code content} and return the text
     * as {@code String}
     * </pre>
     *
     * <blockquote>
     *
     * @param tags
     *
     * @author <strong style="color: 'white'">Mohamed Amir</strong>
     * </blockquote>
     */
    @Override
    public String deCompress(List<String> tags) {
        return null;
    }
}
