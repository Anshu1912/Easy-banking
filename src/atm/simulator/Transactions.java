package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawal, ministatement, pinchange, fastcash, balanceenquiry, exit;
    String pinno;
    JFrame frame;

    Transactions(String pinno) {
        this.pinno = pinno;
        frame = new JFrame();
        JPanel p = new JPanel();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        p.add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("Osward", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        image.add(deposit);
        deposit.addActionListener(this);

        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(355, 415, 150, 30);
        image.add(withdrawal);
        withdrawal.addActionListener(this);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        image.add(fastcash);
        fastcash.addActionListener(this);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
        image.add(ministatement);
        ministatement.addActionListener(this);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 485, 150, 30);
        image.add(pinchange);
        pinchange.addActionListener(this);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355, 485, 150, 30);
        image.add(balanceenquiry);
        balanceenquiry.addActionListener(this);

        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        image.add(exit);
        exit.addActionListener(this);

        p.setLayout(null);
        frame.add(p);
        frame.setSize(900, 900);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setLocation(350, 0);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            frame.setVisible(false);
            new Deposit(pinno).setVisible(true);
        } else if (ae.getSource() == withdrawal) {
            frame.setVisible(false);
            new Withdrawal(pinno).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            frame.setVisible(false);
            new Fastcash(pinno).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            frame.setVisible(false);
            new PinChange(pinno).setVisible(true);
        } else if (ae.getSource() == balanceenquiry) {
            frame.setVisible(false);
            new BalanceEnquiry(pinno).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            new MiniStatement(pinno).setVisible(true);
        }

    }

    public static void main(String args[]) {
        new Transactions("");
    }

}
