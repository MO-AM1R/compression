package Process;
import TypesOfCompression.CompressionAlgorithm;

public class Compress implements Process{
    @Override
    public String runProcess(CompressionAlgorithm compressionAlgorithm, String content) {
        String ans = compressionAlgorithm.compress(content) ;
        ans = ans.replaceAll("\n", ">\n<") ;
        ans = '<' + ans + '>' ;

        return ans ;
    }
}