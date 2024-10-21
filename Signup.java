package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Signup extends JFrame implements ActionListener{
    
    JButton create, back;
    JTextField tfname, tfusername, tfpassword, tfanswer;
    Choice security;
    
    Signup() {
        setBounds(350, 200, 900, 360);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel pl = new JPanel();
        pl.setBackground(new Color(131, 193, 232));
        pl.setBounds(0, 0, 400, 400);
        pl.setLayout(null);
        add(pl);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50, 20, 125, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        pl.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfusername);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 60, 125, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        pl.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfname);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(50, 100, 125, 25);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        pl.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfpassword);
        
        JLabel lblsecurity = new JLabel("Security");
        lblsecurity.setBounds(50, 140, 125, 25);
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        pl.add(lblsecurity);
        
        security = new Choice();
        security.add("School Name");
        security.add("Fav Month");
        security.add("Fav Marvel Superhero");
        security.setBounds(190, 140, 180, 25);
        pl.add(security);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(50, 180, 125, 25);
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        pl.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfanswer);
          
        create = new JButton("Create");
        create.setBounds(80, 250, 100, 30);
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.addActionListener(this);
        pl.add(create);
        
        back = new JButton("Back");
        back.setBounds(250, 250, 100, 30);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        pl.add(back);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = il.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == create) {
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();
            
            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            try {
               Conn c = new Conn(); 
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Account Created Successfully");
               setVisible(false);
               new Login();
            
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == back) {
                setVisible(false);
                new Login();
                }
    }
    
    public static void main(String[] args){
        new Signup();
    }
    
}
