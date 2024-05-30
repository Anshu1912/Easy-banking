package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton signIn, signUp, clear;
    JTextField cardField;
    JPasswordField pinField;

    Login() {

        JFrame frame = new JFrame("ATM Simulator");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel logo = new JLabel(i3);
        logo.setBounds(60, 10, 100, 100);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setBounds(150, 150, 150, 40);
        cardNo.setFont(new Font("Osward", Font.BOLD, 25));

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(150, 200, 150, 40);
        pin.setFont(new Font("Osward", Font.BOLD, 25));

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(220, 40, 350, 40);

        cardField = new JTextField();
        cardField.setBounds(300, 150, 250, 35);

        pinField = new JPasswordField();
        pinField.setBounds(300, 200, 250, 35);

        signIn = new JButton("Sign IN");
        signIn.setBounds(300, 270, 120, 40);
        signIn.addActionListener(this);

        signUp = new JButton("Sign UP");
        signUp.setBounds(300, 325, 250, 40);
        signUp.addActionListener(this);

        clear = new JButton("Clear");
        clear.setBounds(430, 270, 120, 40);
        clear.addActionListener(this);

        JPanel p = new JPanel();
        p.add(signIn);
        p.add(signUp);
        p.add(clear);
        p.add(cardField);
        p.add(pinField);
        p.add(pin);
        p.add(logo);
        p.add(text);
        p.add(cardNo);
        p.setBackground(Color.white);
        p.setLayout(null);
        frame.add(p);       
        frame.setSize(800, 480);
        frame.setVisible(true);
        frame.setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == clear) {

            cardField.setText("");
            pinField.setText("");

        } else if (ae.getSource() == signIn) {
            DbConnect conn = new DbConnect();
            String cardno = cardField.getText();
            String pinno = pinField.getText();
            String query = "select * from login where cardno = '" + cardno + "' and pinno = '" + pinno + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinno).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] arg) {
        new Login();
    }
}
