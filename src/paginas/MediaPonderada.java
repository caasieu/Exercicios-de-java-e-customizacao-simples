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

public class MediaPonderada  extends JPanel {
    public CardLayout cardLayout;
    public JPanel mainPanel;
    private final JLabel result;
    private final CustomTextField A1;
    private final CustomTextField A2;
    
    public MediaPonderada(String label, Dimension size, CardLayout cardLayout, JPanel mainPanel) {
        
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
        
        
        // Add nameField to the panel
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(A1, gbc);
        
        
        gbc.gridy = 1;
        fieldsPanel.add(A2, gbc);
        
        gbc.gridy = 2;
        fieldsPanel.add(createFlowButtons(), gbc);
        
        result = new JLabel("Resultado:");
        result.setForeground(Color.WHITE);
        result.setHorizontalAlignment(JLabel.RIGHT);
        gbc.gridy = 3;
        fieldsPanel.add(result, gbc);
        
        add(fieldsPanel, BorderLayout.CENTER);
        setOpaque(false);
        
    }
    
    private double calculo(double n1, double n2){
        
        int p1 = 2;
        int p2 = 3;
        
        double med = (n1 * p1 + n2 * p2) / (p1 + p2);
        return med;
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
            
            if(a1Value.isBlank() || a2Value.isBlank()) {
                result.setForeground(Color.RED);
                result.setText("valores nao introduzidos!");
            } else {
                
                result.setForeground(Color.WHITE);
                double res = this.calculo(
                        Double.parseDouble(a1Value), 
                        Double.parseDouble(a2Value)
                );
                
                String formated = String.format("média ponderada = %.2f", res);
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
