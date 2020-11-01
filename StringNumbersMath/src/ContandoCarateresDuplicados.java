import java.util.HashMap;
import java.util.Map; 
import java.util.stream.Collectors;  

public class ContandoCarateresDuplicados {
    
    public static void main(String[] args) {
        System.out.println(contar("sempere"));
        System.out.println(contarJava8("sempere"));
        

    }

    // Esta forma es iterando el string

    public static Map<Character, Integer> contar(String str) {

        Map<Character , Integer> result = new HashMap<>();
       
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result.compute(c, (key, value) -> (value == null) ? 1 : ++value); 
          
        }


        return result;
        
    }
    

    //Esta es con Java 8
    public static Map<Character, Long> contarJava8(String str) {


        return str.chars().mapToObj(x -> (char)x).collect(Collectors.groupingBy( c -> c, Collectors.counting()));
    }




}
