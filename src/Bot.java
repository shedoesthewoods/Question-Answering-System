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
    private ArrayList<String> cinsiyetler = new ArrayList<>();
    private static Scanner scanner = null;

    Bot(){
        createKeywords();
        cinsiyetler.add("kadin"); cinsiyetler.add("erkek");
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
        for (String word : keywords) {
            pattern = Pattern.compile("^.*(?i)("+ word+ ").*$");
            matcher = pattern.matcher(sentence);

           if(matcher.lookingAt()){
                matchingWords.add(word);
           }
        }
    }

    /** uygulamanın vereceği cevap seçiminin yapılacağı metod*/
    private String answer(String sentence){
        regexGenerator(sentence);
        String ans = "";

        if(matchingWords.contains("en iyi")){
            if(matchingWords.contains("erkek")){
                ans="Djokovic";
            }
            else if(matchingWords.contains("kadin")){
                ans="Serena Williams";
            }
            else{
                ans="Erkeklerde: Djokovic\nKadinlarda: Serena Williams";
            }
            if(matchingWords.containsAll(cinsiyetler)){
                ans="Erkeklerde: Djokovic\nKadinlarda: Serena Williams";
            }
        }



        matchingWords.clear();
        return ans;
    }
}
