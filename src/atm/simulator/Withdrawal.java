package atm.simulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;
    String pinno;
    JFrame frame;

    Withdrawal(String pinno) {

        this.pinno = pinno;
        frame = new JFrame();
        JPanel p = new JPanel();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        p.add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(170, 300, 400, 20);
        text.setForeground(Color.white);
        text.setFont(new Font("Osward", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        withdraw = new JButton("withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        image.add(withdraw);
        withdraw.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        image.add(back);
        back.addActionListener(this);

        p.setLayout(null);
        frame.add(p);
        frame.setSize(900, 900);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setLocation(350, 0);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter amount you want to withdraw");
            } else {
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
                    if (ae.getSource() != back && balance < Integer.parseInt(number)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    String query = "insert into bank(pin,date,type,amount) values('" + pinno + "','" + date + "','Withdraw','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " withdrawn successfully");
                    frame.setVisible(false);
                    new Transactions(pinno).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        } else if (ae.getSource() == back) {
            frame.setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Withdrawal("");
    }
}
