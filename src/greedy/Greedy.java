/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedy;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Greedy {
    static String[] line;
    
    static ArrayList<String> wordsss= new ArrayList<>();
    final static int MAX = Integer.MAX_VALUE;
    final static int LineSize = advancedalgorithms.MainJFrame.jSlider1.getValue(); //Line Width
    static int sizeL;
    static int[] wordLenth;
    
    public  ArrayList<String> words= new ArrayList<>();
    public static String solGlo= new String();
    private int count=0;
    public Greedy() {
       
    }
        
    public void start()
    {
     
        String temp = advancedalgorithms.TextEditor.editor.getText();

        
        line = temp.split(" ");
                    int index = 1;
                        for (String s : line) {
                                wordsss.add(s);
                        }
        count=wordsss.size();
        greedy(wordsss);
    }
    
     public void greedy(ArrayList<String> words)
     {
         
         int l=0; //current state of line size
         int m=20; //size of the line with
         int lc=0;
         int totalLineCost=0;//total cost
         int[] lineCostArray=new int[count]; //each line cost
         String solution= "";
         int lcac=0;//count variable to store line cost array
         int tempLenth=0;
 
         for (int k = 0; k < count; k++) {
             
//             tempLenth= tempLenth+wordList[k].length();
             tempLenth=tempLenth +words.get(k).length();
             if (tempLenth <= m)
             {
                 if(k==0)
               solution=solution+words.get(k);// adding word to the line
//               solution[k]+=wordList[k]; 
              
                   if(k!=0)
               solution=solution+" "+words.get(k);// adding word to the line
//             
                 lc=m-tempLenth; //getting current line cost  
               tempLenth++; // adding space charactor
             }
             else
             {
                 lineCostArray[lcac]=lc*lc*lc;
                 totalLineCost=totalLineCost+lineCostArray[lcac];
                 solution=solution+"\n";
                 lc=0;
                 tempLenth=0;
                 lcac++;
             }
         }// end of loof
         
         System.out.println(solution );
         System.out.println(totalLineCost );
         
//         return lineCostArray;
     
    
       advancedalgorithms.TextEditor.editor.setText(solution);
        
          SpaceComplexity(totalLineCost);
    }
    
    public void SpaceComplexity(int totalCost)
    {
     System.out.println("Space Complexity " +totalCost); //total Cost
       
    }
}
