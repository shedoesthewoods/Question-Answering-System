package chatbot;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Bot{
	// şimdilik burada yapılacak bir şey yok
	Bot(){ }

	// botun verdiği cevabı yazdıran metod
	void botSay(String str){
		System.out.println("Bot: " + str +"\n");
	}

    ArrayList<String> regexGenerator(String sentence){
        ArrayList<String> matchingWords = new ArrayList<>();
        Pattern pattern;
        Matcher matcher;
        for (String word : Main.keywords) {
            pattern = Pattern.compile("^.*("+ word+ ").*$");
            matcher = pattern.matcher(sentence);

           if(matcher.lookingAt()){
                matchingWords.add(word);
           }
        }
        return matchingWords;
    }

    // uygulamanın vereceği cevap seçiminin yapılacağı metod
    String answer(ArrayList<String> words){
	    String ans = "";
	    //duzenlenecek
        for (String s :words) {
            if(s.equalsIgnoreCase("en iyi") || s.equalsIgnoreCase("erkek")){
                ans = "Djokovic";
            }
            else if(s.equalsIgnoreCase("kadin")){
                ans = "Serena Williams";
            }
        }
	    return ans;
    }
}
