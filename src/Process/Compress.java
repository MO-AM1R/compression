package Process;
import TypesOfCompression.CompressionAlgorithm;

public class Compress implements Process{
    @Override
    public String runProcess(CompressionAlgorithm compressionAlgorithm, String content) {
        return compressionAlgorithm.compress(content) ;
    }
}