import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int totalInserts = 10_000;
        Map<Integer, Integer> squareValues = new HashMap<>();

        IntStream.range(0, totalInserts)
                .parallel()
                .forEach(x -> squareValues.put(x, x));

        System.out.println("Expected size " + totalInserts + " actual " + squareValues.size());
    }
}
