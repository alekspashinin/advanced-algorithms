/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BranchAndBound;

import java.util.ArrayList;

/**
 *public void
 * @author user
 */
public class BranchInBound {
    
    static String[] line;
    
     static ArrayList<String> words= new ArrayList<>();
    final static int MAX = Integer.MAX_VALUE;
    final static int LineSize = advancedalgorithms.MainJFrame.jSlider1.getValue(); //Line Width
    static int sizeL;
    static int[] wordLenth;
    public BranchInBound()
    {
    }
    
    
    public static void  process(ArrayList<String> wordList)
    {
        
         int line=0; //current state of line size
         int word=0;
         int m=advancedalgorithms.MainJFrame.jSlider1.getValue(); //size of the line with
         int current_cost=0;
         int minCost=m;//total cost\
         int[] cost_array=new int[30];
         String[][] line_word_array= new String[50][20];
         int countOfLoop=0;
         String solution="";
         
         int totalCost=0;
         
         for (int i=0;i < wordList.size(); i++ ) {
             
             
             if(word==0)
		current_cost = m - wordList.get(i).length();
             else
                 current_cost = current_cost - wordList.get(i).length();             
             if (current_cost<=0)
             {
                 cost_array[line]=minCost;
                 
                 line++;
                 word=0;
                 current_cost=0;
                 minCost=10;
                 solution = solution + "\n" ;
                 
                 //first wod insering in new line
                 line_word_array[line][word]=wordList.get(i);
                 if(word==0)//alwways going to e 0 because first word of a new line
                 solution=solution+wordList.get(i);
                 //adding the cost 
                 
                 current_cost = m - wordList.get(i).length();
                 if(minCost > current_cost)
                 {
                     minCost=current_cost;
                 }
                 word++;
             }
             else
             {
                 line_word_array[line][word]=wordList.get(i);
                 
                 if(word==0)
                 solution=solution+wordList.get(i);
                 else
                 solution=solution+" "+ wordList.get(i);   
                
                 word++;
                 if(minCost > current_cost)
                 {
                     minCost=current_cost;
                 }
             }
             countOfLoop++;  
             
             totalCost+= (minCost*minCost*minCost);
             
         };
         
        
         System.out.println(line_word_array);
         
         System.out.println(solution);
         
         advancedalgorithms.TextEditor.editor.setText(solution);
        
          SpaceComplexity(totalCost);
    }
    
    public static void SpaceComplexity(int totalCost)
    {
     System.out.println("Space Complexity " +totalCost); //total Cost
       
    }
    
    public void start()
    {
    
//        String lineOfCurrencies = "USD JPY AUD SGD HKD CAD CHF GBP EURO INR"; String[] currencies = lineOfCurrencies.split(" ");

        String temp = advancedalgorithms.TextEditor.editor.getText();
        line = temp.split(" ");
                    int index = 1;
                        for (String s : line) {
                                words.add(s);
                        }
        process(words);
    
    }
    public static void test()
    {
        String temp = advancedalgorithms.TextEditor.editor.getText();
        ArrayList<String> str=new ArrayList<String>();
            
            process(str);
    }
    
    
  
    
}
