import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMSimulation extends JFrame implements ActionListener {
    private JPasswordField pinField;
    private JButton loginButton, checkBalance, deposit, withdraw;
    private JPanel loginPanel, atmPanel;
    private double balance = 1000.0;
    private final String correctPIN = "1234";
    
    public ATMSimulation() {
        setTitle("ATM Simulation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());
        
        // Create login panel
        loginPanel = new JPanel(new GridLayout(3, 1));
        loginPanel.add(new JLabel("Enter PIN:"));
        pinField = new JPasswordField();
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        
        loginPanel.add(pinField);
        loginPanel.add(loginButton);
        
        // Create ATM operations panel
        atmPanel = new JPanel(new GridLayout(3, 1));
        checkBalance = new JButton("Check Balance");
        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        
        checkBalance.addActionListener(this);
        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        
        atmPanel.add(checkBalance);
        atmPanel.add(deposit);
        atmPanel.add(withdraw);
        
        add(loginPanel, "login");
        add(atmPanel, "atm");
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String enteredPIN = new String(pinField.getPassword());
            if (enteredPIN.equals(correctPIN)) {
                CardLayout cl = (CardLayout) getContentPane().getLayout();
                cl.show(getContentPane(), "atm");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect PIN!");
            }
        } else if (e.getSource() == checkBalance) {
            JOptionPane.showMessageDialog(this, "Your balance is: $" + balance);
        } else if (e.getSource() == deposit) {
            String amount = JOptionPane.showInputDialog("Enter deposit amount:");
            if (amount != null && !amount.isEmpty()) {
                try {
                    double depositAmount = Double.parseDouble(amount);
                    balance += depositAmount;
                    JOptionPane.showMessageDialog(this, "Deposited: $" + depositAmount + "\nNew balance: $" + balance);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid amount!");
                }
            }
        } else if (e.getSource() == withdraw) {
            String amount = JOptionPane.showInputDialog("Enter withdrawal amount:");
            if (amount != null && !amount.isEmpty()) {
                try {
                    double withdrawAmount = Double.parseDouble(amount);
                    if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        JOptionPane.showMessageDialog(this, "Withdrawn: $" + withdrawAmount + "\nNew balance: $" + balance);
                    } else {
                        JOptionPane.showMessageDialog(this, "Insufficient funds!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid amount!");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new ATMSimulation();
    }
}