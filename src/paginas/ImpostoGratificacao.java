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

public class ImpostoGratificacao  extends JPanel {
    public CardLayout cardLayout;
    public JPanel mainPanel;
    private final JLabel result;
    private final CustomTextField salario;
    
    public ImpostoGratificacao(String label, Dimension size, CardLayout cardLayout, JPanel mainPanel) {
        
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
        salario = new  CustomTextField("Qual e o salario base?");
        //nameField.setPreferredSize(new Dimension(250, 50)); // Adjust as needed
        
        // Add nameField to the panel
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(salario, gbc);
        
        gbc.gridy = 1;
        fieldsPanel.add(createFlowButtons(), gbc);
        
        result = new JLabel("Resultado:");
        result.setForeground(Color.WHITE);
        result.setHorizontalAlignment(JLabel.RIGHT);
        gbc.gridy = 2;
        fieldsPanel.add(result, gbc);
        
        add(fieldsPanel, BorderLayout.CENTER);
        setOpaque(false);
        
    }
    
    private double calculo(double salario){
        
        double gratificacao =  (salario / 100) * 5;
        double imposto =  (salario + gratificacao) * 0.07;
        
        System.out.printf("O novo salario e: %.3f\n", (salario + gratificacao - imposto));
        System.out.printf("Gratificacao de 5 perc: %.3f\n", (gratificacao));
        System.out.printf("Imposto de 7 perc: %.3f\n", (imposto));
        
        return (salario + gratificacao - imposto);
    }
    
    private JPanel createFlowButtons(){
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        
        ButtonWithTextAndIcon submit= new ButtonWithTextAndIcon("Submeter", "");
        submit.setBackgroundColor(new Color(105, 120, 205));
        submit.setForeground(Color.WHITE);
        submit.setCustomWidth(125);
        submit.addActionListener((ActionEvent e) -> {
            String value = salario.getValue();
            if(value.isBlank()) {
                result.setForeground(Color.RED);
                result.setText("Nenhum Valor introduzido!");
            } else {
                
                result.setForeground(Color.WHITE);
                double area = this.calculo(Double.parseDouble(salario.getValue()));
                String formattedValue = String.format("%.2f", area);
            
                result.setText("O novo salario: R$ " + formattedValue);
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
