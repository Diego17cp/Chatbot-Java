import java.util.HashMap;
import java.util.Map;

public class SynonymMapper {
    private static final Map<String, String> synonymMap = new HashMap<>();

    static {
        // Saludos
        synonymMap.put("hola", "saludo");
        synonymMap.put("buenas", "saludo");
        synonymMap.put("qué onda", "saludo");
        synonymMap.put("que onda", "saludo");
        synonymMap.put("hey", "saludo");
        synonymMap.put("habla p mano", "saludo");
        
        // Despedidas
        synonymMap.put("adiós", "despedida");
        synonymMap.put("chao", "despedida");
        synonymMap.put("nos vemos", "despedida");

        // Otros
    }

    public static String mapToIntention(String input) {
        input = input.toLowerCase();
        for (Map.Entry<String, String> entry : synonymMap.entrySet()) {
            if (input.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
