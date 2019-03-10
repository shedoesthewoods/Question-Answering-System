package chatbot;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Bot{
	
	Bot(){ }

	void botSay(String str){
		System.out.println("AI: " + str +"\n");
	}

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

   
    String answer(ArrayList<String> words){
	    String ans = "";
	    Pattern r = Pattern.compile(Main.pattern);
	    
        for (String s :words) {
        	Matcher m = r.matcher(s);
            if(Main.keywords.contains(s.toLowerCase())){ //bu satýr iyileþtirilecek
                ans = "1"; //örnek cevap
            }
            if(m.matches()){
            	ans = "HELLO!";
            }
        }
	    return ans;
	    
    }
}