import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class EmployeeManagement extends JFrame implements ActionListener {
    private JTextField nameField, deptField, salaryField;
    private JButton addButton;
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    
    public EmployeeManagement() {
        setTitle("Employee Management Form");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        
        inputPanel.add(new JLabel("Department:"));
        deptField = new JTextField();
        inputPanel.add(deptField);
        
        inputPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        inputPanel.add(salaryField);
        
        addButton = new JButton("Add Employee");
        addButton.addActionListener(this);
        inputPanel.add(new JLabel(""));
        inputPanel.add(addButton);
        
        // Create table
        String[] columns = {"Name", "Department", "Salary"};
        tableModel = new DefaultTableModel(columns, 0);
        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String dept = deptField.getText();
            String salary = salaryField.getText();
            
            if (!name.isEmpty() && !dept.isEmpty() && !salary.isEmpty()) {
                Object[] row = {name, dept, salary};
                tableModel.addRow(row);
                
                // Clear fields
                nameField.setText("");
                deptField.setText("");
                salaryField.setText("");
                
                JOptionPane.showMessageDialog(this, "Employee added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
            }
        }
    }
    
    public static void main(String[] args) {
        new EmployeeManagement();
    }
}