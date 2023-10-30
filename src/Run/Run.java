package Run;
import File.FileHandle;
import Process.Process ;
import TypesOfCompression.CompressionAlgorithm;

/**
 * <pre>
 * This class will handle the run of program
 *    - will compress files or decompress
 *    - will handle output and input files
 * </pre>
 * <blockquote>
 *  @author <strong style="color: 'white'">Mohamed Amir</strong>
 *  @version <strong style="color: 'white'">1.0</strong>
 *  </blockquote>
 */
public class Run {
    Process process ;
    CompressionAlgorithm compressionAlgorithm ;
    FileHandle fileHandle ;
    /**
     * <pre>
     * Constructor initialize the algorithm and the process
     * </pre>
     * <blockquote>
     *  @param p
     *      <strong style="color: 'white'">
     *          {@code p} to initialize the process
     *      </strong>
     *
     * @param algorithm
     *      <strong style="color: 'white'">
     *          {@code algorithm} to initialize the algorithm
     *      </strong>
     *  @author <strong style="color: 'white'">Mohamed Amir</strong>
     *  </blockquote>
     */
    public Run(Process p, CompressionAlgorithm algorithm, FileHandle file){
        process = p ;
        compressionAlgorithm = algorithm ;
        fileHandle = file ;
    }

    /**
     * <pre>
     * This method will call the algorithm
     * for specific process then write the
     * output into file
     * </pre>
     * <blockquote>
     *  @author <strong style="color: 'white'">Mohamed Amir</strong>
     *  </blockquote>
     */
    public void run(){
        String content1 = fileHandle.read() ;
        String content2 = process.runProcess(compressionAlgorithm, content1) ;
        fileHandle.write(content2);
    }
}
