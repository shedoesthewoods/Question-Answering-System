package chatbot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
            // QuestionAnsweringSystem s�n�f�nda yaz�lan metodlar questionAnsweringSystem de�i�keni �zerinden �al��t�r�lacak
    	    QuestionAnsweringSystem questionAnsweringSystem = new QuestionAnsweringSystem();

            // konsoldan okumalar
            Scanner scanner = new Scanner(System.in);
            System.out.print("Sormak istedi�iniz soru nedir?(��k�� i�in 0 girin): ");
            String girdi = scanner.nextLine(); //nextLine yerine next metodu kullan�ld���nda uygulama bozuluyor

            //kullan�c� ��k�� yapmak isteyene kadar uygulamay� a��k tutan d�ng�
            while(girdi.compareTo("0")!=0) {
                questionAnsweringSystem.getSentence(girdi);
                System.out.print("Sormak istedi�iniz soru nedir?(��k�� i�in 0 girin): ");
                girdi = scanner.nextLine();
            }
       
    }
    
}