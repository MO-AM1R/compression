package TypesOfCompression;
import java.util.List;

/**
 *<pre>
 *This class represent the LZ77 algorithm and it's method
 *it implements {@link CompressionAlgorithm} interface
 *</pre>
 *
 * <blockquote>
 * @version <strong style="color: 'white'">1.1</strong>
 * @author <strong style="color: 'white'">Mohamed Amir</strong>
 * </blockquote>
 */
public class LZ77 implements CompressionAlgorithm{

    /**
     *<pre>
     *This method {@code compress} it compress the
     *content of {@code content} and return the tags
     *as {@code String}
     *</pre>
     *
     * <blockquote>
     * @author <strong style="color: 'white'">Mohamed Amir</strong>
     * </blockquote>
     */
    @Override
    public String compress(String content) {
        int i = -1, j = 0;
        StringBuilder buffer = new StringBuilder();
        StringBuilder tags = new StringBuilder();

        while (j < content.length()){
            StringBuilder currentPattern = new StringBuilder();
            currentPattern.append(content.charAt(j)) ;
            int position = 0, length = 0;

            while (j + 1 < content.length()){
                if (buffer.toString().contains(currentPattern.toString())){
                    position = i - buffer.lastIndexOf(currentPattern.toString()) + 1;
                    buffer.append(content.charAt(j));
                    currentPattern.append(content.charAt(++j)) ;
                }
                else{
                    break ;
                }
            }

            if (position == 0){
                tags.append("<").append(position).append(", ")
                        .append(length).append(", ").append(content.charAt(j)).append(">\n");
            }
            else{
                length = currentPattern.length() - 1;
                tags.append("<").append(position).append(", ").append(length)
                        .append(", ").append(currentPattern.toString().charAt(currentPattern.length() - 1))
                        .append(">\n");
            }
            buffer.append(content.charAt(j));
            i = buffer.length() - 1;
            ++j ;
        }

        return tags.substring(0, tags.length() - 1);
    }

    /**
     *<pre>
     *This method {@code deCompress} it decompress the
     *content of {@code content} and return the text
     *as {@code String}
     *</pre>
     *
     * <blockquote>
     * @author <strong style="color: 'white'">Mohamed Amir</strong>
     * </blockquote>
     */
    @Override
    public String deCompress(List<String> tags) {
        StringBuilder text = new StringBuilder();

        for (String ele : tags) {
            List<String> listTagInfo = List.of(ele.split(" "));

            int position = Integer.parseInt(listTagInfo.get(0));
            int length = Integer.parseInt(listTagInfo.get(1));
            char nextChar = listTagInfo.get(2).charAt(0);

            if (position == 0) {
                text.append(nextChar);
            } else {
                int counter = 0;
                int l = text.length();

                while (length-- > 0) {
                    text.append(text.toString().charAt(l - position + counter++));
                }
                text.append(nextChar);
            }
        }

        return text.toString();
    }
}
