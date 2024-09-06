package paginas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JLabel;

// meus componentes
import components.ButtonWithTextAndIcon;
import components.CustomScrollBarUI;
import components.Label;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridLayout;
import javax.swing.BorderFactory;

import components.ButtonType;

public class MainPage extends JPanel {
    
    public CardLayout cardLayout;
    public JPanel mainPanel;
    
    
    public MainPage(String label, Dimension size, CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        
        setLayout(new BorderLayout());
        
        Label labelComponent = new Label(label);
        labelComponent.setPreferredSize(new Dimension(100, 60));
        labelComponent.setForeground(Color.WHITE);
        labelComponent.setHorizontalAlignment(JLabel.CENTER);
        add(labelComponent, BorderLayout.NORTH);
        
        
        ButtonType[] buttons = {
            new ButtonType("Area do Circulo", "areaDoCirculo", "/images/circles.png"),
            new ButtonType("Area do Rectangulo", "areaDoRectangulo", "/images/rectangle.png"),
            new ButtonType("Area do Triangulo", "areaDoTriangulo", "/images/triangle.png"),
            new ButtonType("Idade em Anos", "idadeEmAnos", "/images/age.png"),
            new ButtonType("Imposto Gratificacao", "impostoGratificacao", "/images/down.png"),
            new ButtonType("Litros Gastos", "litrosGastos", "/images/gas.png"),
            new ButtonType("Media de Notas", "mediaNotas", "/images/score.png"),
            new ButtonType("Media Ponderada", "mediaPonderada", "/images/score-fill.png"),
            new ButtonType("Numeros Reais", "numerosReais", "/images/multi.png"),
            new ButtonType("Salario", "salario", "/images/money.png"),
            new ButtonType("Salario Comissao", "salarioComissao", "/images/money.png"),
            new ButtonType("Virada do Seculo", "viradaDoSeculo", "/images/century.png"),
        };
        
        
        // Painel que conterá os botões
        JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10)); // grelha com 3 colunas e espacamento de 10px
        panel.setBorder(null);
        panel.setOpaque(false);
        
        for(ButtonType button : buttons) {
            ButtonWithTextAndIcon btn = new ButtonWithTextAndIcon(button.title, button.icon);
            btn.goToPage(cardLayout, mainPanel, button.pageName);
            btn.setCustomWidth(150);
            btn.setCustomHeight(150);
            panel.add(btn);
        }
        
        setPreferredSize(new Dimension(size.width - 20, size.height));
        setMaximumSize(new Dimension(size.width - 20, Integer.MAX_VALUE));
        
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        
        scrollPane.setOpaque(false); // Torna o JScrollPane transparente
        scrollPane.getViewport().setOpaque(false); // Torna a área de visualização do JScrollPane transparente
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Sem rolagem horizontal
        scrollPane.setPreferredSize(new Dimension(size.width, size.height));
        
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
        
        setOpaque(false);
        add(scrollPane);
    }
}
