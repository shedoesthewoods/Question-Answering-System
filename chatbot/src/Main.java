package chatbot;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    
    public static ArrayList<String> keywords = new ArrayList<>();
    static String pattern = "\\b(hi|hello)|(hi|hello)\\b"; 
    
    public static void main(String[] args) {
      
        keywords.add("kaç");
        keywords.add(pattern);
       
        Bot bot = new Bot();

        Scanner input = new Scanner(System.in);
        System.out.print("Sormak istediðiniz soru nedir?(Çýkýþ için 0 girin): ");
        String girdi = input.nextLine(); //nextLine yerine next metodu kullanýldýðýnda uygulama bozuluyor

       
         while(girdi.compareTo("0")!=0) {
            System.out.println("You: " + girdi);
            ArrayList<String> words = bot.parse(girdi);
            bot.botSay(bot.answer(words));
            System.out.print("Sormak istediðiniz soru nedir?(Çýkýþ için 0 girin): ");
            girdi = input.nextLine();
        }
    }
}