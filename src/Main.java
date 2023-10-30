import java.util.Scanner;
import File.*;
import Run.*;
import Process.* ;
import Process.Process ;
import TypesOfCompression.*;

public class Main {
    public static void main(String[] args) {
        CompressionAlgorithm compressionAlgorithm = new LZ77() ;
        Process process = new Compress() ;
        Scanner scanner = new Scanner(System.in) ;

        System.out.print("Please enter the file name ->");
        String fileName = scanner.nextLine() ;
        while (!fileName.contains(".txt")){
            System.out.print("file name is incorrect");
            fileName = scanner.nextLine() ;
        }

        FileHandle fileHandle = new FileHandle(fileName) ;
        Run run = new Run(process, compressionAlgorithm, fileHandle);
        run.run();
    }
}