package com.Vocab;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Dashboard {
	
	public Dashboard() {
			try {
				JFrame frame=new JFrame("High Frequency Words");
				WordRetrieval wr=new WordRetrieval();
				
				JLabel header = new JLabel("Vocab Builder");
				header.setFont(new Font("Serif", Font.BOLD, 30));
				header.setForeground(Color.BLUE);
				header.setSize(470,80);
				header.setHorizontalAlignment(0);
				
				JLabel label1 = new JLabel("Can We Start?");
				label1.setFont(new Font("Serif", Font.BOLD, 20));
				label1.setForeground(Color.BLACK);
				label1.setSize(470,200);
				label1.setHorizontalAlignment(0);
				
				JLabel label2 = new JLabel("Answer");
				label2.setFont(new Font("Serif", Font.BOLD, 25));
				label2.setForeground(Color.RED);
				label2.setSize(490,450);
				label2.setHorizontalAlignment(JLabel.CENTER);
				label2.setVisible(false);
				
				JButton previous=new JButton("Previous");
				previous.setBounds(35,350,120,30);

				JButton show=new JButton("Show Meaning");
				show.setBounds(185,350,120,30);
				
				JButton next=new JButton("Next");
				next.setBounds(335,350,120,30);
				
				previous.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							label1.setVisible(false);
							label2.setVisible(false);
							wr.onClickPrevious(label1,label2);
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				show.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						 try {
							wr.showMeaning(label1,label2);
						 } catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						 }
					}
				});
				
				next.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							label1.setVisible(false);
							label2.setVisible(false);
							wr.onClickNext(label1);
							
						} catch (SQLException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				
				
				
				frame.setSize(500,500);
				frame.setBackground(Color.gray);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setLayout(null);
		    	frame.setVisible(true);
		    	frame.add(header);
		    	frame.add(label1);
		    	frame.add(label2);
		    	frame.add(previous);
		    	frame.add(show);
		    	frame.add(next);
		    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			catch(Exception e)
				{
				System.out.println(e);
				}
	}
	
}


