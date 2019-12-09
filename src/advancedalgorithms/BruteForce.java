package advancedalgorithms;


import java.util.ArrayList;

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
    static ArrayList<String> words= new ArrayList<>();
    final static int MAX = Integer.MAX_VALUE;
    final static int LineSize = advancedalgorithms.MainJFrame.jSlider1.getValue(); //Line Width
    static int sizeL;
    static String[] line;
    static int[] wordLenth;
    StringBuilder res = new StringBuilder();
    
    void addResult(){
        advancedalgorithms.TextEditor.editor.setText(advancedalgorithms.TextEditor.editor.getText() + res.toString());
        System.out.println(res.toString());
    }
    
    
    
    void BruteSolution (int ListOfWords[], int sizeL, int LineSize){
        String oneline;
        int start_ind = 0;
        int end_ind = 0;
        int runner = 0;
        int len_of_line = 0;
        int word_num_line = 0;
        int word_num;
        
        
        while (1==1){
            runner = start_ind;
            if (runner >= sizeL){
                break;
            }
            len_of_line = 0;
            word_num_line = 0;
            
            /* find the start and end word indexes for one line */
            while (runner < sizeL){
                len_of_line = len_of_line + ListOfWords[runner];
                word_num_line = word_num_line + 1;
                if (runner != start_ind)
                    len_of_line = len_of_line + 1;
                if (len_of_line > LineSize)
                    break;
                runner = runner + 1;
                
            }
            
            /* justify one line */
            if (runner != sizeL) {
                end_ind = runner - 1;
                if (start_ind == end_ind){  /* one word in a line */
                    oneline = line[start_ind] + " ";
                }
                else {  /* many words in a line */
                    len_of_line = len_of_line - ListOfWords[runner] - 1;
                    word_num = end_ind - start_ind + 1;
                    int extra_spaces = LineSize - (len_of_line - (word_num - 1));
                    int addition_pad_spaces = extra_spaces % (word_num - 1);
                    oneline = "";
                    for(int ind = start_ind; ind <=runner - 1; ind ++ ){
                        oneline = oneline + line[ind] + " ";
                        if (ind - start_ind < addition_pad_spaces)
                            oneline = oneline + " ";
                    }
                }
            }
            /* last line */
            else{
                oneline = "";
                for(int ind = start_ind; ind <=sizeL - 1; ind ++ ){
                    oneline = oneline + line[ind] + " ";
                }
            }
            res.append (oneline);
            res.append("\n");
            start_ind = runner;
        }
        addResult();
    }
    
    /* Calculation the lengths of words */
    static void wordLengths() {
        int i =0;
        for (String word : line) {
            words.add(word);
            wordLenth[i] = word.length();
            i++;
        }
    }
    
    public BruteForce(){
    String temp = advancedalgorithms.TextEditor.editor.getText();
    System.out.println(temp);
    line = temp.split(" ");
    wordLenth = new int[line.length+1];
    wordLengths();
    sizeL = wordLenth.length-1;
    advancedalgorithms.TextEditor.editor.setText(advancedalgorithms.TextEditor.editor.getText() + res.toString());
    System.out.println(res.toString());
    }
    
    /*public static void main(String[] args) {
        //String temp = advancedalgorithms.MainJFrame.jLabel3.getText();
        String temp = "This is the text just to test"; //4*2*3*4*4*2*4//
        line = temp.split(" ");
        wordLenth = new int[line.length];
        BruteForce test = new BruteForce();
        wordLengths();
        System.out.println("wordLenth="+wordLenth.length);
        System.out.println(test.BruteSolution (wordLenth, wordLenth.length, LineSize));
    }*/
    
}
