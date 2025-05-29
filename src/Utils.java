import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Utils {
    public static List<String> preprocess(String text){
        text = text.toLowerCase(Locale.ROOT).replaceAll("[^a-záéíóúñúü\\s]","");
        return Arrays.asList(text.split("\\s+"));
    }
}