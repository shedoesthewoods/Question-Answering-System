package chatbot;

//import java.text.SimpleDateFormat;

public class Player {
    private String name, lastName, country;
    private char hand;
    //private SimpleDateFormat birthDate = new SimpleDateFormat("yyyy-MM-dd");
    //doğum tarihi için hangi class ve yöntem kullanılacak
    Player(String name, String lastName, char hand, String country){
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.hand = hand;
    }
    //eğer rankings dosyası okunacaksa oyuncu id de girilmeli
}
