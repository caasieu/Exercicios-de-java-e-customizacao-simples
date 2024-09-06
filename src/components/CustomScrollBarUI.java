package components;

import javax.swing.*; 
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollBarUI extends BasicScrollBarUI {
    
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        // Paint the thumb (draggable part of the scrollbar)
        g.setColor(Color.DARK_GRAY); // Thumb color
        g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        // Do not paint the track
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createArrowButton(SwingConstants.NORTH);
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createArrowButton(SwingConstants.SOUTH);
    }

    private JButton createArrowButton(int direction) {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0)); // Hide the button size
        button.setOpaque(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setIcon(new ArrowIcon(direction)); // Set custom arrow icon
        return button;
    }

    // Custom icon for the arrow buttons
    private static class ArrowIcon implements Icon {
        private final int direction;

        ArrowIcon(int direction) {
            this.direction = direction;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(Color.LIGHT_GRAY);
            int size = 10;
            int[] xPoints, yPoints;
            switch (direction) {
                case SwingConstants.NORTH:
                    xPoints = new int[]{x + 5, x, x + 10};
                    yPoints = new int[]{y, y + 10, y + 10};
                    break;
                case SwingConstants.SOUTH:
                    xPoints = new int[]{x, x + 10, x + 5};
                    yPoints = new int[]{y, y, y + 10};
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction");
            }
            g.fillPolygon(xPoints, yPoints, 3);
        }

        @Override
        public int getIconWidth() {
            return 10;
        }

        @Override
        public int getIconHeight() {
            return 10;
        }
    }
}
