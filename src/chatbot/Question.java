package chatbot;

class Question {
    private String questionSentence;
    private QuestionPattern pattern;

    Question(String sentence){
        questionSentence = sentence;
    }

    void setQuestion(){
        pattern = new QuestionPattern(questionSentence);
        pattern.execute();
    }
}
