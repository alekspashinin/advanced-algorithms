/**
 *
 *                    Jean Monnet University
 * 
 *         Rediet Gebretsion Tadesse * Dhayananth Dharmalingam
 *         Poulomy Nandy * Aninda Maulik * Aleksei Pashinin
 *
 *                   Advanced Algorithms Project
 *
 */
package advancedalgorithms;

import static advancedalgorithms.Dynamic.LineSize;
import static advancedalgorithms.Dynamic.sizeL;
import static advancedalgorithms.Dynamic.wordLenth;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alekspashinin
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    Timer timer;
    Timer timer2;
    long start;
    long finish;
    private int counter = 2;
    private int counter1 = 6;
    private int delay = 1000;
    private int buttonCounter = 0;
    
    public MainJFrame() {
        initComponents();
        alphaPaneMain.setAlpha(0.0f);
        setBounds(100,100,1024,768);
        jPanel1.setBounds(0,0,1024,768);
        alphaPaneIntro.setBounds(0,0,1024,768);
        jPanel1.removeAll();
        alphaPaneIntro.setAlpha(0.0f);
        jPanel1.add(alphaPanePreIntro); 
        jPanel1.revalidate(); 
        jPanel1.repaint();
        ActionListener action1 = new ActionListener()
        {   
            @Override
            public void actionPerformed(java.awt.event.ActionEvent event){
                if(counter == 0)
                {
                    
                    timer.stop();
                    if (controller != null) {
                        controller.stop();

                    }
                    controller = new AnimationController(1000);
                    boolean fadeIn = alphaPanePreIntro.getAlpha() < alphaPaneIntro.getAlpha();
                    if (alphaPanePreIntro.getAlpha() > 0.0f) {
                        //controller.add(controller.new AlphaRange(alphaPanePreIntro, fadeIn));
                        controller.add(controller.new AlphaRange(alphaPaneIntro, !fadeIn));
                        controller.start();
                    }
                    jPanel1.removeAll();
                    jPanel1.add(alphaPaneIntro);
                    jPanel1.revalidate();
                    jPanel1.repaint();
                    }
                else
                {                   
                    counter--;
                   
                }
            }
        };
        timer = new Timer(delay, action1);
        timer.setInitialDelay(0);
        timer.start();
        ActionListener action2 = new ActionListener()
        {   
            @Override
            public void actionPerformed(java.awt.event.ActionEvent event){
                if(counter1 == 0)
                {
                    
                    timer2.stop();
                    
                    
                    
                    if (controller != null) {
                        controller.stop();

                    }
                    controller = new AnimationController(2000);
                    boolean fadeIn = alphaPaneIntro.getAlpha() < alphaPaneMain.getAlpha();
                    //System.out.println(alphaPaneIntro.getAlpha());
                    //System.out.println(alphaPaneMain.getAlpha());
                    if (alphaPaneIntro.getAlpha() > 0.0f) {
                        controller.add(controller.new AlphaRange(alphaPaneIntro, fadeIn));
                        controller.add(controller.new AlphaRange(alphaPaneMain, !fadeIn));
                        controller.start();
                    }
                    jPanel1.removeAll();
                    jPanel1.add(alphaPaneMain);
                    jPanel1.revalidate();
                    jPanel1.repaint();

                    
                }
                else
                {
                    counter1--;
                   
                }
            }
        };
        timer2 = new Timer(delay, action2);
        timer2.setInitialDelay(0);
        timer2.start();
        TextEditor();
        Graphics();
        new Thread(){
        public void run(){
            while (0 == 0){
    long total = Runtime.getRuntime().totalMemory();
    long used  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    int memres = (int) (used*100/total);
    if (memres>50 && memres<80){
        jLabel2.setForeground(new java.awt.Color(255, 216, 0));
    }
    if (memres>80){
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));    
    }
    else{
        jLabel2.setForeground(new java.awt.Color(1, 203, 68));
    }
    float a = (float) bean.getSystemCpuLoad()*100;
    int cpures = (int) Math.ceil(a);
    if (cpures>50 && cpures<80){
        jLabel10.setForeground(new java.awt.Color(255, 216, 0));
    }
    if (cpures>80){
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));    
    }
    else{
        jLabel10.setForeground(new java.awt.Color(1, 203, 68));
    }
    jLabel2.setText(memres+"%");
    jLabel10.setText(cpures+"%");
    repaint();
    try
{
    Thread.sleep(1000);
}
catch(InterruptedException ex)
{
    Thread.currentThread().interrupt();
}
                }
            }
        }.start();
    }
    
    public void TextEditor(){
        TextEditor x;
        x = new TextEditor();
        jLabel3.setBackground(new java.awt.Color(0, 172, 237,0));
        jLabel4.add(advancedalgorithms.TextEditor.toolbar);
        jLabel3.add(advancedalgorithms.TextEditor.editor);
        pack();
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
    }
    
    public void Graphics(){
        GraphApp app;
        app = new GraphApp();
        jLabel12.add(advancedalgorithms.GraphApp.Graph2);
        jLabel12.setBackground(new java.awt.Color(0, 172, 237,0));
        jLabel12.setOpaque(true);
        jLabel12.repaint();
        app.setVisible(true);
        pack();
        jLabel12.setVisible(true);
    }
    
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        alphaPanePreIntro = new advancedalgorithms.AlphaPane();
        jLabel9 = new javax.swing.JLabel();
        alphaPaneIntro = new advancedalgorithms.AlphaPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        alphaPaneMain = new advancedalgorithms.AlphaPane();
        alphaPaneWords = new advancedalgorithms.AlphaPane();
        jLabel20 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        jLabel21 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        alphaPaneResult = new advancedalgorithms.AlphaPane();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(26, 39, 62));
        setBounds(new java.awt.Rectangle(100, 100, 1024, 768));
        setSize(new java.awt.Dimension(1024, 768));

        jPanel1.setBackground(new java.awt.Color(26, 39, 62));
        jPanel1.setBounds(new java.awt.Rectangle(0, 0, 1024, 768));
        jPanel1.setLayout(null);

        alphaPanePreIntro.setAlpha(1.0F);
        alphaPanePreIntro.setMinimumSize(new java.awt.Dimension(1024, 768));
        alphaPanePreIntro.setLayout(null);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/back.jpg"))); // NOI18N
        alphaPanePreIntro.add(jLabel9);
        jLabel9.setBounds(0, 0, 1024, 768);

        jPanel1.add(alphaPanePreIntro);
        alphaPanePreIntro.setBounds(0, 0, 1024, 768);

        alphaPaneIntro.setMinimumSize(new java.awt.Dimension(1024, 768));
        alphaPaneIntro.setPreferredSize(new java.awt.Dimension(1024, 768));
        alphaPaneIntro.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/back2.jpg"))); // NOI18N
        alphaPaneIntro.add(jLabel5);
        jLabel5.setBounds(0, 0, 1024, 768);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/back.jpg"))); // NOI18N
        alphaPaneIntro.add(jLabel8);
        jLabel8.setBounds(0, 0, 1024, 768);

        jPanel1.add(alphaPaneIntro);
        alphaPaneIntro.setBounds(0, 0, 1024, 768);

        alphaPaneMain.setAlpha(1.0F);
        alphaPaneMain.setMinimumSize(new java.awt.Dimension(1024, 768));
        alphaPaneMain.setPreferredSize(new java.awt.Dimension(1024, 768));
        alphaPaneMain.setLayout(null);

        alphaPaneWords.setMinimumSize(new java.awt.Dimension(1024, 768));
        alphaPaneWords.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Myriad Pro", 0, 20));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText(String.valueOf(jSlider2.getValue()));
        alphaPaneWords.add(jLabel20);
        jLabel20.setBounds(30, 20, 40, 20);

        jSlider2.setMaximum(1000);
        jSlider2.setToolTipText("");
        jSlider2.setValue(50);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });
        alphaPaneWords.add(jSlider2);
        jSlider2.setBounds(10, 60, 150, 29);

        jLabel21.setFont(new java.awt.Font("Myriad Pro", 0, 20));
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Words");
        alphaPaneWords.add(jLabel21);
        jLabel21.setBounds(90, 20, 70, 20);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/oksleep.jpg"))); // NOI18N
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton16MouseExited(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        alphaPaneWords.add(jButton16);
        jButton16.setBounds(-1, 100, 172, 54);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/smallback.jpg"))); // NOI18N
        alphaPaneWords.add(jLabel19);
        jLabel19.setBounds(0, 0, 172, 151);

        alphaPaneMain.add(alphaPaneWords);
        alphaPaneWords.setBounds(730, 120, 172, 151);

        jLabel4.setToolTipText("");
        alphaPaneMain.add(jLabel4);
        jLabel4.setBounds(0, 50, 430, 90);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/graphssleep.jpg"))); // NOI18N
        jButton4.setMaximumSize(new java.awt.Dimension(138, 90));
        jButton4.setMinimumSize(new java.awt.Dimension(138, 90));
        jButton4.setPreferredSize(new java.awt.Dimension(138, 90));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton4);
        jButton4.setBounds(610, 49, 138, 90);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/wordssleep.jpg"))); // NOI18N
        jButton5.setMaximumSize(new java.awt.Dimension(138, 90));
        jButton5.setMinimumSize(new java.awt.Dimension(138, 90));
        jButton5.setPreferredSize(new java.awt.Dimension(138, 90));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton5);
        jButton5.setBounds(747, 49, 138, 90);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/exitsleep.jpg"))); // NOI18N
        jButton6.setMaximumSize(new java.awt.Dimension(138, 90));
        jButton6.setMinimumSize(new java.awt.Dimension(138, 90));
        jButton6.setPreferredSize(new java.awt.Dimension(138, 90));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton6);
        jButton6.setBounds(885, 49, 138, 90);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg"))); // NOI18N
        jButton7.setToolTipText("");
        jButton7.setSize(new java.awt.Dimension(42, 42));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton7);
        jButton7.setBounds(720, 280, 42, 42);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg"))); // NOI18N
        jButton8.setToolTipText("");
        jButton8.setSize(new java.awt.Dimension(42, 42));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton8);
        jButton8.setBounds(720, 330, 42, 42);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg"))); // NOI18N
        jButton9.setToolTipText("");
        jButton9.setSize(new java.awt.Dimension(42, 42));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton9);
        jButton9.setBounds(720, 380, 42, 42);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg"))); // NOI18N
        jButton10.setToolTipText("");
        jButton10.setSize(new java.awt.Dimension(42, 42));
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton10);
        jButton10.setBounds(720, 430, 42, 42);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg"))); // NOI18N
        jButton11.setToolTipText("");
        jButton11.setSize(new java.awt.Dimension(42, 42));
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton11MouseExited(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton11);
        jButton11.setBounds(720, 480, 42, 42);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton1);
        jButton1.setBounds(770, 280, 130, 35);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton2);
        jButton2.setBounds(770, 330, 130, 35);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton3);
        jButton3.setBounds(770, 380, 130, 35);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg"))); // NOI18N
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton12);
        jButton12.setBounds(770, 430, 130, 35);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/spacesleep.jpg"))); // NOI18N
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton13MouseExited(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        alphaPaneMain.add(jButton13);
        jButton13.setBounds(770, 480, 130, 35);

        jLabel6.setFont(new java.awt.Font("Myriad Pro", 0, 20));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" CPU:");
        alphaPaneMain.add(jLabel6);
        jLabel6.setBounds(120, 640, 60, 20);

        jLabel7.setFont(new java.awt.Font("Myriad Pro", 0, 20));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("RAM:");
        alphaPaneMain.add(jLabel7);
        jLabel7.setBounds(120, 680, 60, 20);

        jLabel10.setFont(new java.awt.Font("Myriad Pro", 0, 20));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        alphaPaneMain.add(jLabel10);
        jLabel10.setBounds(200, 640, 60, 20);

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 0, 20));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        alphaPaneMain.add(jLabel2);
        jLabel2.setBounds(200, 680, 60, 20);

        jLabel3.setBackground(new java.awt.Color(255, 0, 51));
        alphaPaneMain.add(jLabel3);
        jLabel3.setBounds(60, 270, 580, 250);

        jSlider1.setMaximum(24);
        jSlider1.setToolTipText("");
        jSlider1.setValue(12);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        alphaPaneMain.add(jSlider1);
        jSlider1.setBounds(790, 695, 180, 29);

        jLabel13.setFont(new java.awt.Font("Myriad Pro", 0, 20));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText(" Time:");
        alphaPaneMain.add(jLabel13);
        jLabel13.setBounds(420, 640, 100, 20);

        jLabel14.setFont(new java.awt.Font("Myriad Pro", 0, 20));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Compl:");
        alphaPaneMain.add(jLabel14);
        jLabel14.setBounds(420, 680, 70, 20);

        jLabel15.setFont(new java.awt.Font("Myriad Pro", 0, 20));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("---");
        alphaPaneMain.add(jLabel15);
        jLabel15.setBounds(530, 640, 110, 20);

        jLabel16.setFont(new java.awt.Font("Myriad Pro", 0, 20));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText(String.valueOf(jSlider1.getValue()));
        alphaPaneMain.add(jLabel16);
        jLabel16.setBounds(730, 700, 30, 20);

        jLabel17.setFont(new java.awt.Font("Myriad Pro", 0, 20));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("---");
        alphaPaneMain.add(jLabel17);
        jLabel17.setBounds(530, 680, 60, 20);

        jLabel18.setFont(new java.awt.Font("Myriad Pro", 0, 20));
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("s");
        alphaPaneMain.add(jLabel18);
        jLabel18.setBounds(620, 640, 100, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/bigback.jpg"))); // NOI18N
        alphaPaneMain.add(jLabel1);
        jLabel1.setBounds(0, -30, 1310, 800);

        jPanel1.add(alphaPaneMain);
        alphaPaneMain.setBounds(0, 0, 1024, 768);

        alphaPaneResult.setAlpha(1.0F);
        alphaPaneResult.setMinimumSize(new java.awt.Dimension(1024, 768));
        alphaPaneResult.setLayout(null);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/backsleep.jpg"))); // NOI18N
        jButton14.setMaximumSize(new java.awt.Dimension(138, 90));
        jButton14.setMinimumSize(new java.awt.Dimension(138, 90));
        jButton14.setPreferredSize(new java.awt.Dimension(138, 90));
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton14MouseExited(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        alphaPaneResult.add(jButton14);
        jButton14.setBounds(364, 593, 138, 90);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/savesleep.jpg"))); // NOI18N
        jButton15.setMaximumSize(new java.awt.Dimension(138, 90));
        jButton15.setMinimumSize(new java.awt.Dimension(138, 90));
        jButton15.setPreferredSize(new java.awt.Dimension(138, 90));
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton15MouseExited(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        alphaPaneResult.add(jButton15);
        jButton15.setBounds(502, 593, 138, 90);
        alphaPaneResult.add(jLabel12);
        jLabel12.setBounds(240, 280, 550, 230);
        GraphApp app = new GraphApp();
        jLabel12.add(app);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/final.jpg"))); // NOI18N
        jLabel11.setBounds(new java.awt.Rectangle(0, 0, 1024, 768));
        alphaPaneResult.add(jLabel11);
        jLabel11.setBounds(0, 0, 1024, 768);

        jPanel1.add(alphaPaneResult);
        alphaPaneResult.setBounds(0, 0, 1024, 768);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/graphsup.jpg")));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/graphssleep.jpg")));
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/wordsup.jpg")));
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/wordssleep.jpg")));
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
       jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/exitup.jpg")));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
       jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/exitsleep.jpg")));
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchup.jpg")));
        if (buttonCounter==2){
            jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
            }
        else{
            jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep2.jpg")));
        }
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg")));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/bruteup.jpg")));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep2.jpg")));    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));    }//GEN-LAST:event_jButton7MouseExited

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
      jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedyup.jpg")));
        if (buttonCounter==3){
            jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
            }
        else{
            jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep2.jpg")));
        }
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg")));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/bruteup.jpg")));
        if (buttonCounter==5){
            jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
            }
        else{
            jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep2.jpg")));
        }
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseExited
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
    }//GEN-LAST:event_jButton11MouseExited

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
       if (buttonCounter==4){
            jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
            }
        else{
            jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep2.jpg")));
        }
       jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicup.jpg")));
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg")));
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                    jPanel1.removeAll();
                    alphaPaneResult.setAlpha(1.0f);
                    jPanel1.add(alphaPaneResult);
                    jPanel1.revalidate();
                    jPanel1.repaint();
                    jLabel12.removeAll();
                    Graphics();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/bruteup.jpg")));
        if (buttonCounter==1){
            jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
            }
        else{
            jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep2.jpg")));
        }

    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        if (buttonCounter==1){
            jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/bruteup.jpg")));
        }
        else{
            jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));   
        }
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));

    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchup.jpg")));
        if (buttonCounter==2){
            jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
            }
        else{
            jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep2.jpg")));
        }
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        if (buttonCounter==2){
            jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchup.jpg")));
            jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
        }
        else{
            jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg")));
            jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
        }
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedyup.jpg")));
        if (buttonCounter==3){
            jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
            }
        else{
            jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep2.jpg")));
        }
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        if (buttonCounter==3){
            jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedyup.jpg")));
            jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
        }
        else{
            jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg")));
            jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
        }
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicup.jpg")));
        if (buttonCounter==4){
            jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
            }
        else{
            jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep2.jpg")));
        }
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
        if (buttonCounter==4){
            jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicup.jpg")));
            jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
        }
        else{
            jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg")));
            jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
        }
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseEntered
        if (buttonCounter==5){
            jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
            jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/spaceup.jpg")));
            }
        else{
            jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep2.jpg")));
            jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/spacesleep.jpg")));
        }
    }//GEN-LAST:event_jButton13MouseEntered

    private void jButton13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseExited
        if (buttonCounter==5){
            jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/spaceup.jpg")));
            jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
        }
        else{
            jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/spacesleep.jpg")));
            jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
        }
    }//GEN-LAST:event_jButton13MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        switch(buttonCounter){
            case 1:
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 2:
                jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg")));
                jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 3:
                jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg")));
                jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 4:
                jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg")));
                jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 5:
                jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            default:
        }
                buttonCounter = 1;
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/bruteup.jpg")));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        switch(buttonCounter){
            case 1:
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 2:
                jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg")));
                jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 3:
                jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg")));
                jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 4:
                jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg")));
                jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 5:
                jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            default:
        }
        buttonCounter = 1;
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/bruteup.jpg")));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        switch(buttonCounter){
            case 1:
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 2:
                jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg")));
                jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 3:
                jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg")));
                jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 4:
                jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg")));
                jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 5:
                jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            default:
        }
        buttonCounter = 2;
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchup.jpg")));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        switch(buttonCounter){
            case 1:
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 2:
                jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg")));
                jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 3:
                jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg")));
                jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 4:
                jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg")));
                jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 5:
                jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            default:
        }
        buttonCounter = 2;
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchup.jpg")));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        switch(buttonCounter){
            case 1:
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 2:
                jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg")));
                jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 3:
                jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg")));
                jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 4:
                jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg")));
                jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 5:
                jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            default:
        }
        buttonCounter = 3;
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedyup.jpg")));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        switch(buttonCounter){
            case 1:
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 2:
                jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg")));
                jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 3:
                jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg")));
                jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 4:
                jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg")));
                jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 5:
                jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            default:
        }
        buttonCounter = 3;
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedyup.jpg")));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        switch(buttonCounter){
            case 1:
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 2:
                jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg")));
                jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 3:
                jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg")));
                jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 4:
                jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg")));
                jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 5:
                jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            default:
        }
        buttonCounter = 4;
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicup.jpg")));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
        start = System.nanoTime();
        Dynamic approach = new Dynamic();
        System.out.println(LineSize);
        approach.DynamicSolution (wordLenth, sizeL, LineSize);
        finish = System.nanoTime();
        timeElapsed = finish - start;
        double elapsedTimeInSecond = (double) timeElapsed / 1_000_000_000;
        jLabel15.setText(String.valueOf(elapsedTimeInSecond));
        jLabel15.revalidate();
        jLabel15.repaint();
        System.out.println(timeElapsed);
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        switch(buttonCounter){
            case 1:
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 2:
                jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg")));
                jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 3:
                jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg")));
                jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 4:
                jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg")));
                jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 5:
                jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            default:
        }
        buttonCounter = 4;
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicup.jpg")));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        switch(buttonCounter){
            case 1:
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 2:
                jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg")));
                jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 3:
                jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg")));
                jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 4:
                jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg")));
                jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 5:
                jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/spacesleep.jpg")));
                jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            default:
        }
        buttonCounter = 5;
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/spaceup.jpg")));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        switch(buttonCounter){
            case 1:
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 2:
                jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/branchsleep.jpg")));
                jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 3:
                jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/greedysleep.jpg")));
                jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 4:
                jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/dynamicsleep.jpg")));
                jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            case 5:
                jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/brutesleep.jpg")));
                jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiussleep.jpg")));
                break;
            default:
        }
        buttonCounter = 5;
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/bruteup.jpg")));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/radiusup.jpg")));
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseEntered
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/backup.jpg")));
    }//GEN-LAST:event_jButton14MouseEntered

    private void jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseExited
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/backsleep.jpg")));
    }//GEN-LAST:event_jButton14MouseExited

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
                    jPanel1.removeAll();
                    jPanel1.add(alphaPaneMain);
                    jPanel1.revalidate();
                    jPanel1.repaint();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseEntered
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/saveup.jpg")));
    }//GEN-LAST:event_jButton15MouseEntered

    private void jButton15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseExited
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/savesleep.jpg")));
    }//GEN-LAST:event_jButton15MouseExited

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        jLabel16.setText(String.valueOf(jSlider1.getValue()));
        jLabel16.revalidate();
        jLabel16.repaint();
    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        jLabel20.setText(String.valueOf(jSlider2.getValue()));
        jLabel20.revalidate();
        jLabel20.repaint();
    }//GEN-LAST:event_jSlider2StateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        alphaPaneWords.setAlpha(1.0f);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        alphaPaneWords.setAlpha(0.0f);
        try {
            FileScanner f = new FileScanner();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseEntered
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/okup.jpg")));
    }//GEN-LAST:event_jButton16MouseEntered

    private void jButton16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseExited
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/oksleep.jpg")));
    }//GEN-LAST:event_jButton16MouseExited

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    
    public static long timeElapsed;
    public static AnimationController controller;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private advancedalgorithms.AlphaPane alphaPaneIntro;
    private advancedalgorithms.AlphaPane alphaPaneMain;
    private advancedalgorithms.AlphaPane alphaPanePreIntro;
    private advancedalgorithms.AlphaPane alphaPaneResult;
    private advancedalgorithms.AlphaPane alphaPaneWords;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JSlider jSlider1;
    public static javax.swing.JSlider jSlider2;
    // End of variables declaration//GEN-END:variables
}
