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
    //private ArrayList<String> nonMatchingWords = new ArrayList<>();
    private ArrayList<String> cinsiyetler = new ArrayList<>();
    private static Scanner scanner = null;
    private ReadDB db= new ReadDB();

    Bot(){
        createKeywords();
        cinsiyetler.add("kadin"); cinsiyetler.add("erkek"); cinsiyetler.add("kadinlar"); cinsiyetler.add("erkekler");
    }

    /** botun verdiği cevabı yazdıran metod*/
    void botSay(String sentence){
        answer(sentence);
        //System.out.printf("Bot: %s\n", answer(sentence));
    }

    /**keyword kelimeleri dosyadan okuyup arrayliste atan metod*/
    private void createKeywords(){
        try {
            scanner = new Scanner(new FileInputStream(
                    "C:/Users/4713392981814/git/QuestionAnswering2/src/keywords.txt"));
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

    /** uygulamanın vereceği cevap seçiminin yapılacağı metod*/
    private void answer(String sentence){
        String select = "SELECT * ";
        String from = "FROM Players";
        String where = " WHERE ";
        String name = null;
        String country = null;
        String date = null;
        regexGenerator(sentence);
        String ans;
        if(matchingWords.contains("ad") || matchingWords.contains("isim") || matchingWords.contains("ismi") ||
                matchingWords.contains("isimli")){
            String[] splittedSentence =  sentence.split(" ");
            for(int i = 0; i < splittedSentence.length; i++){
                if(splittedSentence[i].equalsIgnoreCase("ad") ||
                        splittedSentence[i].equalsIgnoreCase("isim") ||
                            splittedSentence[i].equalsIgnoreCase("ismi") ||
                                splittedSentence[i].equalsIgnoreCase("isimli")){
                    name = splittedSentence[i+1];
                    break;
                }else if(i != 1){
                    name = splittedSentence[i-1];
                    break;
                }else if(i==0){
                    name = splittedSentence[i];
                    break;
                }
            }
            where += "Name= '" + name + "'";
        }

        if(matchingWords.contains("ulke") || matchingWords.contains("ulkesi") || matchingWords.contains("vatandasi") ||
                matchingWords.contains("ulkesinden")){
            String[] splittedSentence =  sentence.split(" ");
            for(int i = 0; i < splittedSentence.length; i++){
                if(splittedSentence[i].equalsIgnoreCase("ulke") ||
                        splittedSentence[i].equalsIgnoreCase("ulkesi") ||
                            splittedSentence[i].equalsIgnoreCase("vatandasi") ||
                                splittedSentence[i].equalsIgnoreCase("ulkesinden")){
                    country = splittedSentence[i+1];
                    break;
                }else if(i != 1){
                    country = splittedSentence[i-1];
                    break;
                }else if(i == 0){
                    country = splittedSentence[i];
                    break;
                }
            }
            where += "Country= '" + country + "'";
        }
        if(matchingWords.contains("tarih") || matchingWords.contains("tarihi") ||
                matchingWords.contains("tarihinde") || matchingWords.contains("tarihli")){

            String[] splittedSentence =  sentence.split(" ");
            for(int i = 0; i < splittedSentence.length; i++){
                if(splittedSentence[i].equalsIgnoreCase("tarih") ||
                        splittedSentence[i].equalsIgnoreCase("tarihi") ||
                            splittedSentence[i].equalsIgnoreCase("tarihinde") ||
                                splittedSentence[i].equalsIgnoreCase("tarihli")){
                    date = splittedSentence[i+1];
                    break;
                }else if(i != 1){
                    date = splittedSentence[i-1];
                    break;
                }else if(i == 0){
                    date = splittedSentence[i];
                    break;
                }
            }
            where += "Birthday= '" + date + "'";
        }

        if(matchingWords.contains("sag")){
            if(matchingWords.containsAll(cinsiyetler)){
                where += "Hand='R'";
            }
            else if(matchingWords.contains("kadin"))
                where += "Hand='R' and Cinsiyet='K'";
            else if(matchingWords.contains("erkek"))
                where += "Hand='R' and Cinsiyet='E'";
            else
                where += "Hand='R'";
        }
        else if(matchingWords.contains("sol") ){
            if(matchingWords.containsAll(cinsiyetler))
                where += "Hand='L'";
            else if(matchingWords.contains("kadin"))
                where += "Hand='L' and Cinsiyet='K'";
            else if(matchingWords.contains("erkek"))
                where += "Hand='L' and Cinsiyet='E'";
            else
                where += "Hand='L'";
        }
        ans = select + from + where + ";";
        db.read(ans);
        matchingWords.clear();
    }

    /*private String isDate(){
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
    }*/
}
