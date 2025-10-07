import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShoppingCartSimulation extends JFrame implements ActionListener {
    private JCheckBox laptop, phone, headphones;
    private JButton generateBill;
    private JTextArea billArea;
    
    public ShoppingCartSimulation() {
        setTitle("Shopping Cart Simulation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create checkboxes
        JPanel itemPanel = new JPanel(new GridLayout(3, 1));
        laptop = new JCheckBox("Laptop - $1000");
        phone = new JCheckBox("Phone - $500");
        headphones = new JCheckBox("Headphones - $100");
        
        itemPanel.add(laptop);
        itemPanel.add(phone);
        itemPanel.add(headphones);
        
        // Create button
        generateBill = new JButton("Generate Bill");
        generateBill.addActionListener(this);
        
        // Create text area for bill
        billArea = new JTextArea(10, 30);
        billArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(billArea);
        
        add(itemPanel, BorderLayout.NORTH);
        add(generateBill, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateBill) {
            StringBuilder bill = new StringBuilder("BILL:\n");
            int total = 0;
            
            if (laptop.isSelected()) {
                bill.append("Laptop - $1000\n");
                total += 1000;
            }
            if (phone.isSelected()) {
                bill.append("Phone - $500\n");
                total += 500;
            }
            if (headphones.isSelected()) {
                bill.append("Headphones - $100\n");
                total += 100;
            }
            
            bill.append("\nTotal: $" + total);
            billArea.setText(bill.toString());
        }
    }
    
    public static void main(String[] args) {
        new ShoppingCartSimulation();
    }
}