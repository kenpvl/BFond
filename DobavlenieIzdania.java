import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DobavlenieIzdania extends JFrame {
	private JButton button = new JButton("Выполнить");
	private JTextField input = new JTextField("", 5);
	private JLabel label1 = new JLabel("  Введите тип издания:");
        private JLabel label2 = new JLabel("    0 - книга");
        private JLabel label3 = new JLabel("    1 - журнал");
        private JLabel label4 = new JLabel("    2 - брошюра");
        
        
	
	public DobavlenieIzdania() {
	    super("Добавление нового издания");
	    this.setBounds(400,100,500,500);
	   

	    Container container = this.getContentPane();
	    container.setLayout(new GridLayout(6,1));
	    container.add(label1);
	    container.add(label2);
	    container.add(label3);
	    container.add(label4);
            
            
            
            container.add(input);

	    

    
	    
	    
	    button.addActionListener(new ButtonEventListener());
	    container.add(button);
	}
	
	class ButtonEventListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String message = "";
			
			message = input.getText();
		    
            
            if (message.equals("0")) {
                
                    
                    
                    
                    
                    Vvodknigi kniga = new Vvodknigi();
                     kniga.setVisible(true);
                
                
                }  
			
			
                        
		    if (message.equals("1")) {
		        
		            
		            
		            
		            
		            Vvodjurnala jurnal = new Vvodjurnala();
		             jurnal.setVisible(true);
		        
		        
		        }      
                        
                        
                        
                        
                        
		    if (message.equals("2")) {
		        
		            
		            
		            
		            
		            Vvodbroshuri broshura = new Vvodbroshuri();
		             broshura.setVisible(true);
		        
		        
		        }   
                        
                        
                        
                        
                        
		}
	}

	
}