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


/* Space Optimized Solution */  
public class SpaceOptimized{
    
    /* Declaration of variables */
    static ArrayList<String> words= new ArrayList<>();
    final int MAX = Integer.MAX_VALUE;
    final static int LineSize = advancedalgorithms.MainJFrame.jSlider1.getValue();
    static int sizeL;
    static String[] line;
    static int[] wordLenth;
  
/* Calculation the lengths of words */
static void wordLengths() {
		int i =1;
		for (String word : line) {
                        words.add(word);
			wordLenth[i] = word.length();
			i++;
		}
	}    

/* Printing results */
void doResult (int result[], int sizeL){ 
        int i=0;
        StringBuilder builder = new StringBuilder();
        do{
            for(int k=i; k < result[i]+1; k++){
                builder.append(line[k]+ " ");
            }
            builder.append("\n");
            i = result[i] + 1;
        }while(i < sizeL);
        //System.out.println(builder.toString());
        advancedalgorithms.TextEditor.editor.setText(advancedalgorithms.TextEditor.editor.getText() + builder.toString());
    }


/* General function */
void SpaceOptimizedSolution(int ListOfWords[], int sizeL, int SizeLine){ 
    
    int i, j;
    int nbOfCaracters; 
    int minCost; 
    int minCostLine[] = new int[sizeL];
    int result[] = new int[sizeL];
    
    System.out.println(sizeL);
  
    minCostLine[sizeL - 1] = 0; 
    result[sizeL - 1] = sizeL - 1; 
  
    for (i = sizeL - 2; i >= 0; i--){ 
        nbOfCaracters = -1; 
        minCostLine[i] = Integer.MAX_VALUE; 
        for (j = i; j < sizeL; j++){ 
            nbOfCaracters += (ListOfWords[j+1] + 1); 
            if (nbOfCaracters > SizeLine){ 
                break; 
            }
            if (j == sizeL - 1){ 
                minCost = 0;
            }
            else{
                minCost = (SizeLine - nbOfCaracters)*(SizeLine - nbOfCaracters)+minCostLine[j + 1];
            }
            if (minCost < minCostLine[i]){ 
                minCostLine[i] = minCost; 
                result[i] = j; 
            } 
        } 
    } 
    advancedalgorithms.TextEditor.editor.setText("");
    doResult(result, sizeL);
    }

/*public static void main(String[] args) {
        String temp = "This is the text just to test my algo and i will see the result";
        line = temp.split(" ");
        wordLenth = new int[line.length+1];
        SpaceOptimized approach = new SpaceOptimized();
        wordLengths();
        sizeL = wordLenth.length-1;
        approach.SpaceOptimizedSolution (wordLenth, sizeL, LineSize);
    }*/



public SpaceOptimized(){
        String temp = advancedalgorithms.TextEditor.editor.getText();
        System.out.println(temp);
        line = temp.split(" ");
        wordLenth = new int[line.length+1];
        wordLengths();
        sizeL = wordLenth.length-1;
        System.out.println("INT-O="+sizeL);
    }

} 