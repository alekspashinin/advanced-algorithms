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
    final static int LineSize = 15;
    static int sizeL;
    static String[] line;
    static int[] wordLenth;
  

static void wordLengths() {
		int i =1;
		for (String word : line) {
                        words.add(word);
			wordLenth[i] = word.length();
			i++;
		}
	}    

static int doResult (int p[], int n){
        System.out.println(n);
        System.out.println(p[n-1]);
        int i,k; 
        if (p[n] == 1) 
        k = 1; 
        else
        k = doResult (p, p[n]-1) + 1; 
        for (i=p[n]; i<=n; i++){
            if(wordLenth[i]==0){
            }
            else{
                System.out.print(words.get(i-1)+" ");
            }
        }
        System.out.println();
        return k; 
    }

static int printSolution (int p[], int n) 
    { 
        int k;
        if (p[n] == 1) 
        k = 1; 
        else
        k = printSolution (p, p[n]-1) + 1; 
        System.out.println("Line number" + " " + k + ": " +  
                    "From word no." +" "+ p[n] + " " + "to" + " " + n); 
        return k; 
    } 


static void SpaceOptimizedSolution(int l[], int sizeL, int k){ 
    
    int i, j;
    int currlen; 
    int cost; 
    int dp[] = new int[sizeL]; 
    int ans[] = new int[sizeL]; 
  
    // If only one word is present  
    // then only one line is required.  
    // Cost of last line is zero.  
    // Hence cost of this line is zero.  
    // Ending point is also n-1 as  
    // single word is present. 
    dp[sizeL - 1] = 0; 
    ans[sizeL - 1] = sizeL - 1; 
  
    // Make each word first  
    // word of line by iterating  
    // over each index in arr. 
    for (i = sizeL - 2; i >= 0; i--)  
    { 
        currlen = -1; 
        dp[i] = Integer.MAX_VALUE; 
  
        // Keep on adding words in  
        // current line by iterating  
        // from starting word upto  
        // last word in arr. 
        for (j = i; j < sizeL; j++)  
        { 
  
            // Update number of characters 
            // in current line. arr[j] is 
            // number of characters in 
            // current word and 1 
            // represents space character 
            // between two words. 
            currlen += (l[j+1] + 1); 
  
            // If limit of characters 
            // is violated then no more 
            // words can be added to 
            // current line. 
            if (currlen > k) 
                break; 
  
            // If current word that is 
            // added to line is last 
            // word of arr then current 
            // line is last line. Cost of 
            // last line is 0. Else cost 
            // is square of extra spaces 
            // plus cost of putting line 
            // breaks in rest of words 
            // from j+1 to n-1. 
            if (j == sizeL - 1) 
                cost = 0; 
            else
                cost = (k - currlen) *  
                       (k - currlen) + 
                            dp[j + 1]; 
  
            // Check if this arrangement 
            // gives minimum cost for 
            // line starting with word  
            // arr[i]. 
            if (cost < dp[i]){ 
                dp[i] = cost; 
                ans[i] = j; 
            } 
        } 
    } 
    /* Print Result */
    i = 0;
    while (i < sizeL){
        for (int x=(i + 0);x<ans[i] + 1;x++){
            System.out.print(words.get(x)+" ");
        }
        System.out.println();
        i = ans[i] + 1; 
    }
}

  
/*public static void main(String[] args) {
        String temp = "This is the text just to test my algo and i will see the result";
        line = temp.split(" ");
        wordLenth = new int[line.length+1];
        SpaceOptimized approach = new SpaceOptimized();
        wordLengths();
        sizeL = wordLenth.length-1;
        approach.solveWordWrap (wordLenth, sizeL, LineSize);
    }*/

public SpaceOptimized(){
        String temp = advancedalgorithms.TextEditor.editor.getText();
        System.out.println(temp);
        line = temp.split(" ");
        wordLenth = new int[line.length+1];
        wordLengths();
        sizeL = wordLenth.length-1;
    }
} 