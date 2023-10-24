package Process;
import TypesOfCompression.CompressionAlgorithm;
import java.util.List;

public class Compress implements Process{
    @Override
    public String runProcess(CompressionAlgorithm compressionAlgorithm, List<String> content) {
        return compressionAlgorithm.compress(content.get(0)) ;
    }
}
