package components;

import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.net.URL;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public final class ButtonWithTextAndIcon extends JButton {
    private Color backgroundColor = Color.WHITE;// new Color(245, 245, 245);
    private Color textColor = Color.BLACK;// new Color(245, 245, 245);
    private final Color borderColor = Color.GRAY;
    private final int borderRadius = 5;
    private final int padding = 5;
    private final int minWidth = 100;
    
    private int customWidth = -1;
    private int customHeight = -1;
    private int iconSize = 15;
    
    
    public ButtonWithTextAndIcon(String text, String iconPath){
        super(text);
        // Set the font to plain (not bold)
        setFont(new Font("Arial", Font.PLAIN, 12)); // Choose a font and size

        
        try{
            URL fullPath = getClass().getResource(iconPath);
            ImageIcon i = new ImageIcon(fullPath);
            Image resizedImage = i.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH);
        
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
        setForeground(this.textColor);
        
        // setPreferredSize(null);
        // setMaximumSize(getPreferredSize());
        // setIconTextGap(5);
        // setBackground(new Color(230, 230, 230)); // a cor de fundo
        // setForeground(Color.BLACK); // A cor do texto
        // setOpaque(false);
        
    }
    
    public void goToPage(CardLayout cardLayout, JPanel mainPanel, String pageName){
        
        this.addActionListener((ActionEvent e) -> {
            if (cardLayout != null && mainPanel != null && pageName != null) {
                cardLayout.show(mainPanel, pageName);
            } else {
                System.out.println("CardLayout, mainPanel, or pageName is not set.");
            }
        });
    }
    
    @Override
    public Dimension getPreferredSize() {
        
        Dimension iconSize = getIcon() != null ? new Dimension(getIcon().getIconWidth(), getIcon().getIconHeight()) : new Dimension(0,0);
        FontMetrics fm = getFontMetrics(getFont());
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getHeight();
        
        // calcule o tamnho preferido com padding
        int width = Math.max(iconSize.width + textWidth, minWidth) + padding * 2;
        int height = Math.max(iconSize.height, textHeight) + padding * 2;
        
        // Use customWidth e customHheight se definidas
        if (customWidth != -1) {
            width = customWidth;
        }
        if (customHeight != -1) {
            height = customHeight;
        }
        
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
        g2d.fillRoundRect(0, 0, width - 1, height - 1, borderRadius, borderRadius);
        
        // pinta o texto e o icone (n)
        super.paintComponent(g);
        
        // pinte a borda
        //g2d.setColor(borderColor);
        //g2d.drawRoundRect(0, 0, width - 1, height - 1, borderRadius, borderRadius);
        
        g2d.dispose();
    }
    
    
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        
        revalidate();
        repaint();
    }
    
    public void setTextColor(Color color) {
        this.textColor = color;
        
        revalidate();
        repaint();
    }
    
    // Método para definir o tamanho do ícone
    public void setIconSize(int size) {
        this.iconSize = size;
        if (getIcon() != null) {
            ImageIcon icon = (ImageIcon) getIcon();
            Image resizedImage = icon.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(resizedImage));
        }
        revalidate();
        repaint();
    }
    
    // funcao para definir uma largura customizada
    public void setCustomWidth(int width) {
        this.customWidth = width;
        setPreferredSize(new Dimension(customWidth, getPreferredSize().height));
        revalidate();
        repaint();
    }
    
    // funcao para definir uma altura customizada
    public void setCustomHeight(int height) {
        this.customHeight = height;
        setPreferredSize(new Dimension(getPreferredSize().width, customHeight));
        revalidate();
        repaint();
    }
    
}
