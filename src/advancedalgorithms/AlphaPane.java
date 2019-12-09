/**
 *
 *            L'Université Jean Monnet
 *
 *         Dimitrios Soupilas * Riad Lazli
 *         Erwan Le Cornec * Aleksei Pashinin
 *
 *           Projet Développement Web II
 *
 */
package advancedalgorithms;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author alekspashinin
 */

public class AlphaPane extends JPanel {

    private float alpha;

    public AlphaPane() {
        setOpaque(false);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
        super.paint(g2d);
        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public void setAlpha(float value) {
        if (alpha != value) {
            this.alpha = Math.min(1f, Math.max(0, value));
            repaint();
        }
    }

    public float getAlpha() {
        return alpha;
    }
}
