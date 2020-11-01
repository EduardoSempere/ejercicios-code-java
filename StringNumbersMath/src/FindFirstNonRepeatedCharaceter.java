import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatedCharaceter {

    public static void main(String[] args) {
        System.out.println(contar("sempere"));
    }

    public static String contar(String str) {

        Map<Integer, Long> result = str.codePoints().mapToObj(x -> x)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
    
        int cp = result.entrySet().stream()
                            .filter(x -> x.getValue() == 1L)
                            .findFirst()
                            .map(m -> m.getKey())
                            .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));
    }
}
