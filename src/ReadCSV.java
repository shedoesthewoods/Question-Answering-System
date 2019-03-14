package chatbot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCSV {
    private Scanner scanner = null;

    ReadCSV(){

    }

    private void readCSV(){
        try {
            scanner = new Scanner(new File("atp_players.csv"));
        } catch (FileNotFoundException e) {
            System.err.println("Dosya bulunamadı.");
            e.printStackTrace();
        }
        scanner.useDelimiter(",");
        while (scanner.hasNextLine()){
            scanner.nextLine();
        }
        //okunan dosya kullanilan veri yapisine aktarilacak
        //ancak scanner ile dosyanın sonuna kadar okumadi
        //veri dosyamiz çok buyuk
    }

    void arrayCreator(String line){

    }
}
