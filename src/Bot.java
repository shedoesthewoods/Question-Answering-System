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
//
//    //eğer bu metod çalışırsa parser silinecek yerine regexGenerator gelecek
//    ArrayList<String> regexGenerator(String sentence){
//        ArrayList<String> matchingWords = new ArrayList<>();
//        for (String word : Main.keywords) {
//            Pattern pattern = Pattern.compile("\n");
//            Matcher matcher = pattern.matcher(sentence);
//
//           if(matcher.lookingAt()){
//                matchingWords.add(word);
//            }
//
//        }
//        return matchingWords;
//    }
//
//    // uygulamanın vereceği cevap seçiminin yapılacağı metod
//    String answer(ArrayList<String> words){
//	    String ans = "";
//	    int sayac=0;
//	    //regex düzenlendikten sonra değişecek
//        for (String s :words) {
//            if(s.equalsIgnoreCase("en iyi") || s.equalsIgnoreCase("erkek")){
//                sayac++;
//                if(sayac==1){
//                    ans = "Djokovic";
//                }
//            }
//            else if(s.equalsIgnoreCase("kadin")){
//                if(sayac==0){
//                    ans = "Serena Williams";
//                }
//            }
//        }
//	    return ans;
//    }

    void answer(String input){
        if(input.contains("en iyi") && input.contains("erkek")){
            System.out.println("Djokovic");
        } else if(input.contains("en iyi") && input.contains("kadin")){
            System.out.println("Serena Williams");
        }
    }
}
