package Process;
import File.FileHandle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import TypesOfCompression.CompressionAlgorithm;

public class Decompress implements Process{
    @Override
    public String runProcess(CompressionAlgorithm compressionAlgorithm){
        String content = FileHandle.read() ;
        Scanner stringBuilder = new Scanner(content) ;
        List<String> tags = new ArrayList<>();

        while (stringBuilder.hasNextLine()){
            tags.add(stringBuilder.nextLine()) ;
        }

        return compressionAlgorithm.deCompress(tags) ;
    }
}
