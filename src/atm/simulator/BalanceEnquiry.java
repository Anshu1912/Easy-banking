package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pinno;
    JFrame frame;
    JButton back;

    BalanceEnquiry(String pinno) {
        this.pinno = pinno;
        frame = new JFrame();
        JPanel p = new JPanel();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        p.add(image);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        image.add(back);
        back.addActionListener(this);

        DbConnect conn = new DbConnect();
        int balance = 0;
        try {

            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinno + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Account Balance " + balance);
        text.setBounds(170, 300, 400, 30);
        text.setForeground(Color.white);
        image.add(text);

        p.setLayout(null);
        frame.add(p);
        frame.setSize(900, 900);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setLocation(350, 0);
    }

    public void actionPerformed(ActionEvent ae) {
        frame.setVisible(false);
        new Transactions(pinno).setVisible(true);
    }

    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
