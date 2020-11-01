import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseWords {
    
    private static final String ESPACIO_EN_BALNCO = " ";

    public static void main(String[] args) {

        System.out.println(reverseWords("Sempere mi rey"));
        System.out.println(reverseWordsJava8("Sempere mi rey"));
        System.out.println(reverseWordsStringBuilder("Sempere mi rey"));
        
    }

    
    public static String reverseWords(String str) {

        String[] palabras = str.split(ESPACIO_EN_BALNCO);
        StringBuilder strAlreves = new StringBuilder();

        for (String palabra : palabras) {
            StringBuilder palabraAlreves = new StringBuilder();
            for (int i = palabra.length()-1; i >= 0 ; i--) {
                palabraAlreves.append(palabra.charAt(i));
                
            }        
            strAlreves.append(palabraAlreves.toString())
                      .append(ESPACIO_EN_BALNCO);    
        }

        return strAlreves.toString();

    }

    // en Java 8 

    private static final Pattern PATTERN = Pattern.compile(" +");

    public static String reverseWordsJava8(String str) {

        return PATTERN.splitAsStream(str)
                      .map(p -> new StringBuilder(p).reverse())
                      .collect(Collectors.joining(" "));
        
    }

    //Utilizando unicamente el metodo reverse() de StringBuilder

    public static String reverseWordsStringBuilder(String str) {

        return new StringBuilder(str).reverse().toString();
    }

}
