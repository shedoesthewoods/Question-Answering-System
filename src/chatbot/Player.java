package chatbot;

public class Player {
    private String name, lastName, country;
    private char hand;
    //private SimpleDateFormat birthDate = new SimpleDateFormat("yyyy-MM-dd");
    Player(String name, String lastName, char hand, String country){
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.hand = hand;
    }
}
