/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author user
 */
public class DAC {
    
    final static int LineSize = advancedalgorithms.MainJFrame.jSlider1.getValue(); //Line Width
    String text = advancedalgorithms.TextEditor.editor.getText();
    StringBuilder res = new StringBuilder();
    
    
    public DAC() throws InterruptedException, IOException{
        
        String LineStr = Integer.toString(LineSize);
        String[] cmd = {"/usr/bin/python", "/Users/DhayanthDharma/NetBeansProjects/AdvancedAlgorithms/src/DAV/DAC.py", text, LineStr};
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
