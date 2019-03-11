package chatbot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // input olarak girilebilecek keyword için açılmış arraylist
    public static ArrayList<String> keywords = new ArrayList<>();

    public static void main(String[] args) {
        // Bot sınıfında yazılan metodlar bot değişkeni üzerinden çalıştırılacak
        Bot bot = new Bot();
        createKeywords();

        // konsoldan okumalar
        Scanner input = new Scanner(System.in);
        System.out.print("Sormak istediğiniz soru nedir?(Çıkış için 0 girin): ");
        String girdi = input.nextLine(); //nextLine yerine next metodu kullanıldığında uygulama bozuluyor

        // arayüz için yazılmış bir satır
        System.out.println("You: " + girdi);

        //girilen cümleyi kelime kelime ayırıyor
        ArrayList<String> words = bot.parse(girdi);

        //kullanıcı çıkış yapmak isteyene kadar uygulamayı açık tutan döngü
        while(girdi.compareTo("0")!=0) {
            //uygulamanın verdiği cevaplar answer metodunda ayarlanacak
            bot.botSay(bot.answer(words));
            System.out.print("Sormak istediğiniz soru nedir?(Çıkış için 0 girin): ");
            girdi = input.nextLine();
        }
    }

    //keyword kelimeleri dosyadan okuyup arrayliste atan metod
    private static void createKeywords(){
        Scanner scan = null;
        try {
            scan = new Scanner(new FileInputStream("keywords.txt"));
        }catch (FileNotFoundException e){
            System.err.println("Dosya bulunamadı.");
        }

        String read;
        while(scan.hasNextLine()){
            read = scan.nextLine();
            keywords.add(read);
        }
    }
}
