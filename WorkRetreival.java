package com.Vocab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;

public class WordRetrieval {
	
	 static final String driver = "com.mysql.jdbc.Driver";  
	 static final String url = "jdbc:mysql://localhost:3306/Vocab";
	 static final String user = "root";
	 static final String pass = "";
	 static ResultSet rst = null;
	 static Statement st = null;
	 private Connection con;
	 private String nextWord;
	 private int id =0;
	 private String previousWord;
	 private String meaning;
	 private int endFlag=0;
	 
	 public Connection getConnection() throws SQLException,ClassNotFoundException 
	 {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			return con;
	 } 
	 
	 public void onClickNext(JLabel label1) throws SQLException, ClassNotFoundException
	 {
		 if(id<60 && id>=0)
		 {
		 endFlag=0;
		 id++;
		 con = getConnection();
		 st=con.createStatement();
		 System.out.println(id);
		 rst=st.executeQuery("select Question from vocab where id="+id);
		 while(rst.next())
		 {
				nextWord=rst.getString(1);
		 }
		 label1.setText(nextWord);
		 label1.setVisible(true);
		 }
		 else
		 {
			 endFlag=1;
			 label1.setText("Thats all for the day Folks!!!");
			 label1.setVisible(true);
		 }
	 }
	 
	 public void onClickPrevious(JLabel label1,JLabel label2) throws ClassNotFoundException, SQLException
	 {
		 if(id<=60 && id>1)
		 {
		 endFlag=0;
		 id--;
		 con=getConnection();
		 st=con.createStatement();
		 System.out.println(id);
		 rst=st.executeQuery("select Question from vocab where id="+id);
		 while(rst.next())
		 {
			previousWord=rst.getString(1);
		 }
		 label1.setText(previousWord);
		 label1.setVisible(true);
		 }
		 else
		 {	 
			 endFlag=1;
			 label1.setText("Thats all for the day Folks!!!");
			 label1.setVisible(true);
		 }
	}

	public void showMeaning(JLabel label1,JLabel label2) throws ClassNotFoundException, SQLException 
	{
		if(endFlag!=1)
		{
		if(id>0 && id<=60)
		{
			con=getConnection();
			st=con.createStatement();
			ResultSet rst2=st.executeQuery("select answer from vocab where id="+id);
			while(rst2.next())
			{
				meaning=rst2.getString(1);
			}
			label2.setText("<html>'"+meaning+"'</html>");
			label2.setVisible(true);
		}
		}
	}
}
