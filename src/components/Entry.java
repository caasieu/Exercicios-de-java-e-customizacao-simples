package components;

import javax.swing.JTextField;

public class Entry extends JTextField {
    
    public String texto;
    
    
    public Entry() {
        
        setBounds(10,10,150,30);
        
    }
    
    
    public void changeText(String texto) { setText(texto); }
    
    public void clearText() { setText(""); } 
    
}
