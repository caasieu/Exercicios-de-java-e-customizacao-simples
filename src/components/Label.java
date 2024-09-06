package components;

import javax.swing.JLabel;

public class Label extends JLabel {
    
    public Label(String texto) {
        
        setText(texto);
        setBounds(10,35, 150, 30);
    }
    
    public void changeText(String texto) {
        setText(texto);
    }
    
    public void clearText() { setText(""); }
}
