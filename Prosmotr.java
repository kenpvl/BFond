import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Prosmotr extends JFrame {
	private JButton button = new JButton("Выполнить");
	private JTextField input = new JTextField("", 5);
	private JLabel label1 = new JLabel("  Введите идентификатор издания:");
        
    public static String message;
    public static int s=0;
        
        
	
	public Prosmotr() {
	    super("Просмотр информации выбранного издания");
	    this.setBounds(400,100,500,500);
	   

	    Container container = this.getContentPane();
	    container.setLayout(new GridLayout(3,1));
	    container.add(label1);
	    
	    
	    
            
            
            
            container.add(input);

	    

    
	    
	    
	    button.addActionListener(new ButtonEventListener());
	    container.add(button);
	}
        
        
        
        
    private void prosmotrizdania() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/bfond";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM TFOND");
                
                String str="";
                String tipp="";
                
                
                
                              
                
                while (rs.next()) {
                   
                    str = rs.getString("ZAPIS_ID");
                   
                    if(message.equals(str)){
                        
                        
                        s=s+1;
                        
                        tipp = rs.getString("TIP");
                        
                        
                        if(tipp.equals("книга")){
                            
                                str = rs.getString("ZAPIS_ID") +    "          " + rs.getString("AVTOR")+"          "+rs.getString("NAIMENOVANIE")+"          "+rs.getString("DATA")+"          "+rs.getString("STRANICI")+"          "+rs.getString("IZDATELSTVO")+"          "+rs.getString("ZHANR_KNIGI")+"          "+rs.getString("KRATKOE_SODERZHANIE")+"\n";
                                
                                JOptionPane.showMessageDialog(null,
                                        str,
                                        "Просмотр информации выбранного издания",
                                    JOptionPane.PLAIN_MESSAGE);
                            
                            
                            }
                        
                            if(tipp.equals("журнал")){
                                
                                    str = rs.getString("NAIMENOVANIE")+"          "+rs.getString("DATA")+"          "+rs.getString("STRANICI")+"          "+rs.getString("IZDATELSTVO")+"          "+rs.getString("SPISOK_STATEI")+"\n";
                                    
                                    JOptionPane.showMessageDialog(null,
                                            str,
                                            "Просмотр информации выбранного издания",
                                        JOptionPane.PLAIN_MESSAGE);
                                
                                
                                }
                        
                        
                            if(tipp.equals("брошюра")){
                                
                                    str = rs.getString("NAIMENOVANIE")+"          "+rs.getString("DATA")+"          "+rs.getString("IZDATELSTVO")+"          "+rs.getString("KRATKOE_SODERZHANIE")+"\n";
                                    
                                    JOptionPane.showMessageDialog(null,
                                            str,
                                            "Просмотр информации выбранного издания",
                                        JOptionPane.PLAIN_MESSAGE);
                                
                                
                                }
                        
                        
                        
                            
                        
                        
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
        
        
        
        
	
	class ButtonEventListener implements ActionListener {
		
                
                               
                
                public void actionPerformed(ActionEvent e) {
			
			
			String mess2="Указанный идентификатор не существует в системе!";
                        
                        
                        s=0;
                        message = input.getText();
		    
		    
            
			
			
                        
		    prosmotrizdania();
                        
                        
                        
                        
            if (s==0){
                
                    JOptionPane.showMessageDialog(null,
                            mess2,
                            "Сообщение",
                        JOptionPane.PLAIN_MESSAGE);
                
                }
		    
                        
                        
                        
                        
                        
		}
	}

	
}