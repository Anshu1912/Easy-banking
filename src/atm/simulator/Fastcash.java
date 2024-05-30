package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;

public class Fastcash extends JFrame implements ActionListener {

    JButton deposit, withdrawal, ministatement, pinchange, fastcash, balanceenquiry, back;
    String pinno;
    JFrame frame;

    Fastcash(String pinno) {
        this.pinno = pinno;
        frame = new JFrame();
        //JPanel p = new JPanel();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        frame.add(image);

        JLabel text = new JLabel("SELECT WITHDRAW AMOUNT");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("Osward", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Rs 500");
        deposit.setFont(new Font("Osward", Font.BOLD, 20));
        deposit.setBounds(170, 415, 150, 30);
        image.add(deposit);
        deposit.addActionListener(this);

        withdrawal = new JButton("Rs 1000");
        withdrawal.setFont(new Font("Osward", Font.BOLD, 20));
        withdrawal.setBounds(355, 415, 150, 30);
        image.add(withdrawal);
        withdrawal.addActionListener(this);

        fastcash = new JButton("Rs 2000");
        fastcash.setFont(new Font("Osward", Font.BOLD, 20));
        fastcash.setBounds(170, 450, 150, 30);
        image.add(fastcash);
        fastcash.addActionListener(this);

        ministatement = new JButton("Rs 5000");
        ministatement.setFont(new Font("Osward", Font.BOLD, 20));
        ministatement.setBounds(355, 450, 150, 30);
        image.add(ministatement);
        ministatement.addActionListener(this);

        pinchange = new JButton("Rs 10000");
        pinchange.setFont(new Font("Osward", Font.BOLD, 20));
        pinchange.setBounds(170, 485, 150, 30);
        image.add(pinchange);
        pinchange.addActionListener(this);

        back = new JButton("Back");
        back.setFont(new Font("Osward", Font.BOLD, 20));
        back.setBounds(355, 520, 150, 30);
        image.add(back);
        back.addActionListener(this);

        frame.setLayout(null);
        //frame.add(p);
        frame.setSize(900, 900);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setLocation(350, 0);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            frame.setVisible(false);
            new Transactions(pinno).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            try {
                DbConnect conn = new DbConnect();
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinno + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank(pin,date,type,amount) values('" + pinno + "','" + date + "','Withdraw','" + amount + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " withdrawn successfully");
                frame.setVisible(false);
                new Transactions(pinno).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new Fastcash("");
    }

}
