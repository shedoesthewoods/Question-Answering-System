package chatbot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class QueryReader {
    private ArrayList<String> matching;
    private String sentence;
    private String ans;
    private ReadDB db;

    private ArrayList<String> cinsiyetler;
    private ArrayList<String> isimler;
    private ArrayList<String> ulkeler;
    private ArrayList<String> tarihler;

    QueryReader(ArrayList<String> matchingWords, String sentence){
        matching = matchingWords;
        this.sentence = sentence;
        ans = "";
        db = new ReadDB();
        assignArr();
    }

    private void assignArr(){
        cinsiyetler = new ArrayList<>();
        cinsiyetler.add("kadin"); cinsiyetler.add("erkek"); cinsiyetler.add("kadinlar"); cinsiyetler.add("erkekler");

        isimler = new ArrayList<>();
        isimler.add("isim"); isimler.add("ismi"); isimler.add("isimli");
       
        
        ulkeler = new ArrayList<>();
        ulkeler.add("ulkesi"); ulkeler.add("ulkesinden"); ulkeler.add("ulke"); ulkeler.add("vatandasi");
        
        tarihler = new ArrayList<>();
        tarihler.add("tarih"); tarihler.add("tarihi"); tarihler.add("tarihinde"); tarihler.add("tarihli");
    }

    /** uygulamanin verecegi cevap seciminin yapilacagi metod*/
    private void create_query(String sentence){
        String select = "SELECT * ";
        String from = "FROM Players";
        String where = " WHERE ";
        String name = null;
        String country = null;
        String date = null;
        
        String[] splittedSentence =  sentence.split(" ");
        ArrayList<String> splittedSentence2 = new ArrayList<String>(Arrays.asList(splittedSentence));
        if(!Collections.disjoint(matching, isimler)){
        	for(int i=0; i<isimler.size(); i++){
        		if(splittedSentence2.contains(isimler.get(i))){
        			int index = splittedSentence2.indexOf(isimler.get(i));
        			if(index == 0){
            			name = splittedSentence2.get(index+1);
            		}
            		else{
            			name = splittedSentence2.get(index-1);
            		}
        		}
        	
        	}
            where += "Name= '" + name + "'";
        }
        
        if(!Collections.disjoint(matching, ulkeler)){
        	for(int i=0; i<ulkeler.size(); i++){
        		if(splittedSentence2.contains(ulkeler.get(i))){
        			int index = splittedSentence2.indexOf(ulkeler.get(i));
        			if(index == 0){
            			country = splittedSentence2.get(index+1);
            		}
            		else{
            			country = splittedSentence2.get(index-1);
            		}
        		}
        	
        	}
            where += "Country= '" + country + "'";
        }
        
        if(!Collections.disjoint(matching, tarihler)){
        	for(int i=0; i<tarihler.size(); i++){
        		if(splittedSentence2.contains(tarihler.get(i))){
        			int index = splittedSentence2.indexOf(tarihler.get(i));
        			if(index == 0){
            			date = splittedSentence2.get(index+1);
            		}
            		else{
            			date = splittedSentence2.get(index-1);
            		}
        		}
        	
        	}
            where += "Birthday= '" + date + "'";
        }

        if(matching.contains("sag")){
            if(matching.containsAll(cinsiyetler)){
                where += "Hand='R'";
            }
            else if(matching.contains("kadin"))
                where += "Hand='R' and Sex='K'";
            else if(matching.contains("erkek"))
                where += "Hand='R' and Sex='E'";
            else
                where += "Hand='R'";
        }
        else if(matching.contains("sol") ){
            if(matching.containsAll(cinsiyetler))
                where += "Hand='L'";
            else if(matching.contains("kadin"))
                where += "Hand='L' and Sex='K'";
            else if(matching.contains("erkek"))
                where += "Hand='L' and Sex='E'";
            else
                where += "Hand='L'";
        }
        ans = select + from + where + ";";
        matching.clear();
    }

    void _executeQuery(){
        create_query(sentence);
        db.execute_query(ans);
    }
}
