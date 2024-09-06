package components;

import javax.swing.JButton;
import javax.swing.Icon;


import java.awt.Insets;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.net.URL;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ButtonWithIcon extends JButton {
    private final Color backgroundColor = new Color(210, 210, 210);
    private final Color borderColor = Color.GRAY;
    private final int borderRadius = 50;
    private final int padding = 5;
    
    public ButtonWithIcon(String iconPath) {
        
        try{
            URL fullPath = getClass().getResource(iconPath);
            ImageIcon i = new ImageIcon(fullPath);
            Image resizedImage = i.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        
            if(fullPath != null) 
                setIcon(new ImageIcon(resizedImage));
        } catch(Exception ex) { 
            System.out.println(ex);
        }
        
        setHorizontalTextPosition(SwingConstants.RIGHT); // texto à direito do icone
        setHorizontalAlignment(SwingConstants.CENTER); // alinhar conteudo à esquerda
        setMargin(new Insets(padding, padding, padding, padding)); // Top, Left, Bottom, Right padding

        
        // Remove a borda padrao do botao
        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
        setFocusPainted(false);
        
    }
    
    @Override
    public Dimension getPreferredSize() {
        
        Dimension iconSize = getIcon() != null ? new Dimension(getIcon().getIconWidth(), getIcon().getIconHeight()) : new Dimension(0,0);
        
        // calcule o tamnho preferido com padding
        int width = Math.max(iconSize.width, iconSize.width) + padding * 2;
        int height = Math.max(iconSize.height, iconSize.height) + padding * 2;
        
        return new Dimension(width, height);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Calculate the padded dimensions
        int width = getWidth();
        int height = getHeight();
        
        g2d.setColor(backgroundColor);
        g2d.fillRoundRect(0, 0, width, height, borderRadius, borderRadius);
        
        // pinta o texto e o icone (n)
        super.paintComponent(g);
        
        // pinte a borda
        //g2d.setColor(borderColor);
        //g2d.drawRoundRect(0, 0, width - 1, height - 1, borderRadius, borderRadius);
        
        g2d.dispose();
    }
}
