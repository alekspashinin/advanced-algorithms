/**
 *
 *                    Jean Monnet University
 * 
 *         Rediet Gebretsion Tadesse * Dhayananth Dharmalingam
 *         Poulomy Nandy * Aninda Maulik * Aleksei Pashinin
 *
 *                   Advanced Algorithms Project
 *
 * 
 * 
 */
package advancedalgorithms;

import java.util.ArrayList;



/* Dynamic Programming Solution */
public class Dynamic{ 
  
    /* Declaration of variables */
    static ArrayList<String> words= new ArrayList<>();
    final int MAX = Integer.MAX_VALUE;
    final static int LineSize = 6;
    static int sizeL;
    static String[] line;
    static int[] wordLenth;
    
    
    
    int doResult (int p[], int n){ 
        int i,k; 
        if (p[n] == 1) 
        k = 1; 
        else
        k = doResult (p, p[n]-1) + 1; 
        for (i=p[n]; i<=n; i++){
            if(wordLenth[i]==0){
            }
            else{
                advancedalgorithms.TextEditor.editor.setText(advancedalgorithms.TextEditor.editor.getText() + words.get(i-1)+" ");
                System.out.print(words.get(i-1)+" ");
            }
        }
        advancedalgorithms.TextEditor.editor.setText(advancedalgorithms.TextEditor.editor.getText() + "\n");
        System.out.println();
        return k; 
    }
    
    
    /* Calculation the lengths of words */
    static void wordLengths() {
		int i =1;
		for (String word : line) {
                        words.add(word);
			wordLenth[i] = word.length();
			i++;
		}
	}
  
    /* Generak function */
    void DynamicSolution (int l[], int sizeL, int LineSize){ 
        
        /* Declaration of variables */
        int totalSpaces[][] = new int[sizeL+1][sizeL+1]; 
        int lc[][]= new int[sizeL+1][sizeL+1]; 
        int totalCost[] = new int[sizeL+1];
        totalCost[0] = 0; 
        int p[] =new int[sizeL+1]; 
        
        /* Calculation */
        for (int i = 1; i <= sizeL; i++){ 
            totalSpaces[i][i] = LineSize - l[i-1]; 
            for (int j = i+1; j <= sizeL; j++) 
            totalSpaces[i][j] = totalSpaces[i][j-1] - l[j-1] - 1; 
        } 
          
        for (int i = 1; i <= sizeL; i++){ 
            for (int j = i; j <= sizeL; j++){ 
                if (totalSpaces[i][j] < 0) 
                    lc[i][j] = MAX; 
                else if (j == sizeL && totalSpaces[i][j] >= 0) 
                    lc[i][j] = 0; 
                else
                    lc[i][j] = totalSpaces[i][j]^2; 
            } 
        } 
          
        for (int j = 1; j <= sizeL; j++) { 
            totalCost[j] = MAX; 
            for (int i = 1; i <= j; i++) { 
                if (totalCost[i-1] != MAX && lc[i][j] != MAX &&  
                   (totalCost[i-1] + lc[i][j] < totalCost[j])) { 
                    totalCost[j] = totalCost[i-1] + lc[i][j]; 
                    p[j] = i; 
                } 
            } 
        }
        advancedalgorithms.TextEditor.editor.setText("");
        doResult(p, sizeL);
    }
    
    
    /*public static void main(String[] args) {
        //String temp = advancedalgorithms.MainJFrame.jLabel3.getText();
        String temp = "This is the text just to test my algo and i will see the result";
        line = temp.split(" ");
        wordLenth = new int[line.length+1];
        Dynamic approach = new Dynamic();
        wordLengths();
        int n = wordLenth.length-1;
        System.out.println("n="+n);
        approach.solveWordWrap (wordLenth, n, M);
    }*/
  
    public Dynamic(){
        String temp = advancedalgorithms.TextEditor.editor.getText();
        System.out.println(temp);
        line = temp.split(" ");
        wordLenth = new int[line.length+1];
        wordLengths();
        sizeL = wordLenth.length-1;
    }
} 