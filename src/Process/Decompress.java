package Process;
import TypesOfCompression.CompressionAlgorithm;
import java.util.List;

public class Decompress implements Process{
    @Override
    public String runProcess(CompressionAlgorithm compressionAlgorithm, List<String> content) {
        return compressionAlgorithm.deCompress(content) ;
    }
}
