import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Vvodjurnala extends JFrame {
	private JButton button = new JButton("Добавить");
	private JTextField input1 = new JTextField("", 5);
    private JTextField input2 = new JTextField("", 5);
    private JTextField input3 = new JTextField("", 5);
    private JTextField input4 = new JTextField("", 5);
    private JTextField input5 = new JTextField("", 5);
    
    
        
        
        private JLabel label1 = new JLabel("  Заполните следующие поля:");
    
    private JLabel label2 = new JLabel("    Наименование журнала");
    private JLabel label3 = new JLabel("    Год и месяц издательства");
    private JLabel label4 = new JLabel("    Количество страниц");
    private JLabel label5 = new JLabel("    Издательство");
    
    private JLabel label6 = new JLabel("    Список статей");
    
    
    public static String naimenovanie="";
    public static String godizdat="";
    public static String stranic="";
    public static String izdatelstvo="";
    
    public static String spisok="";
    
	
	public Vvodjurnala() {
	    super("Заполнение журнала");
	    this.setBounds(500,100,500,500);
	    

	    Container container = this.getContentPane();
	    container.setLayout(new GridLayout(12,1));
	    container.add(label1);
	    container.add(label2);
	    container.add(input1);
	    container.add(label3);
	    container.add(input2);
	    container.add(label4);
	    container.add(input3);
	    container.add(label5);
	    container.add(input4);
	    container.add(label6);
	    container.add(input5);
	    
	    
	    
	    
            
            
            
            

	    
	    
	    
	    

	    
	    
	    
	    button.addActionListener(new ButtonEventListener());
	    container.add(button);
	}
	
	
        
    private void dob_jurnala() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/bfond";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("INSERT INTO TFOND (TIP,NAIMENOVANIE,DATA,STRANICI,IZDATELSTVO,SPISOK_STATEI) VALUES ('журнал','" +  naimenovanie  + "','" +  godizdat  + "','" +  stranic  + "','" +  izdatelstvo  + "','" +  spisok  + "')");
            
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
			String message = "Журнал добавлен!";
			
                        
                        
                    
                    
                    
                    
                        
                        naimenovanie =   input1.getText();
		        godizdat =   input2.getText();
		        stranic =   input3.getText();
		        izdatelstvo =   input4.getText();
		        
		        spisok =   input5.getText();
                        
                        
		        dob_jurnala();
			 
			 
			JOptionPane.showMessageDialog(null,
		    		message,
		    		"Сообщение",
		    	    JOptionPane.PLAIN_MESSAGE);
		}
	}

	
}