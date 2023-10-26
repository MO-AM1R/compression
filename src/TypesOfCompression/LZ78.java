package TypesOfCompression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        StringBuilder tags = new StringBuilder() ;
        Map<String, Integer> dictionary = new HashMap<>();
        int index = 0, counter = 1;

        while (index < content.length()){
            if (!dictionary.containsKey(content.charAt(index) + "")){
                dictionary.put(content.charAt(index) + "", counter++) ;
                tags.append("<0, ").append(content.charAt(index++)).append(">\n");
                continue ;
            }

            StringBuilder currentPattern = new StringBuilder();
            currentPattern.append(content.charAt(index++)) ;
            while (index < content.length() &&
                    dictionary.containsKey(currentPattern.toString() + content.charAt(index))){
                currentPattern.append(content.charAt(index++)) ;
            }
            if (index < content.length()) {
                tags.append("<").append(dictionary.get(currentPattern.toString())).append(", ")
                        .append(content.charAt(index)).append(">\n");

                currentPattern.append(content.charAt(index++)) ;
                dictionary.put(currentPattern.toString(), counter++) ;
            }
            else{
                tags.append("<").append(dictionary.get(currentPattern.toString())).append(", ")
                        .append("null").append(">");
            }
        }

        return tags.toString() ;
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
