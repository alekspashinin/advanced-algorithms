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

import java.util.ArrayList;



/* Dynamic Programming Solution */
public class Dynamic{ 
  
    /* Declaration of variables */
    static ArrayList<String> words= new ArrayList<>();
    final static int MAX = Integer.MAX_VALUE;
    final static int LineSize = advancedalgorithms.MainJFrame.jSlider1.getValue(); //Line Width
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
    
    
    /* Calculation the lengths of words */
    static void wordLengths() {
		int i =0;
		for (String word : line) {
                        words.add(word);
			wordLenth[i] = word.length();
			i++;
		}
	}
  
    /* Generak function */
    void DynamicSolution (int ListOfWords[], int sizeL, int LineSize){ 
        
        /* Declaration of variables */
        int totalSpaces[][] = new int[sizeL][sizeL]; 
        int lc[][]= new int[sizeL][sizeL]; //PAS BESOINb
        int minCost[] = new int[sizeL+1];
        minCost[0] = 0; 
        int result[] =new int[sizeL]; 
        
        /* Calculation cost of putting words from i to j */
        for (int i = 0; i < sizeL; i++){ 
            totalSpaces[i][i] = LineSize - ListOfWords[i]; 
            for (int j = i+1; j < sizeL; j++){ 
                totalSpaces[i][j] = totalSpaces[i][j-1] - ListOfWords[j] - 1;
            }
        } 
        
        for(int i=0; i < sizeL; i++){
            for(int j=i; j < sizeL; j++){
                if(totalSpaces[i][j] < 0){
                    totalSpaces[i][j] = Integer.MAX_VALUE;
                }else{
                    totalSpaces[i][j] = (int)Math.pow(totalSpaces[i][j], 2);
                }
            }
        }
        
        
        for(int i = sizeL-1; i >= 0 ; i--){
            minCost[i] = totalSpaces[i][sizeL-1];
            result[i] = sizeL;
            for(int j=sizeL-1; j > i; j--){
                if(totalSpaces[i][j-1] == Integer.MAX_VALUE){
                    continue;
                }
                if(minCost[i] > minCost[j] + totalSpaces[i][j-1]){
                    minCost[i] = minCost[j] + totalSpaces[i][j-1];
                    result[i] = j;
                }
            }
        }
        
        advancedalgorithms.TextEditor.editor.setText("");
        doResult(result, sizeL);
        
    }
    
    /*
    public static void main(String[] args) {
        //String temp = advancedalgorithms.MainJFrame.jLabel3.getText();
        String temp = "This is the text just to test";
        line = temp.split(" ");
        wordLenth = new int[line.length];
        Dynamic test = new Dynamic();
        wordLengths();
        System.out.println("wordLenth="+wordLenth.length);
        test.DynamicSolution (wordLenth, wordLenth.length, LineSize);
    }
    */
    
    public Dynamic(){
        String temp = advancedalgorithms.TextEditor.editor.getText();
        System.out.println(temp);
        line = temp.split(" ");
        wordLenth = new int[line.length+1];
        wordLengths();
        sizeL = wordLenth.length-1;
    }

} 