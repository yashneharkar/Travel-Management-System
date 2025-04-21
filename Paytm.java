
package travel.management.system;

import java.awt.Desktop;
import java.awt.event.*;
import java.net.URI;
import javax.swing.*;


public class Paytm extends JFrame implements ActionListener{
    JButton back;
    
    Paytm (){
        setBounds(500, 200, 800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        
        try 
        {
            Desktop.getDesktop().browse(new URI("https://paytm.com"));
        } 
        catch (Exception e) 
        {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error: " + e.getMessage() + "<html>"); // Show specific error message
        
        }
        
        // Add the pane to a scroll pane
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp, "Center"); // Add the scroll pane to the center
        
        // Create and add the back button
        back = new JButton("Back");
        back.setBounds(610, 20, 80, 40);
        back.addActionListener(this);
        pane.add(back); // Add back button to the main frame
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Payment();
    }

    public static void main(String[] args) {
        new Paytm();
    }
}
