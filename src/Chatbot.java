import java.io.*;
import java.util.*;

public class Chatbot {
    private Map<String, List<String>> intentResponses;
    private List<String> intents;
    private TFIDFVectorizer vectorizer;
    public Chatbot(String filepath) {
        intentResponses = new HashMap<>();
        intents = new ArrayList<>();
        vectorizer = new TFIDFVectorizer();
        loadKnowledge(filepath);
    }
    private void loadKnowledge(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String intent = parts[0].trim().toLowerCase();
                    String[] responses = parts[1].split("\\|");
                    intentResponses.put(intent, Arrays.asList(responses));
                    intents.add(intent);
                    vectorizer.addDocument(intent);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar: " + e.getMessage());
        }
    }
    public String getResponse(String input) {
        double[] inputVec = vectorizer.vectorize();
        double maxSim = -1;
        String bestIntent = null;
        for (String intent: intents) {
            double[] intentVec = vectorizer.vectorize(intent);
            double sim = vectorizer.cosineSimilarity(inputVec, intentVec);
            if (sim > maxSim) {
                maxSim = sim;
                bestIntent = intent;
            }
        }
        if (bestIntent != null && maxSim > 0.1) {
            List<String> responses = intentResponses.get(bestIntent);
            if (responses != null && !responses.isEmpty()) {
                return responses.get(new Random().nextInt(responses.size()));
            }
        }
        return "Lo siento, no entiendo tu pregunta.";
    }
}