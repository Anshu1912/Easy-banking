package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panField, aadharField;
    JComboBox religionField, categoryField, incomeField, educationField, occupationField;
    JRadioButton seniorYes, seniorNo, existYes, existNo;
    JButton next;
    JPanel p;
    JFrame frame;
    String formno;

    SignupTwo(String formno) {

        this.formno = formno;
        frame = new JFrame("Application Form ");
        p = new JPanel();

        JLabel formNo = new JLabel("FORM NO:" + formno);
        formNo.setFont(new Font("Osward", Font.BOLD, 15));
        formNo.setBounds(580, 20, 150, 30);
        p.add(formNo);

        JLabel pageotwo = new JLabel("Page 2: Additional Details");
        pageotwo.setFont(new Font("Osward", Font.BOLD, 15));
        pageotwo.setBounds(300, 50, 500, 30);
        p.add(pageotwo);

        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Osward", Font.BOLD, 20));
        religion.setBounds(100, 140, 300, 30);
        p.add(religion);

        String relArray[] = {"Hindu", "Muslim", "Sikh", "Christian", "Jain", "Other"};
        religionField = new JComboBox(relArray);
        religionField.setBounds(400, 140, 300, 30);
        religionField.setBackground(Color.white);
        p.add(religionField);

        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Osward", Font.BOLD, 20));
        category.setBounds(100, 200, 300, 30);
        p.add(category);

        String catArray[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryField = new JComboBox(catArray);
        categoryField.setBounds(400, 200, 300, 30);
        categoryField.setBackground(Color.white);
        p.add(categoryField);

        JLabel education = new JLabel("Educational Qualification: ");
        education.setFont(new Font("Osward", Font.BOLD, 20));
        education.setBounds(100, 260, 300, 30);
        p.add(education);

        String edArray[] = {"Non-Graduation", "Graduation", "Post Graduation", "Other"};
        educationField = new JComboBox(edArray);
        educationField.setBounds(400, 260, 300, 30);
        educationField.setBackground(Color.white);
        p.add(educationField);

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Osward", Font.BOLD, 20));
        occupation.setBounds(100, 320, 300, 30);
        p.add(occupation);

        String occArray[] = {"Student", "Salaried", "Self Employee", "Business", "Retired", "Other"};
        occupationField = new JComboBox(occArray);
        occupationField.setBounds(400, 320, 300, 30);
        occupationField.setBackground(Color.white);

        p.add(occupationField);

        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Osward", Font.BOLD, 20));
        income.setBounds(100, 380, 300, 30);
        p.add(income);

        String incArray[] = {"Null", "<2,00,000", "<5,00,000", "Upto 10,00,000", "More than 10,00,000"};
        incomeField = new JComboBox(incArray);
        incomeField.setBounds(400, 380, 300, 30);
        incomeField.setBackground(Color.white);
        p.add(incomeField);

        JLabel pan = new JLabel("PAN Number: ");
        pan.setFont(new Font("Osward", Font.BOLD, 20));
        pan.setBounds(100, 440, 300, 30);
        p.add(pan);

        panField = new JTextField();
        panField.setBounds(400, 440, 300, 30);
        p.add(panField);

        JLabel aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Osward", Font.BOLD, 20));
        aadhar.setBounds(100, 500, 300, 30);
        p.add(aadhar);

        aadharField = new JTextField();
        aadharField.setBounds(400, 500, 300, 30);
        p.add(aadharField);

        JLabel senior = new JLabel("Senior Citizen: ");
        senior.setFont(new Font("Osward", Font.BOLD, 20));
        senior.setBounds(100, 560, 300, 30);
        p.add(senior);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(400, 560, 100, 30);
        seniorYes.setBackground(Color.white);
        p.add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(510, 560, 100, 30);
        seniorNo.setBackground(Color.white);
        p.add(seniorNo);

        JLabel existAcc = new JLabel("Existing Account: ");
        existAcc.setFont(new Font("Osward", Font.BOLD, 20));
        existAcc.setBounds(100, 620, 300, 30);
        p.add(existAcc);

        existYes = new JRadioButton("Yes");
        existYes.setBounds(400, 620, 100, 30);
        existYes.setBackground(Color.white);
        p.add(existYes);

        existNo = new JRadioButton("No");
        existNo.setBounds(510, 620, 100, 30);
        existNo.setBackground(Color.white);
        p.add(existNo);

        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(seniorYes);
        seniorgroup.add(seniorNo);

        ButtonGroup existgroup = new ButtonGroup();
        existgroup.add(existYes);
        existgroup.add(existNo);

        next = new JButton("Next");
        next.setFont(new Font("Osward", Font.BOLD, 20));
        next.setBounds(600, 700, 100, 30);
        p.add(next);
        next.addActionListener(this);

        p.setBackground(Color.white);
        p.setLayout(null);
        frame.add(p);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setLocation(350, 10);
    }

    public void actionPerformed(ActionEvent ae) {

        String religion = (String) religionField.getSelectedItem();
        String category = (String) categoryField.getSelectedItem();
        String education = (String) educationField.getSelectedItem();
        String occupation = (String) occupationField.getSelectedItem();
        String income = (String) incomeField.getSelectedItem();
        String pan = panField.getText();
        String aadhar = aadharField.getText();

        String senior = null;
        if (seniorYes.isSelected()) {
            senior = "Yes";
        } else if (seniorNo.isSelected()) {
            senior = "No";
        }
        String existAccount = null;
        if (existYes.isSelected()) {
            existAccount = "Yes";
        } else if (existNo.isSelected()) {
            existAccount = "No";
        }

        try {
            if (pan.equals("")) {
                JOptionPane.showMessageDialog(p, "PAN Number is Mandatory!");
            }
            if (aadhar.equals("")) {
                JOptionPane.showMessageDialog(p, "Aadhar Number is Mandatory!");
            } else {
                DbConnect c = new DbConnect();
                String query = "insert into signuptwo values('" + formno + "','" + religion + "','" + category + "','" + education + "','" + occupation + "','" + income + "','" + pan + "','" + aadhar + "','" + senior + "','" + existAccount + "')";
                c.s.executeUpdate(query);
                frame.setVisible(false);
                new SignupThree(formno).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] ar) {

        new SignupTwo("");
    }

}
