package chatbot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Bot{
    private static ArrayList<String> keywords = new ArrayList<>();
    private ArrayList<String> matchingWords = new ArrayList<>();
    private ArrayList<String> nonMatchingWords = new ArrayList<>();
    //private ArrayList<String> cinsiyetler = new ArrayList<>();
    private static Scanner scanner = null;

    Bot(){
        createKeywords();
        //cinsiyetler.add("kadin"); cinsiyetler.add("erkek");
    }

	/** botun verdiği cevabı yazdıran metod*/
	void botSay(String sentence){
		System.out.printf("Bot: %s\n", answer(sentence));
	}

    /**keyword kelimeleri dosyadan okuyup arrayliste atan metod*/
    private void createKeywords(){
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

	private void regexGenerator(String sentence){
        Pattern pattern;
        Matcher matcher;
        for (String word1 : keywords) {
            pattern = Pattern.compile("^.*(?i)("+ word1+ ").*$");
            matcher = pattern.matcher(sentence);

           if(matcher.lookingAt()){
                matchingWords.add(word1);
           }
        }

        String[] splittedSentence =  sentence.split(" ");
        for(String word2 : splittedSentence){
            if(!matchingWords.contains(word2)){
                nonMatchingWords.add(word2);
            }
        }
    }

    /** uygulamanın vereceği cevap seçiminin yapılacağı metod*/
    private String answer(String sentence){
        regexGenerator(sentence);
        String ans = "";

        String tarih = isDate();
        if(tarih != null){
            ans = tarih;
        }

        matchingWords.clear();
        return ans;
    }

    private String isDate(){
        Pattern pattern;
        Matcher matcher;
        for(String word : nonMatchingWords){
            pattern = Pattern.compile("(\\d{4}[01]\\d[0-3]\\d)"); //date regex
            matcher = pattern.matcher(word);

            if(matcher.lookingAt()){
                return word;
            }
        }
        return "";
    }
}
