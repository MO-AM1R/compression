import Run.Run;
import TypesOfCompression.CompressionAlgorithm;
import TypesOfCompression.LZ77;
import Process.Process;
import Process.Compress;
import Process.Decompress;
import TypesOfCompression.LZ78;

public class Main {
    public static void main(String[] args) {
        CompressionAlgorithm compressionAlgorithm = new LZ78() ;
        Process process = new Decompress() ;
        Run run = new Run(process, compressionAlgorithm);
        run.run();
    }
}