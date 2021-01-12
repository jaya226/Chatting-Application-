package chatting.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class server extends JFrame implements ActionListener {
	
	 JPanel p1;
	 JTextField t1;
	 JButton b1;
	 static JTextArea a1;
	 
	 static ServerSocket skt;
	 static Socket s;
	 static DataInputStream din;
	 static DataOutputStream dout;
	 
      server(){
    	  
    	  p1 = new JPanel();
    	  p1.setLayout(null);
    	  p1.setBackground(new Color(7,94,84));
    	  p1.setBounds(0, 0, 450, 70);
    	  add(p1);
    	  
    	  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/j/3.png"));
     	 Image i2 = i1.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
     	 ImageIcon i3 = new ImageIcon(i2);
     	 JLabel l1 = new JLabel(i3);
     	 l1.setBounds(5, 17, 30, 30);
     	 p1.add(l1);
     	 
     	 l1.addMouseListener(new MouseAdapter() {
     		 public void mouseClicked(MouseEvent ae) {
     			 System.exit(0);
     		 }
     		 
     	 });

     	ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/j/1.png"));
  	     Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
  	     ImageIcon i6 = new ImageIcon(i5);
  	     JLabel l2 = new JLabel(i6);
  	     l2.setBounds(40, 5, 60, 60);
  	     p1.add(l2);
  	     
  	   ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/j/video.png"));
 	     Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
 	     ImageIcon i9 = new ImageIcon(i8);
 	     JLabel l5 = new JLabel(i9);
 	     l5.setBounds(290, 20, 30, 30);
 	     p1.add(l5);
 	     
 	    ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/j/phone.png"));
  	     Image i12 = i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
  	     ImageIcon i13 = new ImageIcon(i12);
  	     JLabel l6 = new JLabel(i13);
  	     l6.setBounds(350, 20, 35, 30);
  	     p1.add(l6);
  	     
  	   ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/j/3icon.png"));
 	     Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
 	     ImageIcon i16 = new ImageIcon(i15);
 	     JLabel l7 = new JLabel(i16);
 	     l7.setBounds(410, 15, 13, 25);
 	     p1.add(l7);
   	     
   	     JLabel l3 = new JLabel("Gaitonde");
   	     l3.setFont(new Font("SAN_SERIF",Font.BOLD,20));
   	     l3.setForeground(Color.WHITE);
   	     l3.setBounds(110, 17, 100, 20);
   	     p1.add(l3);
   	     
   	     JLabel l4 = new JLabel("Active Now");
	     l4.setFont(new Font("SAN_SERIF",Font.PLAIN,13));
	     l4.setForeground(Color.WHITE);
	     l4.setBounds(110, 37, 100, 20);
	     p1.add(l4);
	     
	    a1 = new JTextArea();
	    a1.setBounds(5, 75, 440, 490);
	    a1.setFont(new Font ("SAN_SERIF",Font.PLAIN,16));
	    a1.setEditable(false);
	    a1.setLineWrap(true);
	    a1.setWrapStyleWord(true);
	    add(a1);
	    
	     
	     
	     t1 = new JTextField();
	     t1.setBounds(5, 570, 310, 30);
	     t1.setFont(new Font ("SAN_SERIF",Font.PLAIN,16));
	     add(t1);
	     
	     b1 = new JButton("send");
	     b1.setBounds(320,570,120,30);
	     b1.setBackground(new Color(7,94,84));
	     b1.setForeground(Color.WHITE);
	     b1.setFont(new Font ("SAN_SERIF",Font.PLAIN,16));
	     b1.addActionListener(this);
	     add(b1);
	     
	     
	      setLayout(null);
    	  setSize(450,600);
    	  setLocation(400,200);
    	  setUndecorated(true);
    	  setVisible(true);
    	  
    	  
      }
      
      public void actionPerformed(ActionEvent ae) {
    	  try {
    	  String out = t1.getText();
    	  a1.setText(a1.getText()+"\n\t\t\t"+out);
    	  dout.writeUTF(out);
    	  t1.setText("");
    	  
    	  
      }catch(Exception e) {
    	  
      }
      }
      
      
      public static void main(String[]args) {
    	  new server().setVisible(true);
    	 
    	 try {
    		 skt = new ServerSocket(6001);
    		 s = skt.accept();
    		 din = new DataInputStream(s.getInputStream());
    		 dout = new DataOutputStream(s.getOutputStream());
    		 String msginput = "" ;
    		 msginput = din.readUTF();
    		 a1.setText(a1.getText()+"\n"+msginput);
    		 
    		 skt.close();
    		 s.close();
    		 
    		 
    		 
    	 }catch(Exception e) {
    		 
    	 }
    	  
      }
}
