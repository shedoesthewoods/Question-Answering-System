package chatbot;

import java.util.ArrayList;
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
    private ArrayList<String> eller;

    QueryReader(ArrayList<String> matchingWords, String sentence){
        matching = matchingWords;
        this.sentence = sentence;
        ans = "";
        db = new ReadDB();
        assingArr();
    }

    private void assingArr(){
        cinsiyetler = new ArrayList<>();
        cinsiyetler.add("kadin"); cinsiyetler.add("erkek"); cinsiyetler.add("kadinlar"); cinsiyetler.add("erkekler");

        isimler = new ArrayList<>();
        isimler.add("ad"); isimler.add("isim"); isimler.add("ismi"); isimler.add("isimli"); isimler.add("adi");
/*
        ulkeler = new ArrayList<>();

        tarihler = new ArrayList<>();

        eller = new ArrayList<>();*/
    }

    /** uygulamanın vereceği cevap seçiminin yapılacağı metod*/
    private String createQuery(){ //sentence patterndan bulunmalı
        String select = "SELECT * ";
        String from = "FROM Players";
        String where = " WHERE ";
        String name = null;
        String country = null;
        String date = null;

        /*if(matching.contains("ad") || matching.contains("isim") || matching.contains("ismi") ||
                matching.contains("isimli")){*/

//bunu bir deneyelim
        String[] splittedSentence =  sentence.split(" ");

        if(!Collections.disjoint(matching, isimler)){
            for (int i = 0; i < isimler.size(); i++) {
                if(sentence.matches(isimler.get(i))){
                    //name =
                }
            }

            where += "Name= '" + name + "'";
        }

        if(matching.contains("ulke") || matching.contains("ulkesi") || matching.contains("vatandasi") ||
                matching.contains("ulkesinden")){
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
        if(matching.contains("tarih") || matching.contains("tarihi") ||
                matching.contains("tarihinde") || matching.contains("tarihli")){

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

        if(matching.contains("sag")){
            if(matching.containsAll(cinsiyetler)){
                where += "Hand='R'";
            }
            else if(matching.contains("kadin"))
                where += "Hand='R' and Cinsiyet='K'";
            else if(matching.contains("erkek"))
                where += "Hand='R' and Cinsiyet='E'";
            else
                where += "Hand='R'";
        }
        else if(matching.contains("sol") ){
            if(matching.containsAll(cinsiyetler))
                where += "Hand='L'";
            else if(matching.contains("kadin"))
                where += "Hand='L' and Cinsiyet='K'";
            else if(matching.contains("erkek"))
                where += "Hand='L' and Cinsiyet='E'";
            else
                where += "Hand='L'";
        }
        ans = select + from + where + ";";
        matching.clear();
        return ans;
        //db.execute_query(ans);
    }

    void executeQuery(){
        //createQuery();
        db.execute_query(ans);
    }
}
