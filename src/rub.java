import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class rub {
    public static void main(String[] args) {
        Integer []a = {3,5,1,6};
        Stream<Integer> s = Arrays.stream(a);

        String [] b = {"asf","asf"};
        Stream<String> sm = Arrays.stream(b);

        try {
            Stream<String> stream = Files.lines(Paths.get("file.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
