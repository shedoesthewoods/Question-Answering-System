package chatbot;

class Question {
	private String questionSentence;

	Question(String sentence){
		questionSentence = sentence;
	}

	void setQuestion(){
		QuestionPattern pattern = new QuestionPattern(questionSentence);
		pattern.execute();
	}
}
