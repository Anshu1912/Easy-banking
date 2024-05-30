package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {

    int r;
    JTextField nameField, fnameField, emailField, phoneNoField, addField, cityField, stateField, pinField;
    JDateChooser dobdate;
    JRadioButton male, female, others;
    JButton next;
    JPanel p;
    JFrame frame;

    SignupOne() {

        Random rand = new Random();
        r = rand.nextInt(9999);
        frame = new JFrame("Application Form");
        p = new JPanel();

        JLabel formNo = new JLabel("APPLICATION FORM NO: " + r);
        formNo.setFont(new Font("Osward", Font.BOLD, 30));
        formNo.setBounds(200, 20, 500, 30);
        p.add(formNo);

        JLabel pageone = new JLabel("Part 1: Personal Details");
        pageone.setFont(new Font("Osward", Font.BOLD, 15));
        pageone.setBounds(300, 80, 500, 30);
        p.add(pageone);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Osward", Font.BOLD, 20));
        name.setBounds(100, 130, 300, 30);
        p.add(name);

        nameField = new JTextField();
        nameField.setBounds(400, 130, 300, 30);
        p.add(nameField);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Osward", Font.BOLD, 20));
        fname.setBounds(100, 180, 300, 30);
        p.add(fname);

        fnameField = new JTextField();
        fnameField.setBounds(400, 180, 300, 30);
        p.add(fnameField);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Osward", Font.BOLD, 20));
        dob.setBounds(100, 230, 300, 30);
        p.add(dob);

        dobdate = new JDateChooser();
        dobdate.setBounds(400, 230, 300, 30);
        p.add(dobdate);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Osward", Font.BOLD, 20));
        gender.setBounds(100, 280, 300, 30);
        p.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(400, 280, 100, 30);
        male.setBackground(Color.white);
        p.add(male);

        female = new JRadioButton("Female");
        female.setBounds(510, 280, 100, 30);
        female.setBackground(Color.white);
        p.add(female);

        others = new JRadioButton("Others");
        others.setBounds(620, 280, 100, 30);
        others.setBackground(Color.white);
        p.add(others);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);

        JLabel phoneNo = new JLabel("Phone No: ");
        phoneNo.setFont(new Font("Osward", Font.BOLD, 20));
        phoneNo.setBounds(100, 330, 300, 30);
        p.add(phoneNo);

        phoneNoField = new JTextField();
        phoneNoField.setBounds(400, 330, 300, 30);
        p.add(phoneNoField);

        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Osward", Font.BOLD, 20));
        email.setBounds(100, 380, 300, 30);
        p.add(email);

        emailField = new JTextField();
        emailField.setBounds(400, 380, 300, 30);
        p.add(emailField);

        JLabel add = new JLabel("Address: ");
        add.setFont(new Font("Osward", Font.BOLD, 20));
        add.setBounds(100, 430, 300, 30);
        p.add(add);

        addField = new JTextField();
        addField.setBounds(400, 430, 300, 30);
        p.add(addField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Osward", Font.BOLD, 20));
        city.setBounds(100, 480, 300, 30);
        p.add(city);

        cityField = new JTextField();
        cityField.setBounds(400, 480, 300, 30);
        p.add(cityField);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Osward", Font.BOLD, 20));
        state.setBounds(100, 530, 300, 30);
        p.add(state);

        stateField = new JTextField();
        stateField.setBounds(400, 530, 300, 30);
        p.add(stateField);

        JLabel pin = new JLabel("PIN Code: ");
        pin.setFont(new Font("Osward", Font.BOLD, 20));
        pin.setBounds(100, 580, 300, 30);
        p.add(pin);

        pinField = new JTextField();
        pinField.setBounds(400, 580, 300, 30);
        p.add(pinField);

        next = new JButton("Next");
        next.setFont(new Font("Osward", Font.BOLD, 20));
        next.setBounds(600, 680, 100, 30);
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
        String formno = "" + r;
        String name = nameField.getText();
        String fname = fnameField.getText();
        String email = emailField.getText();
        String phoneNo = phoneNoField.getText();
        String add = addField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pin = pinField.getText();
        String dob = ((JTextField) dobdate.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (others.isSelected()) {
            gender = "Others";
        }

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(p, "Name is Mandatory!");
            }
            if (fname.equals("")) {
                JOptionPane.showMessageDialog(p, "Father's Name is Mandatory!");
            }
            if (phoneNo.equals("")) {
                JOptionPane.showMessageDialog(p, "Phone No. is Mandatory!");
            }
            if (pin.equals("")) {
                JOptionPane.showMessageDialog(p, "PIN is Mandatory!");
            }
            if (add.equals("")) {
                JOptionPane.showMessageDialog(p, "Address is Mandatory!");
            }
            if (dob.equals("")) {
                JOptionPane.showMessageDialog(p, "Date of Birth is Mandatory!");
            } else {
                DbConnect conn = new DbConnect();
                String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + phoneNo + "','" + email + "','" + add + "','" + state + "','" + city + "','" + pin + "')";
                conn.s.executeUpdate(query);
                frame.setVisible(false);
                new SignupTwo(formno).setVisible(true);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] ar) {

        new SignupOne();
    }
}
