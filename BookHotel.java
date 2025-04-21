package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {
    
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice; 
    JButton checkprice, bookhotel, back;
    
    BookHotel(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK Hotel");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 21));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblusername.setBounds(40, 70, 100, 20);
        add(lblusername);
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelusername.setBounds(250, 70, 100, 20);
        add(labelusername);
        
        JLabel lblhotel = new JLabel("Select Hotel");
        lblhotel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblhotel.setBounds(40, 110, 150, 20);
        add(lblhotel);
        chotel = new Choice();
        chotel.setBounds(250,110, 240, 20);
        add(chotel);
        try 
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from hotel");
            while(rs.next()) 
            {
                chotel.add(rs.getString("name"));
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblpersons.setBounds(40, 150, 150, 25);
        add(lblpersons);
        tfpersons = new JTextField();
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("No of Days");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbldays.setBounds(40, 190, 150, 25);
        add(lbldays);
        tfdays = new JTextField();
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);
        
        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblac.setBounds(40, 230, 150, 25);
        add(lblac);
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 100, 20);
        add(cac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblfood.setBounds(40, 270, 150, 25);
        add(lblfood);
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);
        
        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblid.setBounds(40, 310, 150, 20);
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(250, 310, 200, 25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblnumber.setBounds(40, 350, 150, 25);
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone no.");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblphone.setBounds(40, 390, 150, 25);
        add(lblphone);
        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 150, 25);
        add(labelphone);
        
        JLabel lblprice = new JLabel("Total Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblprice.setBounds(40, 430, 150, 25);
        add(lblprice);
        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 150, 25);
        add(labelprice);
        
        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                // Get data from the first row
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
            }  
        } 
        catch (Exception e) {
          e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(200, 490, 120, 25);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l13 = new JLabel(i3);
        l13.setBounds(500, 35, 600, 450);
        add(l13);
                
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == checkprice) 
        {
            try 
            {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'"); 
            while(rs.next()) 
            {
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int ac = Integer.parseInt(rs.getString("acroom"));
                int food = Integer.parseInt(rs.getString("foodincluded"));
                
                int persons = Integer.parseInt(tfpersons.getText());
                int days = Integer.parseInt(tfdays.getText());
                
                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                if(persons *days > 0) 
                {
                    int total = 0;
                    total += acselected.equals("AC") ? ac : 0; 
                    total += foodselected.equals("Yes") ? food : 0;
                    total += cost;
                    total = total * persons * days;
                    labelprice.setText("RS " + total);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }
            }
            }
            catch (Exception e) 
            {
            e.printStackTrace();
            }
        }
        else if (ae.getSource() == bookhotel) 
        {
            try 
            {
               Conn c = new Conn();
               c.s.executeUpdate("insert into bookhotels values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"') ");
               JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
               setVisible(false);
               
            }
            catch (Exception e) 
            {
            e.printStackTrace();
            }
        }
        else 
        {
            setVisible(false);
        }
    }   
    
    public static void main(String[] args) {
        new BookHotel("");    
    }
}
