import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Chatbot bot = new Chatbot("data/knowledge.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("Hola, ¿en qué puedo ayudarte?");
        while (true) {
            System.out.println("Tú: ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("salir")) break;
            String response = bot.getResponse(input);
            System.out.println("Bot: " + response);
        }
        sc.close();
    }
    
}