package atm.simulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    String formno;
    JPanel p;
    JRadioButton saving, current, fixed, recurring;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton cancel, submit;
    JFrame frame;

    SignupThree(String formno) {
        this.formno = formno;
        frame = new JFrame("Application Form ");
        p = new JPanel();

        JLabel formNo = new JLabel("FORM NO: " + formno);
        formNo.setFont(new Font("Osward", Font.BOLD, 15));
        formNo.setBounds(580, 20, 150, 30);
        p.add(formNo);

        JLabel pagethree = new JLabel("Page 3: Account Details");
        pagethree.setFont(new Font("Osward", Font.BOLD, 15));
        pagethree.setBounds(300, 50, 500, 30);
        p.add(pagethree);

        JLabel accType = new JLabel("Account Type: ");
        accType.setFont(new Font("Osward", Font.BOLD, 25));
        accType.setBounds(100, 140, 300, 30);
        p.add(accType);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(100, 190, 200, 30);
        saving.setFont(new Font("Osward", Font.BOLD, 15));
        saving.setBackground(Color.white);
        p.add(saving);

        current = new JRadioButton("Current Account");
        current.setBounds(100, 225, 200, 30);
        current.setFont(new Font("Osward", Font.BOLD, 15));
        current.setBackground(Color.white);
        p.add(current);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setBounds(350, 190, 250, 30);
        fixed.setFont(new Font("Osward", Font.BOLD, 15));
        fixed.setBackground(Color.white);
        p.add(fixed);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setBounds(350, 225, 250, 30);
        recurring.setFont(new Font("Osward", Font.BOLD, 15));
        recurring.setBackground(Color.white);
        p.add(recurring);

        JLabel cardno = new JLabel("Card Number: ");
        cardno.setFont(new Font("Osward", Font.BOLD, 25));
        cardno.setBounds(100, 295, 250, 30);
        p.add(cardno);

        JLabel cardinfo = new JLabel("Your 16 digit Card Number");
        cardinfo.setFont(new Font("Osward", Font.BOLD, 12));
        cardinfo.setBounds(100, 320, 300, 30);
        p.add(cardinfo);

        JLabel cdummy = new JLabel("XXXX-XXXX-XXXX-XXXX");
        cdummy.setFont(new Font("Osward", Font.BOLD, 20));
        cdummy.setBounds(350, 295, 300, 30);
        p.add(cdummy);

        JLabel pinno = new JLabel("PIN: ");
        pinno.setFont(new Font("Osward", Font.BOLD, 25));
        pinno.setBounds(100, 375, 250, 30);
        p.add(pinno);

        JLabel pdummy = new JLabel("XXXX");
        pdummy.setFont(new Font("Osward", Font.BOLD, 20));
        pdummy.setBounds(350, 375, 300, 30);
        p.add(pdummy);

        JLabel pininfo = new JLabel("Your 4 digit Password");
        pininfo.setFont(new Font("Osward", Font.BOLD, 12));
        pininfo.setBounds(100, 400, 300, 30);
        p.add(pininfo);

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Osward", Font.BOLD, 25));
        services.setBounds(100, 450, 300, 30);
        p.add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Osward", Font.BOLD, 15));
        c1.setBounds(100, 500, 250, 30);
        c1.setBackground(Color.white);
        p.add(c1);

        c2 = new JCheckBox("Net Banking");
        c2.setFont(new Font("Osward", Font.BOLD, 15));
        c2.setBounds(350, 500, 250, 30);
        c2.setBackground(Color.white);
        p.add(c2);

        c3 = new JCheckBox("Mobile banking");
        c3.setFont(new Font("Osward", Font.BOLD, 15));
        c3.setBounds(100, 550, 250, 30);
        c3.setBackground(Color.white);
        p.add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Osward", Font.BOLD, 15));
        c4.setBounds(350, 550, 250, 30);
        c4.setBackground(Color.white);
        p.add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Osward", Font.BOLD, 15));
        c5.setBounds(100, 600, 250, 30);
        c5.setBackground(Color.white);
        p.add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Osward", Font.BOLD, 15));
        c6.setBounds(350, 600, 250, 30);
        c6.setBackground(Color.white);
        p.add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Osward", Font.BOLD, 12));
        c7.setBounds(100, 650, 700, 30);
        c7.setBackground(Color.white);
        p.add(c7);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Osward", Font.BOLD, 20));
        cancel.setBounds(200, 700, 100, 30);
        p.add(cancel);
        cancel.addActionListener(this);

        submit = new JButton("Submit");
        submit.setFont(new Font("Osward", Font.BOLD, 20));
        submit.setBounds(500, 700, 100, 30);
        p.add(submit);
        submit.addActionListener(this);

        ButtonGroup accTypegroup = new ButtonGroup();
        accTypegroup.add(saving);
        accTypegroup.add(current);
        accTypegroup.add(fixed);
        accTypegroup.add(recurring);

        p.setBackground(Color.white);
        p.setLayout(null);
        frame.add(p);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setLocation(350, 10);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accType = null;
            if (saving.isSelected()) {
                accType = "Saving";
            } else if (current.isSelected()) {
                accType = "Current";
            } else if (fixed.isSelected()) {
                accType = "Fixed Deposit";
            } else if (recurring.isSelected()) {
                accType = "Recurring";
            }
            Random random = new Random();
            String cardno = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinno = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String services = null;
            if (c1.isSelected()) {
                services = services + " ATM Card";
            } else if (c2.isSelected()) {
                services = services + " Net Banking";
            } else if (c3.isSelected()) {
                services = services + " Mobile Banking";
            } else if (c4.isSelected()) {
                services = services + " Email & SMS Alerts";
            } else if (c5.isSelected()) {
                services = services + " Cheque Book";
            } else if (c6.isSelected()) {
                services = services + " E-Statement";
            }

            try {
                if (accType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account type is required");
                } else {
                    DbConnect conn = new DbConnect();
                    String query1 = "insert into signupthree values('" + formno + "','" + accType + "','" + cardno + "','" + pinno + "','" + services + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardno + "','" + pinno + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin: " + pinno);
                    frame.setVisible(false);
                    new Login().setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] ar) {

        new SignupThree("");
    }

}
