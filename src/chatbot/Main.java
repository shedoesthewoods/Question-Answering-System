package chatbot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // QuestionAnsweringSystem sinifinda yazilan metodlar questionAnsweringSystem degiskeni uzerinden �al��t�r�lacak (bu ne demek)
        QuestionAnsweringSystem questionAnsweringSystem = new QuestionAnsweringSystem();

        // konsoldan okumalar
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sormak istediginiz soru nedir?(cikmak icin 0 girin): ");
        String girdi = scanner.nextLine(); //nextLine yerine next metodu kullan�ld���nda uygulama bozuluyor

        //kullanici cikis yapmak isteyene kadar uygulamayi acik tutan dongu
        while(girdi.compareTo("0")!=0) {
            questionAnsweringSystem.getSentence(girdi);
            System.out.print("Sormak istediginiz soru nedir?(cikmak icin 0 girin): ");
            girdi = scanner.nextLine();
        }
    }
}
