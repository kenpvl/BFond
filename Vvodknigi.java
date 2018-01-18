import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Vvodknigi extends JFrame {
	private JButton button = new JButton("Добавить");
	private JTextField input1 = new JTextField("", 5);
    private JTextField input2 = new JTextField("", 5);
    private JTextField input3 = new JTextField("", 5);
    private JTextField input4 = new JTextField("", 5);
    private JTextField input5 = new JTextField("", 5);
    private JTextField input6 = new JTextField("", 5); 
    private JTextField input7 = new JTextField("", 5);
        
        
        private JLabel label1 = new JLabel("  Заполните следующие поля:");
    private JLabel label2 = new JLabel("    Автор");
    private JLabel label3 = new JLabel("    Наименование книги");
    private JLabel label4 = new JLabel("    Год издательства");
    private JLabel label5 = new JLabel("    Количество страниц");
    private JLabel label6 = new JLabel("    Издательство");
    private JLabel label7 = new JLabel("    Жанр книги");
    private JLabel label8 = new JLabel("    Краткое содержание");
    
    public static String avtor="";
    public static String naimenovanie="";
    public static String godizdat="";
    public static String stranic="";
    public static String izdatelstvo="";
    public static String zhanr="";
    public static String kratkoe="";
    
	
	public Vvodknigi() {
	    super("Заполнение книги");
	    this.setBounds(500,100,500,500);
	    

	    Container container = this.getContentPane();
	    container.setLayout(new GridLayout(16,1));
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
	    container.add(label7);
	    container.add(input6);
	    container.add(label8);
	    container.add(input7);
            
            
            
            

	    
	    
	    
	    

	    
	    
	    
	    button.addActionListener(new ButtonEventListener());
	    container.add(button);
	}
	
	
        
    private void dob_knigi() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/bfond";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("INSERT INTO TFOND (TIP,AVTOR,NAIMENOVANIE,DATA,STRANICI,IZDATELSTVO,ZHANR_KNIGI,KRATKOE_SODERZHANIE) VALUES ('книга','" +  avtor  + "','" +  naimenovanie  + "','" +  godizdat  + "','" +  stranic  + "','" +  izdatelstvo  + "','" +  zhanr  + "','" +  kratkoe  + "')");
            
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
			String message = "Книга добавлена!";
			
                        
                        
                    
                    
                    
                    
                        avtor =   input1.getText();
                        naimenovanie =   input2.getText();
		        godizdat =   input3.getText();
		        stranic =   input4.getText();
		        izdatelstvo =   input5.getText();
		        zhanr =   input6.getText();
		        kratkoe =   input7.getText();
                        
                        
		        dob_knigi();
			 
			 
			JOptionPane.showMessageDialog(null,
		    		message,
		    		"Сообщение",
		    	    JOptionPane.PLAIN_MESSAGE);
		}
	}

	
}