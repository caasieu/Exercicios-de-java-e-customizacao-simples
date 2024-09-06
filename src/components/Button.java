package components;

import javax.swing.JButton;
import javax.swing.Icon;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

// Não precisa importar Entry e Label porque estão no mesmo pacote
public class Button extends JButton { // implements ActionListener {
    
    public Button(String title) {
        super(title != null ? title : "");
        
        setText(title);
        setBounds(10,80,150,30);
        
        // addActionListener(this);
    }
    
    public Button(Icon icon) {
        super(icon);
    }
    
    // function overload para padronizar a alterar de texto dos 2 tipos objetos
    public void changeObjectText(Label obj, String newText) {
        obj.changeText(newText);
    }
    
    public void changeObjectText(Entry obj, String newText) {
        obj.changeText(newText);
    }
    
    //@Override
    //public void actionPerformed(ActionEvent e) {
    //    System.out.println("Saturn!");
    //}
}
