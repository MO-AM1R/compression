package Process;
import File.FileHandle;
import TypesOfCompression.CompressionAlgorithm;

public class Compress implements Process{
    @Override
    public String runProcess(CompressionAlgorithm compressionAlgorithm) {
        String content = FileHandle.read() ;
        return compressionAlgorithm.compress(content) ;
    }
}
