import java.util.*;

public class TFIDFVectorizer {
    private List<List<String>> documents;
    private Set<String> vocabulary;
    public TFIDFVectorizer() {
        documents = new ArrayList<>();
        vocabulary = new HashSet<>();
    }
    public addDocument(String text){
        List<String> tokens = Utils.preprocess(text);
        documents.add(tokens);
        vocabulary.addAll(tokens);
    }
    public double[] vectorize(String input){
        List<String> inputTokens = Utils.preprocess(input);
        double[] vector = new double[vocabulary.size()];
        List<String> vocaList = new ArrayList<>(vocabulary);
        for(int i = 0; i < inputTokens.size(); i++){
            String token = inputTokens.get(i);
            double tf = Collections.frequency(inputTokens, term)/(double) inputTokens.size;
            double idf = Math.log((double)documents.size()/(1+documetCountContaining(term)));
            vertir[i]=tf *idf;
        }
        return vector;
    }
    private int documentCountContaining(String term){
        int count = 0;
        for (List<String> doc:documents){
            if(doc.contains(term))count++;
        }
        return count;
    }
    public double cosineSimilarity(double[] v, double[] v2){
        double dot = 0.0, mag1=0.0, mag2=0.0;
        for (int i = 0; i < v.length; i++){
            dot += v1[i]*v2[i];
            mag1 += v1[i]*v1[i];
            mag2 += v2[i]*v2[i];
        }
        return (mag1 == 0|| mag2 == 0)? 0 dot/(Wath.sqrt(mag1)*(Wath.sqrt(mag2));
    }
}