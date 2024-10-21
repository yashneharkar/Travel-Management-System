package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePresonalDetails, checkpackages, viewhotel, destination;
    Dashboard(String username){
        this.username = username;
//        setBounds(0, 0, 1600, 1000);
          setExtendedState(JFrame.MAXIMIZED_BOTH);
          setLayout(null);
          
          JPanel pl = new JPanel();
          pl.setLayout(null);
          pl.setBackground(new Color(0, 0, 102));
          pl.setBounds(0, 0, 1600, 65);
          add(pl);
          
          ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.PNG"));
          Image i2 = il.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
          ImageIcon i3 = new ImageIcon(i2);
          JLabel icon = new JLabel(i3);
          icon.setBounds(5, 0, 70, 70);
          pl.add(icon);
          
          JLabel heading = new JLabel("Dashboard");
          heading.setBounds(80, 10, 300, 40);
          heading.setForeground(Color.WHITE);
          heading.setFont(new Font("Tahoma", Font.BOLD, 30));
          pl.add(heading);
          
          JPanel p2 = new JPanel();
          p2.setLayout(null);
          p2.setBackground(new Color(0, 0, 102));
          p2.setBounds(0, 65, 300, 900);
          add(p2);
          
          addPersonalDetails = new JButton("Add Personal Details");
          addPersonalDetails.setBounds(0, 0, 300, 50);
          addPersonalDetails.setBackground(new Color(0, 0, 102));
          addPersonalDetails.setForeground(Color.WHITE);
          addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
          addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
          addPersonalDetails.addActionListener(this);
          p2.add(addPersonalDetails);
          
          updatePresonalDetails = new JButton("Update Personal Details");
          updatePresonalDetails.setBounds(0, 50, 300, 50);
          updatePresonalDetails.setBackground(new Color(0, 0, 102));
          updatePresonalDetails.setForeground(Color.WHITE);
          updatePresonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
          updatePresonalDetails.setMargin(new Insets(0, 0, 0, 30));
          updatePresonalDetails.addActionListener(this);
          p2.add(updatePresonalDetails);
          
          viewPersonalDetails = new JButton("View Details");
          viewPersonalDetails.setBounds(0, 100, 300, 50);
          viewPersonalDetails.setBackground(new Color(0, 0, 102));
          viewPersonalDetails.setForeground(Color.WHITE);
          viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
          viewPersonalDetails.setMargin(new Insets(0, 0, 0, 130));
          viewPersonalDetails.addActionListener(this);
          p2.add(viewPersonalDetails);
          
//          JButton deletePresonalDetails = new JButton("Delete Presonal Details");
//          deletePresonalDetails.setBounds(0, 150, 300, 50);
//          deletePresonalDetails.setBackground(new Color(0, 0, 102));
//          deletePresonalDetails.setForeground(Color.WHITE);
//          deletePresonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
//          deletePresonalDetails.setMargin(new Insets(0, 0, 0, 40));
//          p2.add(deletePresonalDetails);
          
          checkpackages = new JButton("Check Packages");
          checkpackages.setBounds(0, 150, 300, 50);
          checkpackages.setBackground(new Color(0, 0, 102));
          checkpackages.setForeground(Color.WHITE);
          checkpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
          checkpackages.setMargin(new Insets(0, 0, 0, 110));
          checkpackages.addActionListener(this);
          p2.add(checkpackages);
          
          viewhotel = new JButton("Check Hotels");
          viewhotel.setBounds(0, 200, 300, 50);
          viewhotel.setBackground(new Color(0, 0, 102));
          viewhotel.setForeground(Color.WHITE);
          viewhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
          viewhotel.setMargin(new Insets(0, 0, 0, 120));
          viewhotel.addActionListener(this);
          p2.add(viewhotel);
          
          destination = new JButton("Destinations");
          destination.setBounds(0, 250, 300, 50);
          destination.setBackground(new Color(0, 0, 102));
          destination.setForeground(Color.WHITE);
          destination.setFont(new Font("Tahoma", Font.PLAIN, 20));
          destination.setMargin(new Insets(0, 0, 0, 120));
          destination.addActionListener(this);
          p2.add(destination);
          
          ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
          Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
          ImageIcon i6 = new ImageIcon(i5);
          JLabel image = new JLabel(i6);
          image.setBounds(0, 0, 1650, 1000);
          add(image);
          
          JLabel text = new JLabel("TRAVEL AND TOURISM MANAGEMENT SYSTEM");
          text.setBounds(400, 70, 1000, 70);
          text.setForeground(Color.WHITE);
          text.setFont(new Font("Raleway", Font.PLAIN, 40));
          image.add(text);
     
          setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addPersonalDetails) 
        {
            new AddCustomer(username);
        }
        else if (ae.getSource() == viewPersonalDetails) 
        {
            new ViewCustomer(username);
        }
        else if (ae.getSource() == updatePresonalDetails) 
        {
            new UpdateCustomer(username);
        }
        else if (ae.getSource() == checkpackages) 
        {
            new CheckPackage();
        }
        else if (ae.getSource() == viewhotel) 
        {
            new CheckHotels();
        }
        else if (ae.getSource() == destination) 
        {
            new Destinations();
        }
    }
    
    public static void main(String[] args){
        new Dashboard("");
    }
}
