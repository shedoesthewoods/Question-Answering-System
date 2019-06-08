package chatbot;

class QuestionAnsweringSystem {
    /** botun verdiði cevabý yazdýran metod*/
    void getSentence(String sentence){
        Question question = new Question(sentence);
        question.setQuestion();
    }

    /*private String isDate(){
        QuestionPattern pattern;
        Matcher matcher;
        for(String word : nonMatchingWords){
            pattern = QuestionPattern.compile("(\\d{4}[01]\\d[0-3]\\d)"); //date regex
            matcher = pattern.matcher(word);
            if(matcher.lookingAt()){
                return word;
            }
        }
        return "";
    }*/
}