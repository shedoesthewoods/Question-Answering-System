package chatbot;

public class Player {
    private int id;
    private String name;
    private String lastName;
    private String country;
    private char hand;
    private String bDate;

    //doğum tarihi için hangi class ve yöntem kullanılacak
    Player(int id, String name, String lastName, char hand, String birthDate, String country){
        this.setId(id);
        this.setName(name);
        this.setLastName(lastName);
        this.setCountry(country);
        this.setHand(hand);
        this.setbDate(birthDate);
    }

    /**getter setter metodlar*/
    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String getCountry() {
        return country;
    }

    void setCountry(String country) {
        this.country = country;
    }

    char getHand() {
        return hand;
    }

    void setHand(char hand) {
        this.hand = hand;
    }

    String getbDate() {
        return bDate;
    }

    void setbDate(String birthDate){
        this.bDate = birthDate;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }
}
