package chatbot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Bot sınıfında yazılan metodlar bot değişkeni üzerinden çalıştırılacak
        Bot bot = new Bot();

        // konsoldan okumalar
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sormak istediğiniz soru nedir?(Çıkış için 0 girin): ");
        String girdi = scanner.nextLine(); //nextLine yerine next metodu kullanıldığında uygulama bozuluyor

        //kullanıcı çıkış yapmak isteyene kadar uygulamayı açık tutan döngü
        while(girdi.compareTo("0")!=0) {
            bot.botSay(bot.answer(girdi));
            System.out.print("Sormak istediğiniz soru nedir?(Çıkış için 0 girin): ");
            girdi = scanner.nextLine();
        }
    }
}
