package chatbot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
            // QuestionAnsweringSystem sýnýfýnda yazýlan metodlar questionAnsweringSystem deðiþkeni üzerinden çalýþtýrýlacak
    	    QuestionAnsweringSystem questionAnsweringSystem = new QuestionAnsweringSystem();

            // konsoldan okumalar
            Scanner scanner = new Scanner(System.in);
            System.out.print("Sormak istediðiniz soru nedir?(Çýkýþ için 0 girin): ");
            String girdi = scanner.nextLine(); //nextLine yerine next metodu kullanýldýðýnda uygulama bozuluyor

            //kullanýcý çýkýþ yapmak isteyene kadar uygulamayý açýk tutan döngü
            while(girdi.compareTo("0")!=0) {
                questionAnsweringSystem.getSentence(girdi);
                System.out.print("Sormak istediðiniz soru nedir?(Çýkýþ için 0 girin): ");
                girdi = scanner.nextLine();
            }
       
    }
    
}