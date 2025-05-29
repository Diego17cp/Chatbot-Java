import java.util.Array;
import java.util.List;
import java.util.Locale;

public class Utils {
    public static List<String> preprocees(String text){
        text = text.toLowerCase(Locale.ROOT).replaceAll("[^a-záéíóúñúü\\s]","");
        return Arrays.asList(text.split("\\s+"));
    }
}