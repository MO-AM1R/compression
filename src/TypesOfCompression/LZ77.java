package TypesOfCompression;

public class LZ77 implements CompressionAlgorithm{

    /**
     * <pre>
     *This method {@code compress} it compress the
     *content of {@code content} and return the tags
     *as {@code String}
     * </pre>
     *
     * <blockquote>
     * @version <strong style="color: 'white'">1.0.0</strong>
     * @author <strong style="color: 'white'">Mohamed Amir</strong>
     * </blockquote>
     */
    @Override
    public String compress(String content) {
        int i = -1, j = 0;
        StringBuilder buffer = new StringBuilder();
        StringBuilder tags = new StringBuilder();

        while (j < content.length()){
            if (i == -1){
                buffer.append(content.charAt(j));
                tags.append("<0, 0, ").append(content.charAt(j++)).append(">\n");
                ++i ;
            }
            else{
                StringBuilder currentPattern = new StringBuilder();
                currentPattern.append(content.charAt(j));
                int position, length ;
                String temp ;

                while (j + 1 < content.length()){
                    if (buffer.toString().contains(currentPattern.toString() + content.charAt(j + 1))){
                        currentPattern.append(content.charAt(++j)) ;
                        buffer.append(content.charAt(j)) ;
                    }
                    else{
                        break ;
                    }
                }

                if (!buffer.toString().contains(currentPattern.toString())){
                    position = 0;
                    length = 0 ;
                }
                else{
                    position = i - buffer.toString().lastIndexOf(currentPattern.toString()) + 1;
                    length = currentPattern.length() ;
                }

                if (j + 1 >= content.length()){
                    temp = "<" + position + ", " + length + ", " + currentPattern.toString().charAt(currentPattern.length() - 1) + ">\n";
                    buffer.append(currentPattern);
                }
                else{
                    if (position == 0){
                        temp = "<" + position + ", " + length + ", " + currentPattern + ">\n";
                        buffer.append(currentPattern);
                    }
                    else{
                        temp = "<" + position + ", " + length + ", " + content.charAt(++j) + ">\n";
                        buffer.append(currentPattern).append(content.charAt(j));
                    }
                }

                tags.append(temp);
                ++j ;
                i = buffer.length() - 1;
            }
        }

        return tags.toString();
    }

    /**
     * <pre>
     *This method {@code deCompress} it decompress the
     *content of {@code content} and return the text
     *as {@code String}
     * </pre>
     *
     * <blockquote>
     * @version <strong style="color: 'white'">1.0.0</strong>
     * @author <strong style="color: 'white'">Mohamed Amir</strong>
     * </blockquote>
     */
    @Override
    public String deCompress(String content) {

        return null;
    }
}
