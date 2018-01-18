import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class AppFond extends JFrame {
	
        
        
        private JButton button = new JButton("���������");
        
        
        
        private JTextField input = new JTextField("", 5);
	private JLabel label1 = new JLabel("  ������� ��� �������:");
        private JLabel label2 = new JLabel("    1 - �������� ������������������ ������� � �����");
        private JLabel label3 = new JLabel("    2 - ���������� ������ ������� � ����");
        private JLabel label4 = new JLabel("    3 - �������� ���������� ���������� �������");
        private JLabel label5 = new JLabel("    4 - �������� ���������� �������");
        private JLabel label6 = new JLabel("    5 - �����");
        
        
        
        
        
	
	
	
    
    
    
    public static String str = "" ;
    
    
    
    
    private void create_fond() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/bfond";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("DROP TABLE IF EXISTS TFOND;\n" + 
                " \n" + 
                "CREATE TABLE TFOND\n" + 
                "(\n" + 
                "        ZAPIS_ID SERIAL,\n" + 
                "        \n" + 
                "		TIP TEXT ,\n" + 
                "        AVTOR TEXT ,\n" + 
                "        NAIMENOVANIE TEXT ,\n" + 
                "        DATA TEXT ,\n" + 
                "		STRANICI TEXT ,\n" + 
                "		IZDATELSTVO TEXT ,\n" + 
                "		SPISOK_STATEI TEXT ,\n" + 
                "		ZHANR_KNIGI TEXT ,\n" + 
                "		KRATKOE_SODERZHANIE TEXT ,		\n" + 
                "		\n" + 
                "        PRIMARY KEY (ZAPIS_ID)\n" + 
                ");\n" + 
                " \n" + 
                "INSERT INTO TFOND (TIP, AVTOR, NAIMENOVANIE, DATA,STRANICI,IZDATELSTVO,ZHANR_KNIGI,KRATKOE_SODERZHANIE) VALUES ('�����','������','������� ������','1695 ���','450 ���.','�������','����� � ������','� ������� ��������');\n" + 
                "\n" + 
                " \n" + 
                "INSERT INTO TFOND (TIP, AVTOR, NAIMENOVANIE, DATA,STRANICI,IZDATELSTVO,ZHANR_KNIGI,KRATKOE_SODERZHANIE) VALUES ('�����','���������','���������� ��������','1735 ���','370 ���.','���','����� � ������','� �������� ����������');\n" + 
                "\n" + 
                "\n" + 
                "\n" + 
                "INSERT INTO TFOND (TIP, AVTOR, NAIMENOVANIE, DATA,STRANICI,IZDATELSTVO,ZHANR_KNIGI,KRATKOE_SODERZHANIE) VALUES ('�����','�������','����� � ���','1801 ���','3750 ���.','�������','�����','� �����');\n");
                
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    private void show_fond() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/bfond";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM TFOND");
                while (rs.next()) {
                   str += rs.getString("ZAPIS_ID") +    "          " + rs.getString("TIP")+"          "+rs.getString("NAIMENOVANIE")+"          "+rs.getString("DATA")+"          "+rs.getString("STRANICI")+"          "+rs.getString("IZDATELSTVO")+"\n";
                  
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
        
    
        
        
        public AppFond() {
	    super("������������ ����");
	    this.setBounds(300,100,500,500);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    Container container = this.getContentPane();
	    container.setLayout(new GridLayout(8,1));
	    container.add(label1);
	    container.add(label2);
	    container.add(label3);
	    container.add(label4);
	    container.add(label5);
	    container.add(label6);
            
            
            
            
            
            
            container.add(input);

	 
	
	
	 

	 
	 
	
	 
	 
            
	 
	 
            
           
	     button.addActionListener(new ButtonEventListener());
             container.add(button);
           
           
            
	}
	
	
    class ButtonEventListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                    String message = "";
                    String mess1="������ �������� ����� �������!";
                    
                    message = input.getText();
                
        
        if (message.equals("2")) {
            
                DobavlenieIzdania dob = new DobavlenieIzdania();
                dob.setVisible(true);
            
            
            }  
                    
             else   if (message.equals("3")) {
                    
                        Prosmotr pros = new Prosmotr();
                        pros.setVisible(true);
                    
                    
                    }    
                    
              else  if (message.equals("4")) {
                    
                        Udalenie ud = new Udalenie();
                        ud.setVisible(true);
                    
                    
                    }   
                    
               else  if (message.equals("5")) {
                    
                        System.exit(0);
                    
                    
                    }  
                    
                    
                    
                    
              else  if (message.equals("1")) {
                    
                
                        str="";
                        show_fond();
                        
                        
                        
                        
                        
                        
                        
                        JOptionPane.showMessageDialog(null,
                                str,
                                "������������������ ������� � �����",
                            JOptionPane.PLAIN_MESSAGE);
                    
                    }     
                    
                    else
                    
                    
                    
                    JOptionPane.showMessageDialog(null,
                            mess1,
                            "���������",
                        JOptionPane.PLAIN_MESSAGE);
            }
    }
        
        
        
        
        
    
	public static void main(String[] args) {
		
	    
                
                AppFond app = new AppFond();
		
                app.create_fond();
                
                app.setVisible(true);
	
            
        
        
        }
}




