package chatbot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // input olarak girilebilecek keyword için açılmış arraylist
    public static ArrayList<String> keywords = new ArrayList<>();
    private static Scanner scanner = null;

    public static void main(String[] args) {
        // Bot sınıfında yazılan metodlar bot değişkeni üzerinden çalıştırılacak
        Bot bot = new Bot();
        createKeywords();

        // konsoldan okumalar
        scanner = new Scanner(System.in);
        System.out.print("Sormak istediğiniz soru nedir?(Çıkış için 0 girin): ");
        String girdi = scanner.nextLine(); //nextLine yerine next metodu kullanıldığında uygulama bozuluyor
        bot.regexGenerator(girdi);

        //kullanıcı çıkış yapmak isteyene kadar uygulamayı açık tutan döngü
        while(girdi.compareTo("0")!=0) {
            //uygulamanın verdiği cevaplar answer metodunda ayarlanacak
            bot.botSay(bot.answer());
            System.out.print("Sormak istediğiniz soru nedir?(Çıkış için 0 girin): ");
            girdi = scanner.nextLine();
        }
    }

    /**keyword kelimeleri dosyadan okuyup arrayliste atan metod*/
    private static void createKeywords(){
        try {
            scanner = new Scanner(new FileInputStream("keywords.txt"));
        }catch (FileNotFoundException e){
            System.err.println("Dosya bulunamadı.");
            e.printStackTrace();
        }

        String read;
        assert scanner != null;
        while(scanner.hasNextLine()){
            read = scanner.nextLine();
            keywords.add(read);
        }
    }
}
