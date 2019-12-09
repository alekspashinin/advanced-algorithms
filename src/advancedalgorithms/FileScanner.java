/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedalgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alekspashinin
 */
public class FileScanner {
    
    static String[] words;
    //File f;
    Scanner in;
    
    
    public FileScanner() throws FileNotFoundException{
    //f = new File("text.txt");
    in = new Scanner(new FileReader("words.txt"));
    words = in.nextLine().split(" ");
    
    int j, i=0;
    StringBuilder builder = new StringBuilder();
        for(int k=i; k < advancedalgorithms.MainJFrame.jSlider2.getValue(); k++){
            builder.append(words[k]+ " ");
        }
        advancedalgorithms.TextEditor.editor.setText("");
        advancedalgorithms.TextEditor.editor.setText(advancedalgorithms.TextEditor.editor.getText() + builder.toString());
    }
}
