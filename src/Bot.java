package chatbot;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Bot{
    private ArrayList<String> matchingWords = new ArrayList<>();
	Bot(){ }

	/** botun verdiği cevabı yazdıran metod*/
	void botSay(String str){
		System.out.println("Bot: " + str +"\n");
	}

    void regexGenerator(String sentence){
        Pattern pattern;
        Matcher matcher;
        for (String word : Main.keywords) {
            pattern = Pattern.compile("^.*("+ word+ ").*$");
            matcher = pattern.matcher(sentence);

           if(matcher.lookingAt()){
                matchingWords.add(word);
           }
        }
    }

    /** uygulamanın vereceği cevap seçiminin yapılacağı metod*/
    String answer(){
	    String ans;

        if(matchingWords.contains("en iyi") || matchingWords.contains("erkek")){
            ans = "Djokovic";
        }else{
            ans = "Serena Williams";
        }
        matchingWords.clear();
	    return ans;
    }
}
