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

public class SalarioComissao  extends JPanel {
    public CardLayout cardLayout;
    public JPanel mainPanel;
    private final JLabel result;
    private final CustomTextField salario;
    private final CustomTextField vendas;
    
    public SalarioComissao(String label, Dimension size, CardLayout cardLayout, JPanel mainPanel) {
        
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
        salario = new  CustomTextField("Qual e o salário fixo?");
        salario.setPreferredSize(new Dimension(250, 50)); // Adjust as needed
        
        // Create customized text fields
        vendas = new  CustomTextField("Qual é o total de vendas?");
        vendas.setPreferredSize(new Dimension(250, 50)); // Adjust as needed
        
        
        // Add nameField to the panel
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(salario, gbc);
        
        gbc.gridy = 1;
        fieldsPanel.add(vendas, gbc);
        
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
    
    private double calculo(double salario, double vendas){
        
        double porcentagem_comissao = 0.04; // 4%
        double comissao = vendas * porcentagem_comissao;
        double salario_final = salario + comissao;
        
        System.out.printf("Comissao: %.2f\n", comissao);
        System.out.printf("Salário final: %.2f\n", salario_final);
        
        return salario_final;
        
    }
    
    private JPanel createFlowButtons(){
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        
        ButtonWithTextAndIcon submit= new ButtonWithTextAndIcon("Submeter", "");
        submit.setBackgroundColor(new Color(105, 120, 205));
        submit.setForeground(Color.WHITE);
        submit.setCustomWidth(125);
        submit.addActionListener((ActionEvent e) -> {
            String salarioValue = salario.getValue();
            String vendasValue = vendas.getValue();
            
            
            if(salarioValue.isBlank() || vendasValue.isBlank()) {
                result.setForeground(Color.RED);
                result.setText("Valores nao introduzidos!");
            } else {
                
                result.setForeground(Color.WHITE);
                double res = this.calculo(Double.parseDouble(salarioValue), Double.parseDouble(vendasValue));
                String formattedValue = String.format("Salário final: R$ã %.2f", res);
            
                result.setText(formattedValue);
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
