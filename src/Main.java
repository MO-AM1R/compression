import Process.Process ;
import Process.Decompress ;
import TypesOfCompression.CompressionAlgorithm;
import TypesOfCompression.LZ77;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Process process = new Decompress() ;
        process.runProcess(new LZ77()) ;
        System.out.println("Hello world!");
    }
}