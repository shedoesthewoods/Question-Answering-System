package chatbot;

class Player {
    private int id;
	private String name, lastName, country, birthDate, hand, sex;

    Player(int id, String name, String lastName, String birthDate, String hand, String country, String sex){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.birthDate = birthDate;
        this.hand = hand;
        this.sex = sex;
    }

    @Override
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", Lastname: " + lastName +
                ", Hand: "+ hand+ ", Birthday: " + birthDate + ", Country: " +
                country + ", Sex: " + sex;
    }
}
