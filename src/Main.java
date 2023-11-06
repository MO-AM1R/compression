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

        FileHandle fileHandle = new TextTechHandler(fileName) ;
        Run run = new Run(process, compressionAlgorithm, fileHandle);
        run.run();
    }
}

/*
    ABBBACBABCACAACBABCA
        <0, 0, A>
        <0, 0, B>
        <1, 2, A>
        <0, 0, C>
        <3, 2, B>
        <4, 1, A>
        <2, 2, A>
        <9, 5, A>

    ABAABABABABABABABABABA
        <0, 0, A>
        <0, 0, B>
        <2, 1, A>
        <3, 2, B>
        <2, 14, A>

    ABCABCABCABC
        <0, 0, A>
        <0, 0, B>
        <0, 0, C>
        <3, 8, C>

    aacaacabcabaaac
        <0, 0, a>
        <1, 1, c>
        <3, 4, b>
        <3, 3, a>
        <1, 2, c>

    ABAABABAABBBBBBBBBBBBA
        <0, 0, A>
        <0, 0, B>
        <2, 1, A>
        <3, 2, B>
        <5, 3, B>
        <1, 10, A>
 */