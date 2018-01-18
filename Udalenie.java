import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Udalenie extends JFrame {
	private JButton button = new JButton("Выполнить");
	private JTextField input = new JTextField("", 5);
	private JLabel label1 = new JLabel("  Введите идентификатор издания:");
        
    public static int idd;
    public static int y=0;
        
        
	
	public Udalenie() {
	    super("Удаление выбранного издания");
	    this.setBounds(400,100,500,500);
	   

	    Container container = this.getContentPane();
	    container.setLayout(new GridLayout(3,1));
	    container.add(label1);
	    
	    
	    
            
            
            
            container.add(input);

	    

    
	    
	    
	    button.addActionListener(new ButtonEventListener());
	    container.add(button);
	}
        
        
        
        
    
    
    
    private void obhod() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/bfond";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM TFOND");
                
                String st="";
                int c;
                
                while (rs.next()) {
                   
                   st = rs.getString("ZAPIS_ID");
                
                   c = Integer.parseInt(st);
                
                    if(c==idd){
                        y=y+1;
                        }
                
                }
                
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    private void udalenieizdania() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/bfond";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("DELETE  FROM TFOND WHERE ZAPIS_ID = " +  idd  + " ");
                
                
                
                
                              
                
                
                
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
			
			String mess3="Такого идентификатора не существует!";
                        String mes = "Издание удалено!";
                        String message="";
			
                        message = input.getText();
                        y=0;
                        
                        
                        idd = Integer.parseInt(message);
		    
		    
            
			
			obhod();
                        
		        udalenieizdania();
                        
                        
                if(y==0){
                    
                        JOptionPane.showMessageDialog(null,
                                mess3,
                                "Сообщение",
                            JOptionPane.PLAIN_MESSAGE);
                    
                    }
                        
                        
		    
                        else
                        
                        
                        
                        JOptionPane.showMessageDialog(null,
		    		mes,
		    		"Сообщение",
		    	    JOptionPane.PLAIN_MESSAGE);
		}
	}

	
}