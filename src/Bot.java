package chatbot;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Bot{
	// şimdilik burada yapılacak bir şey yok
	Bot(){ }

	// botun verdiği cevabı yazdıran metod
	void botSay(String str){
		System.out.println("AI: " + str +"\n");
	}

	// kullanıcı girdisinin kelimelerine ayıran metod
	ArrayList<String> parse(String input){
		ArrayList<String> list = new ArrayList<>();
		StringTokenizer str = new StringTokenizer(input, " ,()?.[]{}!");
		String nextToken = str.nextToken();
		list.add(nextToken);
		while(str.hasMoreTokens()){
			nextToken = str.nextToken();
			list.add(nextToken);
		}
		return list;
    }

    //eğer bu metod çalışırsa parser silinecek yerine regexGenerator gelecek
    ArrayList<String> regexGenerator(String sentence){
        Pattern pattern;
        Matcher matcher;
        ArrayList<String> matchingWords = new ArrayList<>();
        for (String word : Main.keywords) {
            pattern = Pattern.compile(word);
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

	    //regex düzenlendikten sonra değişecek
        for (String s :words) {
            if(Main.keywords.contains(s.toLowerCase())){
                ans = "1"; //örnek cevap
            }
        }
	    return ans;
    }
}
