import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bot extends JFrame{
	
	//Typing area
	private JTextField txtEnter = new JTextField();
	//Chat area
	private JTextArea txtChat = new JTextArea();
	
	public Bot(){
		//Frame attribute
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("Java AI");
		
		//txtEnter attribute
		txtEnter.setLocation(2,530);
		txtEnter.setSize(590,30);
		
		//txtEnter Action Event
		txtEnter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String uText = txtEnter.getText();
				txtChat.append("You: "+ uText + "\n");
				
				if(uText.contains("hi")){
					botSay("hello");
				}
				
				else if(uText.contains("how are you")){
					int decider = (int) (Math.random()*3+1);
					if(decider == 1){
						botSay("I am fine,thanks");	
					}
					else if(decider == 2){
						botSay("Not too bad");
				    }
				}
				
				
				else{
					int decider = (int) (Math.random()*3+1);
					if(decider == 1){
						botSay("I didnt get it");	
					}
					else if(decider == 2){
						botSay("Please rephare it");
					}
					else
						botSay("???");
						
				}
				
			
				txtEnter.setText("");
			}
		});
		//txtChat attribute
		txtChat.setLocation(15,10);
		txtChat.setSize(560,510);
		
		
		//Add items to Frame
		this.add(txtEnter);
		this.add(txtChat);
	}
	
	public void botSay(String s){
		txtChat.append("AI: " + s +"\n");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bot();
	}

}
