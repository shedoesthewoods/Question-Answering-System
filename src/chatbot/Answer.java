package chatbot;

class Answer {
	private Player player;

	public Answer(Player player){
		this.player = player;
	}

	String createAnswer(){
		return player.toString();
	}
}
