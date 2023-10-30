package Process;
import TypesOfCompression.CompressionAlgorithm;

/**
 * <pre>
 *    This interface it handle the case will be made on the file
 *     {@code runProcess}: To run the process
 *     if it {@code Compress} or {@code Decompress}
 * </pre>
 * <blockquote>
 * @author <strong style="color: 'white'">Mohamed Amir</strong>
 * @version <strong style="color: 'white'">1.0</strong>
 * </blockquote>
 */
public interface Process {
    String runProcess(CompressionAlgorithm compressionAlgorithm, String content);
}
