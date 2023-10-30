package TypesOfCompression;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *<pre>
 *This class represent the LZW algorithm and it's method
 *it implements {@link CompressionAlgorithm} interface
 *</pre>
 *
 * <blockquote>
 * @version <strong style="color: 'white'">1.1</strong>
 * @author <strong style="color: 'white'">Mohamed Amir</strong>
 * </blockquote>
 */
public class LZW implements CompressionAlgorithm{

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
        Map<String, Integer> dictionary = new HashMap<>();
        int index = 128 ;

        for (char c = 'a'; c <= 'z'; c++) {
            dictionary.put(String.valueOf(c), (int) c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), (int) c);
        }

        StringBuilder tags = new StringBuilder() ;
        String foundChars = "" ;

        for (int i = 0; i < content.length(); i++) {
            String charsToAdd = foundChars + content.charAt(i) ;
            if (dictionary.containsKey(charsToAdd)){
                foundChars = charsToAdd ;
            }
            else{
                tags.append(dictionary.get(foundChars)) ;
                if (i != content.length() - 1){
                    tags.append('\n') ;
                }

                dictionary.put(charsToAdd, index++) ;
                foundChars = String.valueOf(content.charAt(i)) ;
            }
        }
        if (!foundChars.isEmpty()){
            tags.append(dictionary.get(foundChars)) ;
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
        Map<Integer, String> dictionary = new HashMap<>();
        int index = 128 ;

        for (char c = 'a'; c <= 'z'; c++) {
            dictionary.put((int) c, String.valueOf(c));
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put((int) c, String.valueOf(c));
        }

        StringBuilder text = new StringBuilder();
        StringBuilder previosText = new StringBuilder();

        for (int i = 0; i < tags.size(); i++) {
            int number = Integer.parseInt(tags.get(i)) ;
            if (dictionary.containsKey(number)){
                text.append(dictionary.get(number)) ;
                if (i == 0){
                    previosText = new StringBuilder(dictionary.get(number));
                    continue;
                }
                dictionary.put(index++, previosText.toString() + dictionary.get(number).charAt(0)) ;
                previosText = new StringBuilder(dictionary.get(number));
            }
            else{
                dictionary.put(index++, previosText.toString() + previosText.charAt(0)) ;
                text.append(previosText).append(previosText.charAt(0));
                previosText.append(previosText.charAt(0));
            }
        }

        return text.toString();
    }
}