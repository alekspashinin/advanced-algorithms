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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author alekspashinin
 */
public class BruteForce {
    
    /* Declaration of variables */
    final static int LineSize = advancedalgorithms.MainJFrame.jSlider1.getValue(); //Line Width
    String text = advancedalgorithms.TextEditor.editor.getText();
    StringBuilder res = new StringBuilder();
    
    
    public BruteForce() throws InterruptedException, IOException{
        
        String LineStr = Integer.toString(LineSize);
        String[] cmd = {"/usr/bin/python", "/Users/alekspashinin/NetBeansProjects/AdvancedAlgorithms/src/advancedalgorithms/BruteForce.py", text, LineStr};
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();

        String lineP = "", output = "";
        StringBuilder res = new StringBuilder();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((lineP = br.readLine())!= null) {
            res = res.append(lineP).append("\n"); 
        }
        advancedalgorithms.TextEditor.editor.setText("");
        output = res.toString();
        advancedalgorithms.TextEditor.editor.setText(advancedalgorithms.TextEditor.editor.getText() + res.toString());
        System.out.println(output);
    }
    
}
