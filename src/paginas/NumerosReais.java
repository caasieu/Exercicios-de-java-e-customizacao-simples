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

public class NumerosReais  extends JPanel {
    public CardLayout cardLayout;
    public JPanel mainPanel;
    private final JLabel result;
    private final CustomTextField N1;
    private final CustomTextField N2;
    private final CustomTextField N3;
    
    public NumerosReais(String label, Dimension size, CardLayout cardLayout, JPanel mainPanel) {
        
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
        N1 = new  CustomTextField("Valor N1:");
        N1.setPreferredSize(new Dimension(250, 50));
        
        // Create customized text fields
        N2 = new  CustomTextField("Valor N2:");
        N2.setPreferredSize(new Dimension(250, 50));
        
        // Create customized text fields
        N3 = new  CustomTextField("Valor N3:");
        N3.setPreferredSize(new Dimension(250, 50));
        
        // Add nameField to the panel
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(N1, gbc);
        
        
        gbc.gridy = 1;
        fieldsPanel.add(N2, gbc);
        
        gbc.gridy = 2;
        fieldsPanel.add(N3, gbc);
        
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
    
    private double calculo(double n1, double n2, double n3){
        return (n1 * n2 * n3);
    }
    
    private JPanel createFlowButtons(){
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        
        ButtonWithTextAndIcon submit= new ButtonWithTextAndIcon("Submeter", "");
        submit.setBackgroundColor(new Color(105, 120, 205));
        submit.setForeground(Color.WHITE);
        submit.setCustomWidth(125);
        submit.addActionListener((ActionEvent e) -> {
            String a1Value = N1.getValue();
            String a2Value = N2.getValue();
            String a3Value = N3.getValue();
            
            if(a1Value.isBlank() || a2Value.isBlank() || a3Value.isBlank()) {
                result.setForeground(Color.RED);
                result.setText("valores nao introduzidos!");
            } else {
                
                result.setForeground(Color.WHITE);
                double res = this.calculo(
                        Double.parseDouble(a1Value), 
                        Double.parseDouble(a2Value),
                        Double.parseDouble(a3Value)
                );
                
                String formated = String.format(
                        "%.2f x %.2f x %.2f = %.2f ", 
                        Double.parseDouble(a1Value), 
                        Double.parseDouble(a2Value),
                        Double.parseDouble(a3Value), 
                        res);
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

