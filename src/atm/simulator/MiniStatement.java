package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String pinno;
    JFrame frame;

    MiniStatement(String pinno) {

        this.pinno = pinno;
        frame = new JFrame("Mini Statement");
        JPanel p = new JPanel();

        JLabel bank = new JLabel("State Bank of India");
        bank.setBounds(150, 20, 120, 20);
        p.add(bank);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        p.add(mini);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        p.add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        p.add(balance);

        try {
            DbConnect conn = new DbConnect();

            ResultSet rs = conn.s.executeQuery("select * from login where pinno = '" + pinno + "'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardno").substring(0, 4) + "XXXXXXXXXX" + rs.getString("cardno").substring(12, 16));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        int bal = 0;
        try {

            DbConnect conn = new DbConnect();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinno + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            DbConnect conn = new DbConnect();
            ResultSet rs = conn.s.executeQuery("(select * from bank where pin = '" + pinno + "' order by s_no desc limit 5) order by s_no asc");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");

            }
            balance.setText("Balance: " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        p.setLayout(null);
        frame.add(p);
        frame.setSize(400, 600);
        frame.setVisible(true);
        frame.setLocation(20, 20);
        frame.setBackground(Color.white);
    }

    public static void main(String args[]) {
        new MiniStatement("");
    }
}
