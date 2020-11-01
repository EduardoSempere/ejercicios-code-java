import java.util.HashMap;
import java.util.Map; 
import java.util.stream.Collectors;  

public class ContandoCarateresDuplicados {
    
    public static void main(String[] args) {
       
        System.out.println(String.valueOf(Character.toChars(128149)).length());
    //    System.out.println(String.valueOf(Character.toChars("a".codePointAt(0)+2)));
    //     System.out.println(contar("sempere"));
    //     System.out.println(contarJava8("sempere"));
        

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

    
    // Utilizando Unicode queda de la siuiente manera
     

    public static Map<String, Integer> contarUnicode(String str){

        
        Map<String, Integer> result = new HashMap<>(); 
        for (int i = 0; i < str.length(); i++) {
            int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp));
            if (Character.charCount(cp)==2) { 
                // En caso de que el unicode sea de los carateres 
                // que en su representación como string sea de 
                // longitud dos a vanzamos un lugar en mas en el for            
                i++;
            }
            result.compute(ch, (key,value) -> (value == null) ? 1 : ++value);

            
        }

        return result;
    }



    //Esta es con Java 8
    public static Map<Character, Long> contarJava8(String str) {


        return str.chars().mapToObj(x -> (char)x)
                          .collect(Collectors.groupingBy( c -> c, Collectors.counting()));
    }

    //Esta es unicode con java 8
    public static Map<String, Long> contarUnicodeJava8(String str) {

        return str.codePoints().mapToObj(x -> String.valueOf(Character.toChars(x)))
                  .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
    }



}
