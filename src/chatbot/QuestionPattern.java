package chatbot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class QuestionPattern {
    private String question;
    private ArrayList<String> keywords;
    private ArrayList<String> matchingWords;
    private static Scanner scanner = null;

    QuestionPattern(String question){
        this.question = question;
        keywords = new ArrayList<>();
        matchingWords = new ArrayList<>();
    }

    void execute(){
        createKeywords();
        regexGenerator();
        QueryReader queryReader = new QueryReader(matchingWords, question);
        queryReader._executeQuery();
    }

    /**keyword kelimeleri dosyadan okuyup arrayliste atan metod*/
    private void createKeywords(){
        try {
            scanner = new Scanner(new FileInputStream(
                    "C:/Users/4713392981814/git/SADProject/src/keywords.txt"));
        }catch (FileNotFoundException e){
            System.err.println("Dosya bulunamadý.");
            e.printStackTrace();
        }

        String read;
        while(scanner.hasNextLine()){
            read = scanner.nextLine();
            keywords.add(read);
          //  keywords.add("^.*(?i)("+ read + ").*$"); //bu böyle olunca matchingWords nasýl oluyor ona bakmalý
        }
    }

    /**keywords.txt dosyasondaki kelimeleri regex haline getiren metod*/
    private void regexGenerator(){
        Pattern pattern;
        Matcher matcher;
        for (String word : keywords) {
            pattern = Pattern.compile("^.*(?i)("+ word+ ").*$");
      //      pattern = Pattern.compile(word);
            matcher = pattern.matcher(question);

            if(matcher.matches()){
                matchingWords.add(word); //word yerine cümlede gecen kelime
            }
        }
        /*String[] splittedSentence =  sentence.split(" ");
        for(String word2 : splittedSentence){
            if(!matchingWords.contains(word2)){
                nonMatchingWords.add(word2);
            }
        }*/
    }

    ArrayList<String> getMatchingWords() {
        return matchingWords;
    }
}