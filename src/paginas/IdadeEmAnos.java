
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

public class IdadeEmAnos  extends JPanel {
    public CardLayout cardLayout;
    public JPanel mainPanel;
    private final JLabel result;
    private final CustomTextField nascimento;
    private final CustomTextField atual;
    
    public IdadeEmAnos(String label, Dimension size, CardLayout cardLayout, JPanel mainPanel) {
        
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
        nascimento = new  CustomTextField("Qual o ano de nascimento?");
        nascimento.setPreferredSize(new Dimension(250, 50));
        atual = new  CustomTextField("Qual o ano atual?");
        atual.setPreferredSize(new Dimension(250, 50));
        
        // Add nameField to the panel
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(nascimento, gbc);
        
        
        gbc.gridy = 1;
        fieldsPanel.add(atual, gbc);
        
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
    
    private int calculo(int nascimento, int atual){
        return atual - nascimento;
    }
    
    private JPanel createFlowButtons(){
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        
        ButtonWithTextAndIcon submit= new ButtonWithTextAndIcon("Submeter", "");
        submit.setBackgroundColor(new Color(105, 120, 205));
        submit.setForeground(Color.WHITE);
        submit.setCustomWidth(125);
        submit.addActionListener((ActionEvent e) -> {
            String nascimentoValue = nascimento.getValue();
            String atualValue = atual.getValue();
            
            if(nascimentoValue.isBlank() || atualValue.isBlank()) {
                result.setForeground(Color.RED);
                result.setText("Nasciemento ou Atual nao introduzidos!");
            } else {
                
                result.setForeground(Color.WHITE);
                int idade = this.calculo(Integer.parseInt(nascimentoValue), Integer.parseInt(atualValue));
                result.setText("A pessoa tem " + idade + " anos");
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
