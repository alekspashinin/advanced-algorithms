package advancedalgorithms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


/**
 *
 * @author alekspashinin
 */
public class TextEditor extends JPanel{
    
   
    
    static public JTextPane editor;
    static public JPanel toolbar;
    
    public TextEditor(){
    
            setBounds(0, 0, 580, 250);
            setLayout(new BorderLayout());
            editor = new JTextPane();
            editor.setBounds(0, 0, 580, 250);
            toolbar = new JPanel();
            toolbar.setBounds(0, -6, 430, 90);
            toolbar.setBorder(null);
            setBackground(new java.awt.Color(0, 172, 237,0));
            editor.setBackground(new java.awt.Color(0, 172, 237, 0));
            editor.setCaretColor(new java.awt.Color(255, 255, 255));
            editor.setSelectedTextColor(new java.awt.Color(255, 255, 255));
            editor.setFont(new java.awt.Font("Myriad Pro", 1, 14)); // NOI18N
            editor.setForeground(new java.awt.Color(255, 255, 255));
            editor.setOpaque(true);
            leftborder = new JButton();
            leftborder.setHideActionText(true);
            leftborder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/leftsleep.jpg")));
            leftborder.setBorder(null);
            centerborder = new JButton();
            centerborder.setHideActionText(true);
            centerborder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/centersleep.jpg")));
            centerborder.setBorder(null);
            rightborder = new JButton();
            rightborder.setHideActionText(true);
            rightborder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/rightsleep.jpg")));
            rightborder.setBorder(null);
            editor.setBackground(new java.awt.Color(155, 172, 237, 0));
            editor.setOpaque(false);
            toolbar.setBackground(new java.awt.Color(0, 172, 237, 0));
            toolbar.add(leftborder);
            toolbar.add(centerborder);
            toolbar.add(rightborder);
            add(editor, BorderLayout.CENTER);
            repaint();
            

    leftborder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                leftborderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                leftborderMouseExited(evt);
            } 
        });
    leftborder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftborderActionPerformed(evt);
            }
        });
    
    
    centerborder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                centerborderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                centerborderMouseExited(evt);
            }
        });
    centerborder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                centerborderActionPerformed(evt);
            }
        });

    rightborder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rightborderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rightborderMouseExited(evt);
            }
        });
    rightborder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightborderActionPerformed(evt);
            }
        });
    }
    
    
    private void leftborderMouseEntered(java.awt.event.MouseEvent evt) {                                      
        leftborder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/leftup.jpg")));
    }                                     

    private void leftborderMouseExited(java.awt.event.MouseEvent evt) {                                     
        leftborder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/leftsleep.jpg")));
    }
    
    private void leftborderActionPerformed(java.awt.event.ActionEvent evt) {                                         
                StyledDocument doc = editor.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }      
    
    private void centerborderMouseEntered(java.awt.event.MouseEvent evt) {                                      
        centerborder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/centerup.jpg")));
    }                                     

    private void centerborderMouseExited(java.awt.event.MouseEvent evt) {                                     
        centerborder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/centersleep.jpg")));
    }
    private void centerborderActionPerformed(java.awt.event.ActionEvent evt) {                                         
                StyledDocument doc = editor.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);
    } 
    
    private void rightborderMouseEntered(java.awt.event.MouseEvent evt) {                                      
        rightborder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/rightup.jpg")));
    }                                     

    private void rightborderMouseExited(java.awt.event.MouseEvent evt) {                                     
        rightborder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advancedalgorithms/Images/rightsleep.jpg")));
    }
    private void rightborderActionPerformed(java.awt.event.ActionEvent evt) {                                         
                StyledDocument doc = editor.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);
    } 
    
    
    
    JButton rightborder;
    JButton centerborder;
    JButton leftborder;
}
