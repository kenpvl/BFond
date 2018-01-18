import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Vvodbroshuri extends JFrame {
	private JButton button = new JButton("Добавить");
	private JTextField input1 = new JTextField("", 5);
    private JTextField input2 = new JTextField("", 5);
    private JTextField input3 = new JTextField("", 5);
    private JTextField input4 = new JTextField("", 5);
    
    
    
        
        
        private JLabel label1 = new JLabel("  Заполните следующие поля:");
    
    private JLabel label2 = new JLabel("    Наименование брошюры");
    private JLabel label3 = new JLabel("    Год и месяц издательства");
    
    private JLabel label4 = new JLabel("    Издательство");
    
    private JLabel label5 = new JLabel("    Краткое описание брошюры");
    
    
    public static String naimenovanie="";
    public static String godizdat="";
    
    public static String izdatelstvo="";
    
    public static String kratkoe="";
    
	
	public Vvodbroshuri() {
	    super("Заполнение брошюры");
	    this.setBounds(500,100,500,500);
	    

	    Container container = this.getContentPane();
	    container.setLayout(new GridLayout(10,1));
	    container.add(label1);
	    container.add(label2);
	    container.add(input1);
	    container.add(label3);
	    container.add(input2);
	    container.add(label4);
	    container.add(input3);
	    container.add(label5);
	    container.add(input4);
	    
	    
	    
	    
	    
	    
            
            
            
            

	    
	    
	    
	    

	    
	    
	    
	    button.addActionListener(new ButtonEventListener());
	    container.add(button);
	}
	
	
        
    private void dob_broshuri() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/bfond";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("INSERT INTO TFOND (TIP,NAIMENOVANIE,DATA,IZDATELSTVO,KRATKOE_SODERZHANIE) VALUES ('брошюра','" +  naimenovanie  + "','" +  godizdat  + "','" +  izdatelstvo  + "','" +  kratkoe  + "')");
            
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
        
        
        
        
        
        class ButtonEventListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String message = "Брошюра добавлена!";
			
                        
                        
                    
                    
                    
                    
                        
                        naimenovanie =   input1.getText();
		        godizdat =   input2.getText();
		        
		        izdatelstvo =   input3.getText();
		        
		        kratkoe =   input4.getText();
                        
                        
		        dob_broshuri();
			 
			 
			JOptionPane.showMessageDialog(null,
		    		message,
		    		"Сообщение",
		    	    JOptionPane.PLAIN_MESSAGE);
		}
	}

	
}