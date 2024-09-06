package components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class CustomTextField extends JPanel {
    public JTextField field;
    
    public CustomTextField(String text) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        Label label = new Label(text);
        field = new JTextField();
        Border bottomBorder = new MatteBorder(0, 0, 1, 0, Color.WHITE); // Bottom border only
        
        label.setForeground(Color.WHITE);
        field.setBorder(bottomBorder);
        field.setForeground(Color.WHITE); // Sets text color to white
        field.setOpaque(false); // Makes the background transparent
        field.setPreferredSize(new Dimension(150, 30));
        
        add(label);
        //add(Box.createRigidArea(new Dimension(10, 0))); // Add vertical space between fields
        add(field);
        
        //add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical space between fields
        // Center the container panel
        //setAlignmentX(Component.CENTER_ALIGNMENT);
        //setAlignmentY(Component.CENTER_ALIGNMENT);
        //setPreferredSize(new Dimension(150, 50)); // Adjust height based on content
        setOpaque(false); // Makes the background transparent
        
    }
    
    public String getValue() {
        return field.getText();
    }
}

