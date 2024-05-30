package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JFrame frame;
    JButton change, back;
    JPasswordField pin, repin;
    String pinno;

    PinChange(String pinno) {

        this.pinno = pinno;
        frame = new JFrame();
        JPanel p = new JPanel();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        p.add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 290, 500, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("Osward", Font.BOLD, 16));
        image.add(text);

        JLabel pintext = new JLabel("New PIN: ");
        pintext.setBounds(165, 310, 180, 25);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("Osward", Font.BOLD, 16));
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Osward", Font.BOLD, 16));
        pin.setBounds(330, 310, 180, 25);
        image.add(pin);

        JLabel repintext = new JLabel("Re-Enter New PIN: ");
        repintext.setBounds(165, 370, 180, 25);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("Osward", Font.BOLD, 16));
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Osward", Font.BOLD, 16));
        repin.setBounds(330, 370, 180, 25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        p.setLayout(null);
        frame.add(p);
        frame.setSize(900, 900);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setLocation(350, 0);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter new PIN.");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter new PIN.");
                    return;
                }

                DbConnect conn = new DbConnect();
                String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pinno + "'";
                String query2 = "update login set pinno = '" + rpin + "' where pinno = '" + pinno + "'";
                String query3 = "update signupthree set pinno = '" + rpin + "' where pinno = '" + pinno + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                frame.setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            frame.setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
    }

    public static void main(String ar[]) {
        new PinChange("");
    }

}
