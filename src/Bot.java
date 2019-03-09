package chatbot;

import java.util.ArrayList;
import java.util.StringTokenizer;

class Bot{
	// şimdilik burada yapılacak bir şey yok
	Bot(){ }

	// botun verdiği cevabı yazdıran metod
	// gereksiz gibi ama oop mantığı için main metotta yazmaktan daha uygun :D
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

    // uygulamanın vereceği cevap seçiminin yapılacağı metod
    String answer(ArrayList<String> words){
	    String ans = "";

        for (String s :words) {
            if(Main.keywords.contains(s.toLowerCase())){ //bu satır iyileştirilecek
                ans = "1"; //örnek cevap
            }
        }
	    return ans;
    }
}
