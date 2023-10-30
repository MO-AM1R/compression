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
                tags.append("<").append('0').append(", ")
                        .append(currentPattern).append(">");
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
        StringBuilder text = new StringBuilder();
        Map<String, Integer> dictionary = new HashMap<>() ;
        int counter = 1;

        for (String ele : tags) {
            List<String> listTagInfo = List.of(ele.split(" "));
            int position = Integer.parseInt(listTagInfo.get(0));
            char nextChar = listTagInfo.get(1).charAt(0);

            if (position == 0){
                text.append(nextChar) ;
                dictionary.put(nextChar + "", counter++) ;
                continue;
            }
            
            String pattern = "";
            for (Map.Entry<String, Integer> entry:
                 dictionary.entrySet()) {
                if (entry.getValue() == position){
                    pattern = entry.getKey() + nextChar;
                }
            }
            text.append(pattern) ;
            dictionary.put(pattern, counter++) ;
        }

        return text.toString();
    }
}