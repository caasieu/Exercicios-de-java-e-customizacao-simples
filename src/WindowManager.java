
// layouts
import java.awt.CardLayout;

// componentes
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// meus componentes
import java.awt.Color;
import java.awt.Dimension;

import paginas.MainPage;
import paginas.AreaDoCirculo;
import paginas.AreaDoRectangulo;
import paginas.AreaDoTriangulo;
import paginas.IdadeEmAnos;
import paginas.ImpostoGratificacao;
import paginas.LitrosGastos;
import paginas.MediaNotas;
import paginas.MediaPonderada;
import paginas.NumerosReais;
import paginas.Salario;
import paginas.SalarioComissao;
import paginas.ViradaDoSeculo;

public class WindowManager extends JFrame {
    
    private final int width = 640;
    private final int height = 480;
    private final CardLayout cardLayout;
    private final JPanel mainPanel;
    
    public WindowManager() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(new Color(40, 40, 40));
        
        Dimension size = new Dimension(width, height);
        MainPage main = new MainPage("Escolha o exercicio", size, cardLayout, mainPanel);
        AreaDoCirculo areaCirculo = new AreaDoCirculo("Area do Circulo", size, cardLayout, mainPanel);
        AreaDoRectangulo areaDoRectangulo = new AreaDoRectangulo("Area do Rectangulo", size, cardLayout, mainPanel);
        AreaDoTriangulo areaDoTriangulo = new AreaDoTriangulo("Area do Triangulo", size, cardLayout, mainPanel);
        IdadeEmAnos idadeEmAnos = new IdadeEmAnos("Idade em Anos", size, cardLayout, mainPanel);
        ImpostoGratificacao impostoGratificacao = new ImpostoGratificacao("Imposto e Gratificaçao", size, cardLayout, mainPanel);
        LitrosGastos litrosGastos = new LitrosGastos("Idade em Anos", size, cardLayout, mainPanel);
        MediaNotas mediaNotas = new MediaNotas("Media Notas", size, cardLayout, mainPanel);
        MediaPonderada mediaPonderada = new MediaPonderada("Media Ponderada", size, cardLayout, mainPanel);
        NumerosReais numerosReais = new NumerosReais("Numero Reais", size, cardLayout, mainPanel);
        Salario salario = new Salario("Salario", size, cardLayout, mainPanel);
        SalarioComissao salarioComissao = new SalarioComissao("Salario Comissao", size, cardLayout, mainPanel);
        ViradaDoSeculo viradaDoSeculo = new ViradaDoSeculo("Virada do Seculo", size, cardLayout, mainPanel);
        
        
        mainPanel.add(main, "main");
        mainPanel.add(areaCirculo, "areaDoCirculo");
        mainPanel.add(areaDoRectangulo, "areaDoRectangulo");
        mainPanel.add(areaDoTriangulo, "areaDoTriangulo");
        mainPanel.add(idadeEmAnos, "idadeEmAnos");
        mainPanel.add(impostoGratificacao, "impostoGratificacao");
        mainPanel.add(litrosGastos, "litrosGastos");
        mainPanel.add(mediaNotas, "mediaNotas");
        mainPanel.add(mediaPonderada, "mediaPonderada");
        mainPanel.add(numerosReais, "numerosReais");
        mainPanel.add(salario, "salario");
        mainPanel.add(salarioComissao, "salarioComissao");
        mainPanel.add(viradaDoSeculo, "viradaDoSeculo");
        
        // adiciona o painel principal a janela
        getContentPane().add(mainPanel);
        setTitle("Exercicios de PCC1");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new WindowManager().setVisible(true);
        });
    }
}
