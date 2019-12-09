package advancedalgorithms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GraphApp extends JPanel {
    
    static public JPanel Graph2;

    public GraphApp(){
        Graph2 = new SineWave();
        Graph2.setBounds(0, 0, 550, 230);
        Graph2.setBackground(new java.awt.Color(255, 0, 0, 0));
        Graph2.setOpaque(true);
        add(Graph2);
        setBackground(new java.awt.Color(255, 0, 0, 0));
        repaint();
        setVisible(true);
        
    }
    
}

class SineWave extends JPanel{

    //use constants for better readability
    private static final double W = 550, H = 230, AMPLITUDE = H/3;
    private static final int MARGIN =30,DOT_SIZE = 5, SPEED = 5;

    //starting point
    private double x = MARGIN;
    private double y = H-MARGIN; //H/2;// + advancedalgorithms.MainJFrame.timeElapsed;;
    private final int dX = 1; //x increment
    float F = 23;

    //you need to use doubles to avoid rounding error and have use non integer coordinates
    private final List<Point2D.Double> points;
    private final Timer timer;

    public SineWave() {
        setPreferredSize(new Dimension((int)W, (int)H));
        setBackground(new java.awt.Color(255, 0, 0, 0));
        setOpaque(false);
        repaint();
        advancedalgorithms.MainJFrame.timeElapsed=5;
        points = new ArrayList<>();
        timer = new Timer(SPEED, e->addPoints()); //timer to add sine points
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(new java.awt.Color(255, 0, 0, 1));
        Graphics2D g2 = (Graphics2D)g;
       
        g2.setBackground(new java.awt.Color(255, 0, 0, 1));
        GradientPaint purpleToBlue = new GradientPaint(50, 50, new Color(124,40,159),300, 100, new Color(8,181,237));
        g2.setPaint(purpleToBlue);
        for(Point2D.Double p : points){
            Shape point = new Ellipse2D.Double(p.getX(), p.getY(),DOT_SIZE , DOT_SIZE);
            g2.fill(point);
            g2.draw(point);
        }
    }

    private void addPoints() {
        
        setBackground(new java.awt.Color(255, 0, 0, 1));
        double angel = - Math.PI + 2* Math.PI * ((x-MARGIN)/(W- 2*MARGIN));//angle in radians
        //double newY = y +  AMPLITUDE * Math.sin(angel);
        points.add(new Point2D.Double(x, y));
        x += dX;
        F = (int) (F + 0.00000046);
        y -= advancedalgorithms.MainJFrame.timeElapsed/(F);
        if(x >= W-MARGIN) {
            timer.stop();
        }
        repaint();
    }
    
}