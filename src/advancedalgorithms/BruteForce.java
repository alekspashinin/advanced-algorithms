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
    final static int LineSize = advancedalgorithms.MainJFrame.jSlider1.getValue();
    static int sizeL;
    static String[] line;
    static int[] wordLenth;
    
    
    
    void doResult (int result[], int sizeL){ 
        int j, i=0;
        StringBuilder builder = new StringBuilder();
        do{
            j = result[i];
            for(int k=i; k < j; k++){
                builder.append(line[k]+ " ");
            }
            builder.append("\n");
            i = j;
        }while(j < sizeL);
        advancedalgorithms.TextEditor.editor.setText(advancedalgorithms.TextEditor.editor.getText() + builder.toString());
        System.out.println(builder.toString());
    }
    
    void BruteSolution (int ListOfWords[], int sizeL, int LineSize){
        String oneline;
        int start_ind= 0 ;
        int end_ind = 0; 
        int runner = 0;
        int len_of_line = 0;
        int word_num_line = 0;
        int [] res;
        int word_num;
        
        while (1==1){
            runner = start_ind;
            if (runner >= sizeL){
                break;
            }
            len_of_line = 0;
            word_num_line = 0;
            
        }
        
        
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
                    oneline = ListOfWords[start_ind] + " " * (LineSize - ListOfWords[start_ind]);
                }
                else {  /* many words in a line */
                    len_of_line = len_of_line - ListOfWords[runner] - 1;
                    word_num = end_ind - start_ind + 1;
                    extra_spaces = LineSize - (len_of_line - (word_num - 1));
                    basic_pad_spaces = extra_spaces // (word_num - 1)
                    addition_pad_spaces = extra_spaces % (word_num - 1);
                    oneline = "";
                    for(int ind = start_ind; ind <=runner - 1; ind ++ ){
                        oneline = oneline + ListOfWords[ind] + " " * basic_pad_spaces;
                        if (ind - start_ind < addition_pad_spaces)
                            oneline = oneline + " ";
                    }
                    oneline = oneline + ListOfWords[runner - 1];
                }
            }
            /* last line */
            else{
                oneline = "";
                for(int ind = start_ind; ind <=sizeL - 1; ind ++ ){
                    oneline = oneline + ListOfWords[ind] + " "
                            }
                oneline = oneline + ListOfWords[sizeL - 1]
                pad_spaces = LineSize - len ( oneline );
                oneline = oneline + " " * pad_spaces;
                        }

            res.append (oneline);
            start_ind = runner;
                    }

        return res
        
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
    }
    
}
