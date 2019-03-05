package chatbot;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.*;

class Bot extends JFrame{
	//Typing area
	private JTextField txtEnter = new JTextField();
	//Chat area
	private JTextArea txtChat = new JTextArea();

	Bot(){
		//Frame attribute
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("Ask about Tennis!");
		
		//txtEnter attribute
		txtEnter.setLocation(2,530);
		txtEnter.setSize(590,30);
		
		//txtEnter Action Event
		txtEnter.addActionListener(arg0 -> {
            String uText = txtEnter.getText();
            txtChat.append("You: "+ uText + "\n");

            ArrayList<String> words = parse(uText);
            String generatedText = answer(words);
            botSay(generatedText);

            txtEnter.setText("");
        });
		//txtChat attribute
		txtChat.setLocation(15,10);
		txtChat.setSize(560,510);
		
		//Add items to Frame
		this.add(txtEnter);
		this.add(txtChat);
	}
	
	private void botSay(String str){
		txtChat.append("AI: " + str +"\n");
	}

	private ArrayList<String> parse(String input){
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer str = new StringTokenizer(input, " ,()?.[]{}");
        String nextToken = str.nextToken();
        while (!nextToken.isEmpty()){
            list.add(nextToken);
            nextToken = str.nextToken();
        }
	    return list;
    }

    String answer(ArrayList<String> words){
	    String ans = "";

        for (String s :words) {
            if(Main.keywords.contains(s.toLowerCase())){
                ans = "1";
            }
        }

	    return ans;
    }
}
