import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlineFeedbackForm extends JFrame implements ActionListener {
    private JRadioButton[] starButtons;
    private ButtonGroup ratingGroup;
    private JTextArea commentArea;
    private JButton submitButton;
    
    public OnlineFeedbackForm() {
        setTitle("Online Feedback Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Rating panel
        JPanel ratingPanel = new JPanel();
        ratingPanel.add(new JLabel("Rate our service (1-5 stars):"));
        
        starButtons = new JRadioButton[5];
        ratingGroup = new ButtonGroup();
        
        for (int i = 0; i < 5; i++) {
            starButtons[i] = new JRadioButton((i + 1) + " Star" + (i > 0 ? "s" : ""));
            ratingGroup.add(starButtons[i]);
            ratingPanel.add(starButtons[i]);
        }
        
        // Comment panel
        JPanel commentPanel = new JPanel(new BorderLayout());
        commentPanel.add(new JLabel("Comments:"), BorderLayout.NORTH);
        commentArea = new JTextArea(5, 30);
        commentArea.setBorder(BorderFactory.createLoweredBevelBorder());
        JScrollPane scrollPane = new JScrollPane(commentArea);
        commentPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Submit button
        submitButton = new JButton("Submit Feedback");
        submitButton.addActionListener(this);
        
        add(ratingPanel, BorderLayout.NORTH);
        add(commentPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            int rating = 0;
            for (int i = 0; i < 5; i++) {
                if (starButtons[i].isSelected()) {
                    rating = i + 1;
                    break;
                }
            }
            
            String comment = commentArea.getText();
            
            if (rating > 0) {
                String message = "Thank you for your feedback!\n" +
                               "Rating: " + rating + " stars\n" +
                               "Comment: " + (comment.isEmpty() ? "No comment" : comment);
                JOptionPane.showMessageDialog(this, message);
                
                // Clear form
                ratingGroup.clearSelection();
                commentArea.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a rating!");
            }
        }
    }
    
    public static void main(String[] args) {
        new OnlineFeedbackForm();
    }
}