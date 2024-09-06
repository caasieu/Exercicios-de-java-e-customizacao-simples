package paginas;


import components.ButtonWithTextAndIcon;
import components.CustomTextField;
import components.Label;
import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MediaNotas  extends JPanel {
    public CardLayout cardLayout;
    public JPanel mainPanel;
    private final JLabel result;
    private final CustomTextField A1;
    private final CustomTextField A2;
    private final CustomTextField A3;
    
    public MediaNotas(String label, Dimension size, CardLayout cardLayout, JPanel mainPanel) {
        
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        
        setLayout(new BorderLayout()); // alinha verticalmente
        
        Label labelComponent = new Label(label);
        labelComponent.setPreferredSize(new Dimension(100, 60));
        labelComponent.setForeground(Color.WHITE);
        labelComponent.setHorizontalAlignment(JLabel.CENTER);
        add(labelComponent, BorderLayout.NORTH);
        
        // Create a panel with GridBagLayout
        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        fieldsPanel.setOpaque(false);
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets.set(0, 0, 5, 0); // Add vertical spacing
        
        // Create customized text fields
        A1 = new  CustomTextField("Nota da A1:");
        A1.setPreferredSize(new Dimension(250, 50));
        
        // Create customized text fields
        A2 = new  CustomTextField("Nota da A2:");
        A2.setPreferredSize(new Dimension(250, 50));
        
        // Create customized text fields
        A3 = new  CustomTextField("Nota da A3:");
        A3.setPreferredSize(new Dimension(250, 50));
        
        // Add nameField to the panel
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(A1, gbc);
        
        
        gbc.gridy = 1;
        fieldsPanel.add(A2, gbc);
        
        gbc.gridy = 2;
        fieldsPanel.add(A3, gbc);
        
        gbc.gridy = 3;
        fieldsPanel.add(createFlowButtons(), gbc);
        
        result = new JLabel("Resultado:");
        result.setForeground(Color.WHITE);
        result.setHorizontalAlignment(JLabel.RIGHT);
        gbc.gridy = 4;
        fieldsPanel.add(result, gbc);
        
        add(fieldsPanel, BorderLayout.CENTER);
        setOpaque(false);
        
    }
    
    private int calculo(int A1Value, int A2Value, int A3Value){
        
        int newA1 = A1Value * 3;
        int newA2 = A2Value * 3;
        int newA3 = A3Value * 4;
         
        return (newA1 + newA2 + newA3) / 10;
    }
    
    private JPanel createFlowButtons(){
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        
        ButtonWithTextAndIcon submit= new ButtonWithTextAndIcon("Submeter", "");
        submit.setBackgroundColor(new Color(105, 120, 205));
        submit.setForeground(Color.WHITE);
        submit.setCustomWidth(125);
        submit.addActionListener((ActionEvent e) -> {
            String a1Value = A1.getValue();
            String a2Value = A2.getValue();
            String a3Value = A3.getValue();
            
            if(a1Value.isBlank() || a2Value.isBlank() || a3Value.isBlank()) {
                result.setForeground(Color.RED);
                result.setText("valores nao introduzidos!");
            } else {
                
                result.setForeground(Color.WHITE);
                int res = this.calculo(
                        Integer.parseInt(a1Value), 
                        Integer.parseInt(a2Value),
                        Integer.parseInt(a3Value)
                );
                
                String formated = String.format( "media = %d", res);
                result.setText(formated);
            }
            
        });
        
        
        
        ButtonWithTextAndIcon back= new ButtonWithTextAndIcon("Voltar", "/images/back.png");
        back.setCustomWidth(125);
        back.addActionListener((ActionEvent e) -> {
            if (cardLayout != null && mainPanel != null) {
                cardLayout.show(mainPanel, "main");
            } else {
                System.out.println("CardLayout, mainPanel, or pageName is not set.");
            }
        });
        
        p.add(submit);
        p.add(Box.createRigidArea(new Dimension(5, 0))); // Adds gap between buttons
        p.add(back);
        p.setOpaque(false);
        return p;
    }
}
