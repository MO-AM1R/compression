import Run.Run;
import TypesOfCompression.CompressionAlgorithm;
import Process.Process;
import Process.Compress;
import TypesOfCompression.LZW;

public class Main {
    public static void main(String[] args) {
        CompressionAlgorithm compressionAlgorithm = new LZW() ;
        Process process = new Compress() ;
        Run run = new Run(process, compressionAlgorithm);
        run.run();
    }
}